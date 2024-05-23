package duarte.pereira.appbasket.feature_basket.presentation.app_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import duarte.pereira.appbasket.feature_basket.data.di.IoDispatcher
import duarte.pereira.appbasket.feature_basket.domain.use_cases.BasketUseCaseResult
import duarte.pereira.appbasket.feature_basket.domain.use_cases.BasketUseCases
import duarte.pereira.appbasket.feature_basket.domain.util.Order
import duarte.pereira.appbasket.feature_basket.domain.util.Sort
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val basketUseCases: BasketUseCases,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
): ViewModel() {
    private val _appList = mutableStateOf(AppListState(order = Order.Downloads(sort = Sort.Down)))
    val appList: State<AppListState> = _appList

    private var getAppItemsJob: Job? = null
    private val errorHandler = CoroutineExceptionHandler {_, e ->
        e.printStackTrace()
        _appList.value = _appList.value.copy(
            error = e.message,
            isLoading = false
        )
    }

    fun onSort(order: Order) {
        val alreadyOrdered =
            _appList.value.order::class == order::class && _appList.value.order.sort == order.sort
        if(alreadyOrdered){
            return
        }
        _appList.value = _appList.value.copy(
            order = order
        )
        getAppItems()
    }

    /**
     * Retrieves app items asynchronously from the repository using BasketUseCases. Cancels any
     * previously running job to avoid redundant calls. Upon successful retrieval, updates the
     * State of _appList with the retrieved app items, order, and sets isLoading flag to false.
     * In case of an error during retrieval, updates _appList with an error label and sets
     * isLoading flag to false. Uses the provided coroutine dispatcher and errorHandler to
     * handle coroutine execution and errors respectively.
     */
    fun getAppItems(){
        getAppItemsJob?.cancel()

        getAppItemsJob = viewModelScope.launch(dispatcher + errorHandler) {
            val result = basketUseCases.getAllAppItems(
                order = _appList.value.order
            )
            when(result){
                is BasketUseCaseResult.Success -> {
                    _appList.value = _appList.value.copy(
                        appItems = result.appItems,
                        order = _appList.value.order,
                        isLoading = false
                    )

                }
                is BasketUseCaseResult.Error -> {
                    _appList.value = _appList.value.copy(
                        error = ERROR_LABEL,
                        isLoading = false
                    )
                }
            }
        }
    }

    private companion object {
        const val ERROR_LABEL = "Error: cant get apps"
    }
}
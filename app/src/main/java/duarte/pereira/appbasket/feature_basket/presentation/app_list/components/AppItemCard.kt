package duarte.pereira.appbasket.feature_basket.presentation.app_list.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import duarte.pereira.appbasket.core.presentation.components.DownloadButton
import duarte.pereira.appbasket.core.presentation.components.RoundedAsyncImage
import duarte.pereira.appbasket.core.presentation.util.numberFormatter
import duarte.pereira.appbasket.feature_basket.domain.model.AppItem
import duarte.pereira.appbasket.feature_basket.presentation.app_details.DialogWithBanner
import duarte.pereira.appbasket.ui.theme.AppBasketTheme

@Composable
fun AppItemCard(
    appItem: AppItem,
    modifier: Modifier = Modifier,
    currentContext: Context
) {
    var showDialog by remember { mutableStateOf(false) }

    Card(
        onClick = { showDialog = true },
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .width(180.dp)
            .height(260.dp)
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f)
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 14.dp, bottom = 12.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RoundedAsyncImage(
                imageUrl = appItem.icon,
                size = 140.dp
            )
            Spacer(modifier = Modifier.height(8.dp))
            AppCardInfo(appItem)
        }
    }
    if (showDialog) {
        DialogWithBanner(
            appItem = appItem,
            context = currentContext
        ) { showDialog = false }
    }
}

@Composable
fun AppCardInfo(appItem: AppItem) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = appItem.name,
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 16.sp,
            maxLines = 2
        )
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(imageVector = Icons.Default.Star, contentDescription = "")
                Text(
                    text = appItem.rating.toString(),
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 12.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = numberFormatter(appItem.downloads),
                    style = MaterialTheme.typography.labelSmall,
                    fontSize = 12.sp
                )
                DownloadButton(size = 32.dp, isDownloaded = false, onClick = { })
            }

        }

    }
}

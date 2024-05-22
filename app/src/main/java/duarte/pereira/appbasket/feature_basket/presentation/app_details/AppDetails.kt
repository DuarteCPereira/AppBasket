package duarte.pereira.appbasket.feature_basket.presentation.app_details

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import coil.request.ImageRequest
import duarte.pereira.appbasket.core.presentation.util.bytesToGb
import duarte.pereira.appbasket.core.presentation.util.numberFormatter
import duarte.pereira.appbasket.feature_basket.domain.model.AppItem

@Composable
fun DialogWithBanner(
    appItem: AppItem,
    context: Context,
    onDismissRequested: () -> Unit
) {
    Dialog(
        onDismissRequest = { onDismissRequested() },
    ) {
        Card(shape = RoundedCornerShape(8.dp), modifier = Modifier.padding(8.dp)) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(appItem.graphic)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier.padding(start = 16.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = appItem.name,
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 24.sp // Increasing the font size
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Column(verticalArrangement = Arrangement.Bottom) {
                            Text(text = "Size: ${bytesToGb(appItem.size)}")
                            Text(text = "Users: ${numberFormatter(appItem.downloads)}")
                        }
                        Button(
                            onClick = {
                                Toast.makeText(
                                    context,
                                    "Download functionality is not available in demo mode",
                                    Toast.LENGTH_LONG
                                ).show()
                            },
                            modifier = Modifier.align(Alignment.Bottom)
                        ) {
                            Text(text = "Download")
                        }
                    }
                }
            }
        }
    }
}

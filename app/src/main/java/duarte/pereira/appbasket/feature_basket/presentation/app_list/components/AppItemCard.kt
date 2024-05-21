package duarte.pereira.appbasket.feature_basket.presentation.app_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import duarte.pereira.appbasket.core.presentation.components.DownloadButton
import duarte.pereira.appbasket.core.presentation.components.RoundedAsyncImage
import duarte.pereira.appbasket.feature_basket.domain.model.AppItem
import duarte.pereira.appbasket.ui.theme.AppBasketTheme

@Composable
fun AppItemCard(
    appItem: AppItem,
    onDownloadClick: () -> Unit,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onCardClick,
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .width(180.dp)
            .height(280.dp)
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f)
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 14.dp, bottom = 12.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RoundedAsyncImage(
                imageUrl = /*appItem.iconUrl*/"https://pool.img.aptoide.com/mark8/503af45aacb9c6b520e4856e3ae1bf35_icon.png",
                size = 140.dp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "appItem.name",
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
                        modifier = Modifier
                            .padding(top = 4.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Star, contentDescription = "")
                        Text(
                            text = "3.5",
                            style = MaterialTheme.typography.labelSmall,
                            fontSize = 14.sp
                        )
                    }
                    DownloadButton(size = 32.dp, isDownloaded = false, onClick = onDownloadClick)
                }

            }
        }
    }
}

@Preview
@Composable
fun AppItemCardPreview() {
    AppBasketTheme {
        AppItemCard(
            AppItem(
                name = "Google Maps",
                packageName = "com.google.googlemaps",
                icon = 1.toString(),
                graphic = 1.toString(),
                id = 1,
                downloads = 1,
                rating = 1.0,
                size = 1
            ),
            onCardClick = {},
            onDownloadClick = {}
        )
    }
}

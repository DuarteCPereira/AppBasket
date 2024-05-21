package duarte.pereira.appbasket.core.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import duarte.pereira.appbasket.R

@Composable
fun DownloadButton(
    onClick: () -> Unit,
    isDownloaded: Boolean,
    size: Dp,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = { onClick() },
        modifier = modifier.size(size)
    ) {
        Icon(
            imageVector = Icons.Default.Download,
            contentDescription = stringResource(id = R.string.download_button),
            tint = if (isDownloaded) Color.Green else Color.Gray,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
fun DownloadButtonPreview() {
    DownloadButton(
        onClick = { },
        size = 64.dp,
        isDownloaded = false,
    )
}

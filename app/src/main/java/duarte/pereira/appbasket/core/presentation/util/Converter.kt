package duarte.pereira.appbasket.core.presentation.util

fun numberFormatter(number: Long): String {
    return when {
        number >= 1_000_000 -> String.format("%.1fM", number / 1_000_000.0)
        number >= 1_000 -> String.format("%.1fK", number / 1_000.0)
        else -> number.toString()
    }
}

fun bytesToGb(bytes: Long): String {
    val gigaByte = 1024.0 * 1024.0 * 1024.0

    val size = bytes / gigaByte

    return String.format("%.2f %s", size, "Gb")
}

package net.codecision.glidebarcode.model

import com.google.zxing.BarcodeFormat

data class Barcode(
    val contents: String,
    val format: BarcodeFormat,
    var contentColor: Int,
    var backgroundColor: Int
) {

    constructor(
        contents: String,
        format: BarcodeFormat
    ) : this(
        contents,
        format,
        BLACK,
        WHITE
    )

    companion object {
        private const val WHITE = 0xFFFFFFFF.toInt()
        private const val BLACK = 0xFF000000.toInt()
    }

}
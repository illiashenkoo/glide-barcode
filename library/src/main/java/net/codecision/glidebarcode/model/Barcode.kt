package net.codecision.glidebarcode.model

import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType

data class Barcode(
    val contents: String,
    val format: BarcodeFormat,
    var contentColor: Int,
    var backgroundColor: Int,
    var hints: Map<EncodeHintType, *>? = null
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

    constructor(
        contents: String,
        format: BarcodeFormat,
        hints: Map<EncodeHintType, *>
    ) : this(
        contents,
        format,
        BLACK,
        WHITE,
        hints
    )

    companion object {
        private const val WHITE = 0xFFFFFFFF.toInt()
        private const val BLACK = 0xFF000000.toInt()
    }

}
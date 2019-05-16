package net.codecision.glidebarcode.load

import android.graphics.Bitmap
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.data.DataFetcher
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.google.zxing.common.CharacterSetECI
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
import net.codecision.glidebarcode.model.Barcode
import java.util.*

class BarcodeDataFetcher(
    private val barcode: Barcode,
    private val width: Int,
    private val height: Int
) : DataFetcher<Bitmap> {

    override fun getDataClass() = Bitmap::class.java

    override fun getDataSource() = DataSource.LOCAL

    override fun cancel() {
        // Intentionally empty.
    }

    override fun cleanup() {
        // Intentionally empty.
    }

    override fun loadData(priority: Priority, callback: DataFetcher.DataCallback<in Bitmap>) {
        try {
            val barcodeBitmap = generateBarcode(barcode, width, height)
            callback.onDataReady(barcodeBitmap)
        } catch (exception: WriterException) {
            callback.onLoadFailed(exception)
        }
    }

    @Throws(WriterException::class)
    private fun generateBarcode(barcode: Barcode, width: Int, height: Int): Bitmap {
        val hints = EnumMap<EncodeHintType, Any>(EncodeHintType::class.java)
        hints[EncodeHintType.ERROR_CORRECTION] = ErrorCorrectionLevel.H
        hints[EncodeHintType.CHARACTER_SET] = CharacterSetECI.UTF8
        hints[EncodeHintType.MARGIN] = 0

        val safetyWidth = if (width == 0) DEFAULT_BARCODE_SIZE else width
        val safetyHeight = if (height == 0) DEFAULT_BARCODE_SIZE else height

        val formatWriter = MultiFormatWriter()
        val bitMatrix = formatWriter.encode(
            barcode.contents,
            barcode.format,
            safetyWidth,
            safetyHeight,
            hints
        )

        return createBitmap(bitMatrix, barcode.contentColor, barcode.backgroundColor)
    }

    private fun createBitmap(
        matrix: BitMatrix,
        contentColor: Int,
        backgroundColor: Int
    ): Bitmap {
        val width = matrix.width
        val height = matrix.height
        val pixels = IntArray(width * height)

        for (y in 0 until height) {
            val offset = y * width
            for (x in 0 until width) {
                pixels[offset + x] = if (matrix.get(x, y)) contentColor else backgroundColor
            }
        }

        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height)
        return bitmap
    }

    companion object {

        private const val DEFAULT_BARCODE_SIZE = 1024

    }
}
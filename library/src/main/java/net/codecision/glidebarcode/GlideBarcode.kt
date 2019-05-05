package net.codecision.glidebarcode

import android.graphics.Bitmap
import com.bumptech.glide.Registry
import net.codecision.glidebarcode.load.BarcodeModelLoaderFactory
import net.codecision.glidebarcode.model.Barcode

open class GlideBarcode {

    companion object {

        fun registerFactory(registry: Registry) {
            registry.prepend(
                Barcode::class.java,
                Bitmap::class.java,
                BarcodeModelLoaderFactory()
            )
        }

    }

}
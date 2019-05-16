package net.codecision.glidebarcode.load

import android.graphics.Bitmap
import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.load.model.ModelLoaderFactory
import com.bumptech.glide.load.model.MultiModelLoaderFactory
import net.codecision.glidebarcode.model.Barcode

class BarcodeModelLoaderFactory : ModelLoaderFactory<Barcode, Bitmap> {

    override fun build(multiFactory: MultiModelLoaderFactory): ModelLoader<Barcode, Bitmap> {
        return BarcodeModelLoader()
    }

    override fun teardown() {
        // Do nothing.
    }

}
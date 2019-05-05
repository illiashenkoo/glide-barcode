package net.codecision.glidebarcode.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.zxing.BarcodeFormat
import kotlinx.android.synthetic.main.activity_main.*
import net.codecision.glidebarcode.model.Barcode

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFirstQr()

        showSecondQr()

        showEan13()
    }

    private fun showFirstQr() {
        val barcode = Barcode("QrCode", BarcodeFormat.QR_CODE)
        barcode.contentColor = ContextCompat.getColor(this, R.color.red)

        Glide.with(this)
            .load(barcode)
            .into(firstQrView)
    }

    private fun showSecondQr() {
        val barcode = Barcode("Glide", BarcodeFormat.QR_CODE)

        Glide.with(this)
            .load(barcode)
            .into(secondQrView)
    }

    private fun showEan13() {
        val barcode = Barcode("978020137962", BarcodeFormat.EAN_13)
        barcode.contentColor = ContextCompat.getColor(this, R.color.yellow)

        Glide.with(this)
            .load(barcode)
            .into(ean13View)
    }

}



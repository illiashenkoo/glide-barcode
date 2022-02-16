package net.codecision.glidebarcode.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.zxing.BarcodeFormat
import net.codecision.glidebarcode.model.Barcode
import net.codecision.glidebarcode.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        showFirstQr()

        showSecondQr()

        showEan13()
    }

    private fun showFirstQr() {
        val barcode = Barcode("QrCode", BarcodeFormat.QR_CODE)
        barcode.contentColor = ContextCompat.getColor(this, R.color.red)

        Glide.with(this)
            .load(barcode)
            .into(binding.firstQrView)
    }

    private fun showSecondQr() {
        val barcode = Barcode("Glide", BarcodeFormat.QR_CODE)

        Glide.with(this)
            .load(barcode)
            .into(binding.secondQrView)
    }

    private fun showEan13() {
        val barcode = Barcode("978020137962", BarcodeFormat.EAN_13)
        barcode.contentColor = ContextCompat.getColor(this, R.color.yellow)

        Glide.with(this)
            .load(barcode)
            .into(binding.ean13View)
    }

}



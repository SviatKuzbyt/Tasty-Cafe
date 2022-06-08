package com.sviatkuzbyt.tastycafe

import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.QRCodeWriter

class QRcodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode)

        //Встановлення тексту
        var stringOrder = ""
        listOrders.forEach { stringOrder += "${it.id}_${it.number} " }

        //встановлюю код
        val imageQR = findViewById<ImageView>(R.id.imageQR)
        imageQR.setImageBitmap(getQrCodeBitmap(stringOrder))

        //встановлюю кнопку "Назад"
        val closeQr = findViewById<TextView>(R.id.closeQr)
        closeQr.setOnClickListener { finish() }

    }

    //Функція встановлення QR коду
    fun getQrCodeBitmap(str: String): Bitmap {
        val size = 512 //pixels
        val hints = hashMapOf<EncodeHintType, Int>().also { it[EncodeHintType.MARGIN] = 1 } // Make the QR code buffer border narrower
        val bits = QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, size, size)
        return Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565).also {
            for (x in 0 until size) {
                for (y in 0 until size) {
                    it.setPixel(x, y, if (bits[x, y]) Color.BLACK else Color.WHITE)
                }
            }
        }
    }
}
package com.aoihosizora.wifibridgetile

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // val permission = "huawei.android.permission.HW_SIGNATURE_OR_SYSTEM"
        // if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
        //     ActivityCompat.requestPermissions(this, arrayOf(permission), 0)
        // }

        btn_open.setOnClickListener {
            try {
                val intent = Intent()
                // com.android.settings.Settings$WifiSettingsActivity WLAN設定
                // com.android.settings.Settings$WifiBridgeSettingsActivity WLANブリッジ設定
                // com.android.settings.Settings$TetherSettingsActivity テザリングとポータブルアクセス
                // com.android.settings.Settings$TetherSettings テザリングとポータブルアクセス
                intent.setClassName("com.android.settings", "com.android.settings.Settings\$TetherSettingsActivity")
                startActivity(intent)
            } catch (ex: Exception) {
                Toast.makeText(this, ex.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    // override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
    //     super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    //     if (requestCode == 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
    //         Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
    //         finish()
    //     }
    // }
}

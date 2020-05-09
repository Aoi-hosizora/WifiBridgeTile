package com.aoihosizora.wifibridgetile

import android.content.Intent
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import android.widget.Toast

class AppTileService : TileService() {

    override fun onCreate() {
        super.onCreate()
        initTile()
    }

    override fun onTileAdded() {
        super.onTileAdded()
        initTile()
    }

    override fun onStartListening() {
        super.onStartListening()
        initTile()
    }

    override fun onClick() {
        super.onClick()
        try {
            val intent = Intent()
            // com.android.settings.Settings$WifiSettingsActivity WLAN設定
            // com.android.settings.Settings$WifiBridgeSettingsActivity WLANブリッジ設定
            // com.android.settings.Settings$TetherSettingsActivity テザリングとポータブルアクセス
            // com.android.settings.Settings$TetherSettings テザリングとポータブルアクセス
            intent.setClassName("com.android.settings", "com.android.settings.Settings\$TetherSettingsActivity")
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        } catch (ex: Exception) {
            Toast.makeText(this, ex.message, Toast.LENGTH_SHORT).show()
        }

        sendBroadcast(Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS))
    }

    private fun initTile() {
        qsTile?.run {
            label = "テザリングとポータブルアクセス"
            state = Tile.STATE_INACTIVE
            updateTile()
        }
    }
}
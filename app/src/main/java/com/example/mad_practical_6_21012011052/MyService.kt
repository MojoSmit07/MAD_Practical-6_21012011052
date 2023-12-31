package com.example.mad_practical_6_21012011052

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MyService : Service() {
    val PLAYERCONSTANT = "PLAY/PAUSE"
    companion object{
        val PLAYERCONSTANT = "PLAY/PAUSE"
    }
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")

    }
    lateinit var player: MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (!this::player.isInitialized){
            player=MediaPlayer.create(this, R.raw.unstoppable)
        }
        if (intent!=null){
         val command = intent.getStringExtra(PLAYERCONSTANT)

        }

        else{
            player.stop()
        }
        if (!player.isPlaying){
            player.start()
        }
        else{
            player.pause()
        }

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }
}
package com.example.mad_practical_6_21012011052

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start : Button = findViewById(R.id.play_button)
        start.setOnClickListener{
            play()
        }

        val stop : Button = findViewById(R.id.stop_button)
        stop.setOnClickListener{
            pause()
        }
    }

    fun play(){
        val intent = Intent(this, MyService::class.java)
        intent.putExtra(MyService.PLAYERCONSTANT, "PLAY")
        startService(intent)
    }

    fun pause(){
        val intent = Intent(this, MyService::class.java)
        intent.putExtra(MyService.PLAYERCONSTANT, "PAUSE")
        startService(intent)
    }
}

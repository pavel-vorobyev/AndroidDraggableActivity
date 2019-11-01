package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        val mediaPlayer = MediaPlayer()

        movement.setOnClickListener {
            val i = Intent(this, SecondActivity::class.java)
            startActivity(i)
        }

        button.setOnClickListener {
            mediaPlayer.setDataSource(edittext.text.toString())
            mediaPlayer.prepare()
            mediaPlayer.start()
//            val i = Intent(this, SecondActivity::class.java)
//            startActivity(i)
//
//            Handler().postDelayed({
//                button.text = "sdf"
//
//                Handler().postDelayed({
//                    button.text = "fh"
//
//                    Handler().postDelayed({
//                        button.text = "uuy"
//
//                        Handler().postDelayed({
//                            button.text = "bnb"
//                        }, 4000)
//                    }, 4000)
//                }, 4000)
//            }, 4000)
        }
    }
}

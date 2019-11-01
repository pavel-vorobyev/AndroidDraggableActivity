package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_two.*

class SecondActivity: Activity(), View.OnTouchListener {

    private var dx: Float = 0.0f
    private var dy: Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)


        view.setOnTouchListener(this)
        child.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                return true
            }

        })
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        val x = event?.rawX
        val y = event?.rawY

        when(event?.action) {
            MotionEvent.ACTION_DOWN -> {
                dx = view.x - event.rawX;
                dy = view.y - event.rawY;
            }
            MotionEvent.ACTION_MOVE -> {
                view.animate()
                    .x(event.rawX + dx)
                    .y(event.rawY + dy)
                    .setDuration(0)
                    .start()

                println("x +$x")
                println("y $y")
            }
            MotionEvent.ACTION_UP -> {
                view.animate()
                    .x(0f)
                    .y(0f)
                    .setDuration(250)
                    .start()
            }
        }

        root.invalidate()
        return true
    }

}
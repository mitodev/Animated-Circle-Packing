package com.example.animatedcirclepacking

import processing.core.PApplet

class Sketch : PApplet() {

    override fun setup() {

    }
    override fun draw() {
        strokeWeight(10f)
        line(0f,0f,width.toFloat(),height.toFloat())
        line(width.toFloat(),0f,0f,height.toFloat())
    }
}
package com.example.animatedcirclepacking

import processing.core.PApplet
import com.example.animatedcirclepacking.AndroidParticles.Particle
import java.util.ArrayList

class AndroidParticles : PApplet() {
    var particles: ArrayList<Particle>? = null
    override fun settings() {
        fullScreen()
    }

    override fun setup() {
        background(255)
        particles = ArrayList()
    }

    override fun mouseReleased() {
        val part = Particle(mouseX - width / 2, mouseY - height / 2)
        particles!!.add(part)
    }

    override fun draw() {
        background(255)
        pushMatrix()
        translate((width / 2).toFloat(), (height / 2).toFloat())
        ellipse(0f, 0f, 50f, 50f)
        if (particles!!.size > 1) {
            for (i in particles!!.indices) {
                particles!![i].update()
                particles!![i].show()
            }
        }
        popMatrix()
    }

    //public class Particle extends PApplet {///MODIF!!!
    inner class Particle(var x: Int, var y: Int) {
        var history = ArrayList<IntArray>()
        fun update() {
            x += random(-10f, 10f).toInt()
            y += random(-10f, 10f).toInt()
            history.add(intArrayOf(x, y))
            if (history.size > 100) {
                history.removeAt(0)
            }
        }

        fun show() {
            stroke(0)
            fill(0, 150f)
            ellipse(x.toFloat(), y.toFloat(), 12f, 12f)
            noFill()
            beginShape()
            for (i in history.indices) {
                val pos = history[i]
                vertex(pos[0].toFloat(), pos[1].toFloat())
            }
            endShape()
        }

        init {
            history.add(intArrayOf(x, y))
            println(x)
        }
    }
}
package com.example.animatedcirclepacking

import android.util.Log
import processing.core.PApplet
import java.util.ArrayList

class Sketch : PApplet() {

    lateinit var circles: ArrayList<Circle>

    override fun setup() {

        circles = ArrayList()
    }

    override fun draw() {

        background(0)

        var total = 10
        var count = 0
        var attempts = 0

        while (count<total){
            var newC = newCircle()
            if (newC!=null){
                newCircle()
                count += 1
            }
            attempts +=1
            if (attempts>1000){
                noLoop()
                break
            }
        }


        for (c:Circle in circles){

            if (c.growing){
                if (c.edges()){
                    c.growing=false
                }else{
                    for (other:Circle in circles){
                        if (c!=other){
                            var d = dist(c.x,c.y,other.x,other.y)
                            if (d-2<c.r+other.r){
                                c.growing = false
                                break
                            }
                        }
                    }
                }
            }
            c.show()
            c.grow()
        }

    }

    fun newCircle(){

        val x=random(width.toFloat())
        val y=random(height.toFloat())

        var valid = true

        for(c:Circle in circles)
        {
            var d = dist(x,y,c.x,c.y)
            if(d<c.r){
                valid = false
                break
            }
        }
        if (valid) {
            circles.add(Circle(x,y))
        }

    }

    inner class Circle(x_: Float, y_: Float) {

        var x = x_
        var y = y_
        var r = 1f

        var growing = true

       fun edges(): Boolean {
           return r>=x||r+x>=width||r>=y||r+y>=height
       }
        fun grow(){
            if(growing){
                r += 1}
        }
        fun show(){
            stroke(255)
            noFill()
            ellipse(x,y,r*2,r*2)
        }
    }
}

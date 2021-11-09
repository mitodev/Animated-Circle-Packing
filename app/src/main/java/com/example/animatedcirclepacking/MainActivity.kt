package com.example.animatedcirclepacking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import processing.android.CompatUtils
import processing.android.PFragment
import processing.core.PApplet

class MainActivity : AppCompatActivity() {

    private lateinit var sketch : PApplet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val frame = FrameLayout(this)
        frame.id = CompatUtils.getUniqueViewId()
        setContentView(frame, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))

        sketch = Sketch()
        val fragment = PFragment(sketch)
        fragment.setView(frame, this)
    }

    //region init the sketch
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        sketch.onRequestPermissionsResult(
            requestCode, permissions, grantResults
        )
    }
    public override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        sketch.onNewIntent(intent)
    }
    //endregion
}
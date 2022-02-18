package com.oddinstitute.simplebitmapdrawing

import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.graphics.BitmapFactory

import android.graphics.Bitmap
import java.io.InputStream
import android.content.res.AssetManager





class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val options = BitmapFactory.Options()
        options.inPreferredConfig = Bitmap.Config.ARGB_8888



        val istr = this.assets.open("cat_pumpkin.png")
        val bitmap = BitmapFactory.decodeStream(istr)
        istr.close()
        val drawView = DrawView(bitmap,this)
        findViewById<FrameLayout>(R.id.canvasId).addView(drawView)
    }
}

class DrawView(val bitmap: Bitmap, context: Context) : View(context)
{
    var paint: Paint = Paint()
    init
    {
        paint.color = Color.RED
        paint.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas)
    {
        canvas.drawBitmap(bitmap, 50f, 50f, null)
    }
}

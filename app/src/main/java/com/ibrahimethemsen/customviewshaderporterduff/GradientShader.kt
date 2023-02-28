package com.ibrahimethemsen.customviewshaderporterduff

import android.content.Context
import android.graphics.*
import android.graphics.Shader.TileMode
import android.util.AttributeSet
import android.view.View

class GradientShader @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null
) : View(context, attributeSet) {
    private val shaderLinear = LinearGradient(0.0f,0.0f,400f,400f, Color.RED,Color.GREEN,TileMode.CLAMP)
    private val shaderRadial = RadialGradient(200f,600f,100f,Color.RED,Color.BLUE,TileMode.CLAMP)
    private val shaderSweep = SweepGradient(200f,1000f,Color.RED,Color.BLUE)
    private val shaderClamp = LinearGradient(400f,1000.0f,800f,1400f,Color.RED,Color.BLUE,TileMode.CLAMP)
    private val shaderMirror = LinearGradient(0f,0.0f,100f,100f,Color.RED,Color.BLUE,TileMode.MIRROR)
    private val shaderRepeat = LinearGradient(0f,0.0f,100f,100f,Color.RED,Color.BLUE,TileMode.REPEAT)
    private val paintL = Paint().apply {
        shader = shaderLinear
    }
    private val paintR = Paint().apply {
        shader = shaderRadial
    }
    private val paintS = Paint().apply {
        shader = shaderSweep
    }
    private val paintRepeat = Paint().apply {
        shader = shaderRepeat
    }
    private val paintMirror = Paint().apply {
        shader = shaderMirror
    }
    private val paintClamp = Paint().apply {
        shader = shaderClamp
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(200f,200f,200f,paintL)
        canvas.drawCircle(200f,600f,200f,paintR)
        canvas.drawCircle(200f,1000f,200f,paintS)
        canvas.drawRect(400f,0f,800f,400f,paintMirror)
        canvas.drawRect(400f,500f,800f,900f,paintRepeat)
        canvas.drawRect(400f,1000f,800f,1400f,paintClamp)

    }
}
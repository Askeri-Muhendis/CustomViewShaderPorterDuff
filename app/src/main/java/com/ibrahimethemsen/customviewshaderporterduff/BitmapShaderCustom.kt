package com.ibrahimethemsen.customviewshaderporterduff

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class BitmapShaderCustom @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null
) : View(context, attributeSet) {
    private val bitmap = BitmapFactory.decodeResource(resources,R.drawable.wolf)
    private val shaderCC = BitmapShader(bitmap,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
    private val shaderCR = BitmapShader(bitmap,Shader.TileMode.CLAMP,Shader.TileMode.REPEAT)
    private val shaderCM = BitmapShader(bitmap,Shader.TileMode.CLAMP,Shader.TileMode.MIRROR)
    private val shaderRM = BitmapShader(bitmap,Shader.TileMode.REPEAT,Shader.TileMode.MIRROR)
    private val shaderRR = BitmapShader(bitmap,Shader.TileMode.REPEAT,Shader.TileMode.REPEAT)
    private val shaderMM = BitmapShader(bitmap,Shader.TileMode.MIRROR,Shader.TileMode.MIRROR)

    private val paintB = Paint().apply {
        shader = shaderMM
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(0.0f,0.0f,width.toFloat(),600f,paintB)
    }
}
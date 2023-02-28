package com.ibrahimethemsen.customviewshaderporterduff

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class ComposeShader @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null
)  : View(context,attributeSet){
    private val moon = BitmapFactory.decodeResource(resources, R.drawable.human)
    private val destinationShader = BitmapShader(moon,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
    private val destinationP = Paint().apply{
        shader = destinationShader
    }
    private val star = BitmapFactory.decodeResource(resources, R.drawable.heart)
    private val sourceShader = BitmapShader(star,Shader.TileMode.MIRROR,Shader.TileMode.MIRROR)
    private val sourceP = Paint().apply{
        shader = sourceShader
    }
    private val composeShaderD = ComposeShader(destinationShader,sourceShader,PorterDuff.Mode.DST)
    private val composeShaderDA = ComposeShader(destinationShader,sourceShader,PorterDuff.Mode.DST_ATOP)
    private val composeShaderDI = ComposeShader(destinationShader,sourceShader,PorterDuff.Mode.DST_IN)
    private val composeShaderDO = ComposeShader(destinationShader,sourceShader,PorterDuff.Mode.DST_OUT)

    private val composePaint = Paint().apply {
        shader = composeShaderDO
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(0f,0f,1000f,1600f,composePaint)
    }
}
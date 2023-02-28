package com.ibrahimethemsen.customviewshaderporterduff

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class ComposeShader @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null
)  : View(context,attributeSet){
    private val humanBackground = BitmapFactory.decodeResource(resources, R.drawable.human)
    private val destinationShader = BitmapShader(humanBackground,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)

    private val heart = BitmapFactory.decodeResource(resources, R.drawable.heart)
    private val sourceShader = BitmapShader(heart,Shader.TileMode.MIRROR,Shader.TileMode.MIRROR)

    private val composeShaderD = ComposeShader(destinationShader,sourceShader,PorterDuff.Mode.DST)
    private val composeShaderDA = ComposeShader(destinationShader,sourceShader,PorterDuff.Mode.DST_ATOP)
    private val composeShaderDI = ComposeShader(destinationShader,sourceShader,PorterDuff.Mode.DST_IN)
    private val composeShaderDO = ComposeShader(destinationShader,sourceShader,PorterDuff.Mode.DST_OUT)
    private val composeShaderL = ComposeShader(destinationShader,sourceShader,PorterDuff.Mode.LIGHTEN)
    private val composeShaderDN = ComposeShader(destinationShader,sourceShader,PorterDuff.Mode.DARKEN)

    private val user = BitmapFactory.decodeResource(resources, R.drawable.mask)
    private val destinationShaderU = BitmapShader(user,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)

    private val background = BitmapFactory.decodeResource(resources, R.drawable.wolf_user)
    private val sourceShaderU = BitmapShader(background,Shader.TileMode.MIRROR,Shader.TileMode.MIRROR)

    private val composeShaderA = ComposeShader(destinationShaderU,sourceShaderU,PorterDuff.Mode.SRC_IN)


    private val composePaint = Paint().apply {
        shader = composeShaderDO
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //canvas.drawColor(Color.YELLOW)
        canvas.drawRect(0f,0f,1000f,1600f,composePaint)
    }
}
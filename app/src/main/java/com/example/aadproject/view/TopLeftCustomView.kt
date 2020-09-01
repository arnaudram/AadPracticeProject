package com.example.aadproject.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class TopLeftCustomView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var   canvasBackgroundColor:Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var curvedAreaColor=Paint(Paint.ANTI_ALIAS_FLAG)
lateinit var handelePointTopleftCurve:PointF


    init {
        canvasBackgroundColor.color=Color.BLACK
        curvedAreaColor.color=Color.DKGRAY
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.let {
             handelePointTopleftCurve=PointF((it.width/2).toFloat(), (it.height/2).toFloat())
            val startPointOneY= (it.height).toFloat()
            val startPointOneX=0f
            val startPointTwoX=(it.width*0.25).toFloat()
            val startPointTwoY=0f

            val curvedPath=Path().apply {
                moveTo(startPointOneX,startPointOneY)
                lineTo(0f,0f)
                lineTo(startPointTwoX,startPointTwoY)
                quadTo(handelePointTopleftCurve.x,handelePointTopleftCurve.y,startPointOneX,startPointOneY)
                close()
            }

            it.drawRect(0f,0f,it.width.toFloat(),it.height.toFloat(),canvasBackgroundColor)
            it.drawPath(curvedPath,curvedAreaColor)
        }

    }
}
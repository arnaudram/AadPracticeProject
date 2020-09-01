package com.example.aadproject.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class BottomRightCustumView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    var   canvasBackgroundColor: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var curvedAreaColor= Paint(Paint.ANTI_ALIAS_FLAG)
    lateinit var handelePointBottomRightCurve: PointF


    init {
        canvasBackgroundColor.color= Color.BLACK
        curvedAreaColor.color= Color.DKGRAY
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.let {
               handelePointBottomRightCurve=PointF((it.width*0.25).toFloat(),0f)
            val startPointOneY= (it.height*0.75).toFloat()
            val startPointOneX=0f

            val startPointTwoX=(it.width).toFloat()
            val startPointTwoY=0f

            val curvedPath= Path().apply {
                moveTo(startPointOneX,startPointOneY)
                lineTo(0f,it.height.toFloat())
                lineTo(it.width.toFloat(),it.height.toFloat())
                lineTo(startPointTwoX,startPointTwoY)
                quadTo(handelePointBottomRightCurve.x,handelePointBottomRightCurve.y,startPointOneX,startPointOneY)
                close()

            }

            it.drawRect(0f,0f,it.width.toFloat(),it.height.toFloat(),canvasBackgroundColor)
            it.drawPath(curvedPath,curvedAreaColor)
        }
    }
}
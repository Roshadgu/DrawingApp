package com.lunar.drawingapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val drawing_view = findViewById<DrawingView>(R.id.drawing_view)
    drawing_view.setSizeForBrush(20.toFloat())

    val brush = findViewById<ImageButton>(R.id.brush)
    brush.setOnClickListener{
      showBrushSizeChooserDialog()
    }
  }

  private fun showBrushSizeChooserDialog()
  {
    val drawing_view = findViewById<DrawingView>(R.id.drawing_view)
    val brushDialog = Dialog(this)
    brushDialog.setContentView(R.layout.dialog_brush_size)
    brushDialog.setTitle("Brush Size: ")
    val smallBtn = brushDialog.findViewById<ImageButton>(R.id.small_brush)
    smallBtn.setOnClickListener{
      drawing_view.setSizeForBrush(10.toFloat())
      brushDialog.dismiss()
    }

    val mediumBtn = brushDialog.findViewById<ImageButton>(R.id.medium_brush)
    mediumBtn.setOnClickListener{
      drawing_view.setSizeForBrush(20.toFloat())
      brushDialog.dismiss()
    }

    val largeBtn = brushDialog.findViewById<ImageButton>(R.id.large_brush)
    largeBtn.setOnClickListener{
      drawing_view.setSizeForBrush(30.toFloat())
      brushDialog.dismiss()
    }
    brushDialog.show()
  }
}
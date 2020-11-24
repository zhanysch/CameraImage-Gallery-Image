package com.example.cameraimage

import android.graphics.BitmapFactory
import android.os.Bundle
import com.google.android.material.shape.CornerFamily
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : BaseUserPhotoActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupListeners()


        makeroundImage()
    }

    private fun makeroundImage() { // метод для обработки image чтоб углы закгруглялись
        val radius = resources.getDimension(R.dimen.imageRadius)
        val shape = image.shapeAppearanceModel.toBuilder()
                .setTopLeftCorner(CornerFamily.ROUNDED, radius)
                .setTopRightCorner(CornerFamily.ROUNDED, radius)
                .setBottomLeftCorner(CornerFamily.ROUNDED, radius)
                .setBottomRightCorner(CornerFamily.ROUNDED, radius)

                .build()

        image.shapeAppearanceModel = shape
    }

    private fun setupListeners() {
        camera.setOnClickListener {
            shootPhotoWithPermissionCheck()
        }
        gallery.setOnClickListener {
            pickPhotofromGalerryWithPermissionCheck()
        }
    }

    override fun showPhoto(file: File) {
        val bitmap = BitmapFactory.decodeFile(file.absolutePath)
        image.setImageBitmap(bitmap)
    }
}
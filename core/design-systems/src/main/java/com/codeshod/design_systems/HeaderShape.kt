package com.codeshod.design_systems

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class HeaderShape : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val path = Path().apply {

            moveTo(0f, 0f)

            lineTo(size.width, 0f)

            lineTo(
                size.width,
                size.height * 0.72f
            )

            cubicTo(
                size.width * 0.82f,
                size.height * 0.82f,

                size.width * 0.68f,
                size.height * 0.86f,

                size.width * 0.50f,
                size.height * 0.86f
            )

            cubicTo(
                size.width * 0.32f,
                size.height * 0.86f,

                size.width * 0.18f,
                size.height * 0.82f,

                0f,
                size.height * 0.72f
            )

            close()
        }

        return Outline.Generic(path)
    }
}
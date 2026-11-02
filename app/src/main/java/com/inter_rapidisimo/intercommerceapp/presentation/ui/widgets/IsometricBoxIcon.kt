package com.inter_rapidisimo.intercommerceapp.presentation.ui.widgets

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun IsometricBoxIcon(
    modifier: Modifier = Modifier,
    color: Color = Color(0xFFFFC72C)
) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val strokeWidth = 1.8.dp.toPx()

        val centerX = w / 2f
        val centerY = h / 2f

        val topX = centerX
        val topY = centerY - h * 0.36f

        val leftX = centerX - w * 0.34f
        val leftY = centerY - h * 0.16f

        val rightX = centerX + w * 0.34f
        val rightY = centerY - h * 0.16f

        val midX = centerX
        val midY = centerY + h * 0.04f

        val botX = centerX
        val botY = centerY + h * 0.38f

        val botLeftX = leftX
        val botLeftY = leftY + (botY - midY)

        val botRightX = rightX
        val botRightY = rightY + (botY - midY)

        // Outer polygon boundary
        val outerPath = Path().apply {
            moveTo(topX, topY)
            lineTo(rightX, rightY)
            lineTo(botRightX, botRightY)
            lineTo(botX, botY)
            lineTo(botLeftX, botLeftY)
            lineTo(leftX, leftY)
            close()
        }

        // Inner isometric lines
        val innerPath = Path().apply {
            moveTo(midX, midY)
            lineTo(topX, topY)

            moveTo(midX, midY)
            lineTo(botX, botY)

            moveTo(midX, midY)
            lineTo(leftX, leftY)

            moveTo(midX, midY)
            lineTo(rightX, rightY)
        }

        drawPath(
            path = outerPath,
            color = color,
            style = Stroke(width = strokeWidth, cap = StrokeCap.Round, join = StrokeJoin.Round)
        )

        drawPath(
            path = innerPath,
            color = color,
            style = Stroke(width = strokeWidth, cap = StrokeCap.Round, join = StrokeJoin.Round)
        )
    }
}


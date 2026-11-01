package com.inter_rapidisimo.intercommerceapp.presentation.common.widgets

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoadingArcIcon(
    modifier: Modifier = Modifier,
    color: Color = Color(0xFF1A1A1A)
) {
    Canvas(modifier = modifier) {
        val strokeWidth = 2.2.dp.toPx()
        val radius = size.minDimension / 2f - strokeWidth
        val topLeft = Offset(size.width / 2f - radius, size.height / 2f - radius)
        val arcSize = Size(radius * 2, radius * 2)

        drawArc(
            color = color,
            startAngle = 120f,
            sweepAngle = 260f,
            useCenter = false,
            topLeft = topLeft,
            size = arcSize,
            style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
        )
    }
}
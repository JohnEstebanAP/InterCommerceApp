package com.inter_rapidisimo.intercommerceapp.presentation.ui.common

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

enum class SkeletonLevel {
    ROOT,
    CHILD,
    GRAND_CHILD,

    BACKGROUND
}

fun Modifier.skeleton(
    visible: Boolean,
    level: SkeletonLevel = SkeletonLevel.ROOT,
    shape: Shape = RoundedCornerShape(8.dp)
): Modifier = composed {
    if (!visible) return@composed this

    val transition = rememberInfiniteTransition(label = "shimmer")
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1200, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmerAnim"
    )

    val colors = when (level) {
        SkeletonLevel.ROOT -> listOf(
            Color(0xFFE2E8F0),
            Color(0xFFF1F5F9),
            Color(0xFFE2E8F0)
        )

        SkeletonLevel.CHILD -> listOf(
            Color(0xFFE2E8F0),
            Color(0xFFF8FAFC),
            Color(0xFFE2E8F0)
        )

        SkeletonLevel.GRAND_CHILD -> listOf(
            Color(0xFFE8EEF5),
            Color(0xFFF8FAFC),
            Color(0xFFE8EEF5)
        )

        SkeletonLevel.BACKGROUND -> listOf(
            Color(0xFFE8EEF5),
            Color(0xFFF8FAFC),
            Color(0xFFE8EEF5)
        )
    }

    val brush = Brush.linearGradient(
        colors = colors,
        start = Offset(translateAnim - 500f, translateAnim - 500f),
        end = Offset(translateAnim, translateAnim)
    )

    if (level == SkeletonLevel.BACKGROUND) {
        this.clip(RoundedCornerShape(12.dp))
            .shimmerEffect()

    } else {
        this
            .drawWithContent {
                // Draw the shimmer brush covering the element bounds at full opacity
                drawRect(brush = brush)
            }
            .clip(shape)
            .graphicsLayer {
                // Hide the actual content (text, image, icon) inside this element
                alpha = 0f
            }
    }


}


fun Modifier.shimmerEffect(): Modifier = composed {

    val transition = rememberInfiniteTransition(
        label = "shimmer"
    )

    val translateAnim by transition.animateFloat(
        initialValue = -1000f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(2200),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmerAnim"
    )

    background(
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFE0E0E0),
                Color(0xFFF5F5F5),
                Color(0xFFE0E0E0)
            ),
            start = Offset.Zero,
            end = Offset(
                translateAnim,
                translateAnim
            )
        )
    )
}

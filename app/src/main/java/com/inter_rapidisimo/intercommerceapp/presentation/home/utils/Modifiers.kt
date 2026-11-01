package com.inter_rapidisimo.intercommerceapp.presentation.home.utils

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

fun Modifier.skeleton(
    visible: Boolean
): Modifier {

    return if (visible) {
        this
            .clip(RoundedCornerShape(12.dp))
            .shimmerEffect()

    } else {

        this
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
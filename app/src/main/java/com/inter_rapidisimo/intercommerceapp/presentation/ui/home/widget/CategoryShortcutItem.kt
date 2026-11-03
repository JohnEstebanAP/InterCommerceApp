package com.inter_rapidisimo.intercommerceapp.presentation.ui.home.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inter_rapidisimo.intercommerceapp.presentation.ui.common.SkeletonLevel
import com.inter_rapidisimo.intercommerceapp.presentation.ui.common.skeleton

@Composable fun CategoryShortcutItem(
    label: String,
    isLoading : Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
) {
    val modifier = Modifier.skeleton(isLoading, SkeletonLevel.CHILD)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(76.dp)
    ) {
        Box(
            modifier = modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.White)
                .clickable(enabled = !isLoading, onClick = onClick),
            contentAlignment = Alignment.Center,
        ) {
            icon()
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            modifier = modifier,
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF1A1A1A),
            maxLines = 1
        )
    }
}

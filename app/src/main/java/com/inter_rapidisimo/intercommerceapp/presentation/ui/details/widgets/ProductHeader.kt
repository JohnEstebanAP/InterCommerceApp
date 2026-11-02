package com.inter_rapidisimo.intercommerceapp.presentation.ui.details.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductHeader(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {

    Row(
        modifier = modifier
            .padding(
                horizontal = 20.dp,
                vertical = 16.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(
            onClick = onBackClick
        ) {

            Icon(
                imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                contentDescription = "Atrás"
            )
        }

        Text(
            text = "Detalle del producto",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
package com.inter_rapidisimo.intercommerceapp.presentation.ui.details.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.outlined.LocalShipping
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
 fun AvailabilitySection(
    stock: Int
) {

    Column {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Rounded.CheckCircle,
                contentDescription = null,
                tint = Color(0xFF2E7D32)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Disponible · $stock unidades",
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Outlined.LocalShipping,
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {

                Text(
                    text = "Envío gratis",
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Entrega estimada mañana",
                    color = Color.Gray
                )
            }
        }
    }
}
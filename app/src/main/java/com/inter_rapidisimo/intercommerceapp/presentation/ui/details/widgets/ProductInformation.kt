package com.inter_rapidisimo.intercommerceapp.presentation.ui.details.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inter_rapidisimo.intercommerceapp.domain.product.Product

@Composable
fun ProductInformation(
    modifier: Modifier = Modifier,
    product: Product
) {

    Column(
        modifier = modifier.padding(horizontal = 20.dp)
    ) {

        Text(
            text = product.category.uppercase(),
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = product.title,
            fontSize = 34.sp,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = 40.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Outlined.StarOutline,
                contentDescription = null,
                tint = Color.Gray
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = "${product.rating}"
            )

            Text(
                text = " · Más vendido"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "$${(product.price * 1.2).toInt()}",
                color = Color.Gray,
                textDecoration = TextDecoration.LineThrough
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "${product.discountPercentage.toInt()} % descuento",
                color = Color.Red,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "$ ${product.price}",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "COP · IVA incluido",
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(28.dp))

        AvailabilitySection(
            stock = product.stock
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = product.description,
            fontSize = 18.sp,
            color = Color.Gray
        )
    }
}
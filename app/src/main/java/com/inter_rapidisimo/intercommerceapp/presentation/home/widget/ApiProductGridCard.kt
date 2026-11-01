package com.inter_rapidisimo.intercommerceapp.presentation.home.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import com.inter_rapidisimo.intercommerceapp.presentation.home.utils.Utils
import java.util.Locale

@Composable fun ApiProductGridCard(
    modifier: Modifier = Modifier,
    product: Product,
    fallbackGraphic: @Composable () -> Unit
) {
    val currentPriceFormatted = Utils.formatCopPrice(product.price * 4000.0)
    val oldPriceFormatted = if (product.discountPercentage > 0) {
       Utils.formatCopPrice((product.price * 4000.0) * (1 + product.discountPercentage / 100.0))
    } else null

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            // Image Box Container
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFE8E8E8)),
                contentAlignment = Alignment.Center
            ) {
                if (product.thumbnail.isNotEmpty()) {
                    AsyncImage(
                        model = product.thumbnail,
                        contentDescription = product.title,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        contentScale = ContentScale.Fit
                    )
                } else {
                    fallbackGraphic()
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Badge
            if (product.discountPercentage > 0) {
                Text(
                    text = "HASTA ${product.discountPercentage.toInt()} % MENOS",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFD32F2F)
                )

                Spacer(modifier = Modifier.height(4.dp))
            }

            // Title
            Text(
                text = product.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A1A),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Old Price
            if (oldPriceFormatted != null) {
                Text(
                    text = oldPriceFormatted,
                    fontSize = 12.sp,
                    color = Color(0xFF9E9E9E),
                    textDecoration = TextDecoration.LineThrough
                )
            }

            // Current Price
            Text(
                text = currentPriceFormatted,
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF1A1A1A)
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Shipping
            Text(
                text = "Envío gratis · Llega mañana",
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF146C36)
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Rating
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "★",
                    fontSize = 12.sp,
                    color = Color(0xFFFFC72C)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "${String.format(Locale.US, "%.1f", product.rating)} (${product.stock})",
                    fontSize = 12.sp,
                    color = Color(0xFF616161)
                )
            }
        }
    }
}
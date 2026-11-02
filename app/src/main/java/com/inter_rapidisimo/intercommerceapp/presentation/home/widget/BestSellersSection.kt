package com.inter_rapidisimo.intercommerceapp.presentation.home.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.outlined.Backpack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import com.inter_rapidisimo.intercommerceapp.presentation.home.widget.skeleton.ProductSkeletonItem

@Composable fun BestSellersSection(
    products: List<Product>,
    isLoading: Boolean,
    error: String?,
    modifier: Modifier = Modifier,
    onProductClick: (Product) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Section Title Header
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Más vendidos",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF1A1A1A)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Ver todo",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A1A)
                )

                Spacer(modifier = modifier.width(4.dp))

                Text(
                    text = "→",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A1A)
                )
            }
        }

        if (isLoading && products.isEmpty()) {

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                ProductSkeletonItem(
                    modifier = modifier.weight(1f)
                )

                ProductSkeletonItem(
                    modifier = modifier.weight(1f)
                )
            }
        } else if (products.size >= 2) {
            // Render real API Products loaded via KtorClient
            val item1 = products[0]
            val item2 = products[1]

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                ApiProductGridCard(
                    modifier = modifier.weight(1f),
                    product = item1,
                    fallbackGraphic = {
                        Icon(
                            imageVector = Icons.Filled.Headphones,
                            contentDescription = "Audífonos",
                            modifier = modifier.size(70.dp),
                            tint = Color(0xFF1A1A1A)
                        )
                    },
                    onClick = {
                        onProductClick(item1)
                    }
                )

                ApiProductGridCard(
                    modifier = modifier.weight(1f),
                    product = item2,
                    fallbackGraphic = {
                        Icon(
                            imageVector = Icons.Outlined.Backpack,
                            contentDescription = "Morral",
                            modifier = modifier.size(70.dp),
                            tint = Color(0xFF1A1A1A)
                        )
                    },
                    onClick = {
                        onProductClick(item2)
                    }
                )
            }
        } else {
            // Fallback Design Cards
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                ProductGridCard(
                    modifier = modifier.weight(1f),
                    title = "Audífonos inalámbricos Aura",
                    oldPrice = "$229.900",
                    price = "$179.900",
                    badgeText = "HASTA 25 % MENOS",
                    ratingText = "4,8 (128)",
                    graphic = {
                        Icon(
                            imageVector = Icons.Filled.Headphones,
                            contentDescription = "Audífonos",
                            modifier = modifier.size(70.dp),
                            tint = Color(0xFF1A1A1A)
                        )
                    }
                )

                ProductGridCard(
                    modifier = modifier.weight(1f),
                    title = "Morral urbano Nova 20 L",
                    oldPrice = "$129.900",
                    price = "$99.900",
                    badgeText = "HASTA 25 % MENOS",
                    ratingText = "4,8 (128)",
                    graphic = {
                        Icon(
                            imageVector = Icons.Outlined.Backpack,
                            contentDescription = "Morral",
                            modifier = modifier.size(70.dp),
                            tint = Color(0xFF1A1A1A)
                        )
                    }
                )
            }
        }
    }
}


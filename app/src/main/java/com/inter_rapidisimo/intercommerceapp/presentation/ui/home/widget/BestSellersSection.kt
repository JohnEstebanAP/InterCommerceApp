package com.inter_rapidisimo.intercommerceapp.presentation.ui.home.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import com.inter_rapidisimo.intercommerceapp.presentation.ui.common.SkeletonLevel
import com.inter_rapidisimo.intercommerceapp.presentation.ui.common.skeleton
import com.inter_rapidisimo.intercommerceapp.ui.theme.InterCommerceAppTheme

@Composable
fun BestSellersSection(
    products: List<Product>,
    isLoading: Boolean,
    error: String?,
    onProductClick: (Product) -> Unit,
    onSeeAllClick: () -> Unit,
) {
    val modifier = Modifier.skeleton(isLoading, SkeletonLevel.CHILD)
    val modifierBackground = Modifier.skeleton(isLoading, SkeletonLevel.BACKGROUND)

    Column(
        modifier = modifierBackground.fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Section Title Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onSeeAllClick()
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = modifier,
                text = "Más vendidos",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF1A1A1A)
            )

            Row(
                modifier = Modifier
                    .clickable {
                        onSeeAllClick()
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = modifier,
                    text = "Ver todo",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A1A)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "→",
                    modifier = modifier,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A1A)
                )
            }
        }

        val item1 = products.getOrNull(0)
        val item2 = products.getOrNull(1)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            ApiProductGridCard(
                modifier = modifier.weight(1f),
                product = item1,
                fallbackGraphic = {
                    Icon(
                        imageVector = Icons.Filled.Headphones,
                        contentDescription = "Audífonos",
                        modifier = Modifier.size(70.dp),
                        tint = Color(0xFF1A1A1A)
                    )
                },
                onClick = {
                    item1?.let { onProductClick(it) }
                }
            )

            ApiProductGridCard(
                modifier = modifier.weight(1f),
                product = item2,
                fallbackGraphic = {
                    Icon(
                        imageVector = Icons.Outlined.Backpack,
                        contentDescription = "Morral",
                        modifier = Modifier.size(70.dp),
                        tint = Color(0xFF1A1A1A)
                    )
                },
                onClick = {
                    item2?.let { onProductClick(it) }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BestSellersSectionPreview() {
    InterCommerceAppTheme {
        BestSellersSection(
            products = listOf(
                Product(
                    id = 1,
                    title = "Parlante portátil Go Mini",
                    description = "Pequeño en tamaño. Grande en sonido.",
                    price = 22.49,
                    thumbnail = ""
                )
            ),
            isLoading = true,
            onProductClick = {},
            onSeeAllClick = {},
            error = TODO()
        )
    }
}

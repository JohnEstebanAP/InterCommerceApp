package com.inter_rapidisimo.intercommerceapp.presentation.home.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Speaker
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import com.inter_rapidisimo.intercommerceapp.presentation.home.utils.Utils
import com.inter_rapidisimo.intercommerceapp.presentation.home.widget.skeleton.FeaturedProductSkeleton

@Composable
fun FeaturedProductsSection(
    products: List<Product>,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    onProductClick: (Product) -> Unit,
    onSeeAllClick: () -> Unit
) {
    val featuredItem = products.getOrNull(2) ?: products.firstOrNull()

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Section Title Header
        Row(
            modifier = Modifier.clickable {
                onSeeAllClick()
            },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Productos destacados",
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
            FeaturedProductSkeleton()
        } else {
            // Horizontal Product Item Card
            Card(
                modifier = modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                onClick = {
                    featuredItem?.let {
                        onProductClick(it)
                    }
                }
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Image Box Container
                    Box(
                        modifier = modifier
                            .size(88.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color(0xFFE8E8E8)),
                        contentAlignment = Alignment.Center
                    ) {
                        if (featuredItem != null && featuredItem.thumbnail.isNotEmpty()) {
                            AsyncImage(
                                model = featuredItem.thumbnail,
                                contentDescription = featuredItem.title,
                                modifier = modifier
                                    .fillMaxSize()
                                    .padding(6.dp),
                                contentScale = ContentScale.Fit
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Filled.Speaker,
                                contentDescription = "Parlante",
                                modifier = modifier.size(52.dp),
                                tint = Color(0xFF8D8372)
                            )
                        }
                    }

                    Spacer(modifier = modifier.width(16.dp))

                    // Content
                    Column(
                        modifier = modifier.weight(1f)
                    ) {
                        Text(
                            text = featuredItem?.title ?: "Parlante portátil Go Mini",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1A1A1A),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                        Spacer(modifier = modifier.height(4.dp))

                        Text(
                            text = if (featuredItem != null) Utils.formatCopPrice(featuredItem.price * 4000.0) else "$89.900",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF1A1A1A)
                        )

                        Spacer(modifier = modifier.height(4.dp))

                        Text(
                            text = featuredItem?.description
                                ?: "Pequeño en tamaño. Grande en sonido.",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color(0xFF616161),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}



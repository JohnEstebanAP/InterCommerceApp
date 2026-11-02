package com.inter_rapidisimo.intercommerceapp.presentation.ui.home.widget

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
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
import com.inter_rapidisimo.intercommerceapp.presentation.ui.widgets.IsometricBoxIcon

@Composable fun HomeHeaderSection(
    isLoading : Boolean
) {
    val modifier = Modifier.skeleton(isLoading, SkeletonLevel.CHILD)
    val modifierBackground = Modifier.skeleton(isLoading, SkeletonLevel.BACKGROUND)

    Box(
        modifier = modifierBackground
            .fillMaxWidth()
            .background(Color(0xFFFFC72C))
            .statusBarsPadding()
            .padding(start = 20.dp, end = 20.dp, top = 12.dp, bottom = 16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Top Row: Brand Logo + Profile/Cart Actions
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Brand Logo + Title
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = modifier
                            .size(42.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFF1A1A1A)),
                        contentAlignment = Alignment.Center
                    ) {
                        IsometricBoxIcon(
                            modifier = modifier.size(24.dp),
                            color = Color(0xFFFFC72C)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        modifier = modifier,
                        text = "InterCommerce",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF1A1A1A)
                    )
                }

                // Actions: Profile Avatar + Cart Badge Icon
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    // Avatar Circle "VA"
                    Box(
                        modifier = modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = modifier,
                            text = "VA",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1A1A1A)
                        )
                    }

                    // Cart Icon with Red Badge
                    Box(
                        modifier = modifier.size(38.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = "Carrito",
                            modifier = modifier.size(26.dp),
                            tint = Color(0xFF1A1A1A)
                        )

                        // Red Badge Counter "1"
                        Box(
                            modifier = modifier
                                .size(18.dp)
                                .align(Alignment.TopEnd)
                                .clip(CircleShape)
                                .background(Color(0xFFD32F2F)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                modifier = modifier,
                                text = "1",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Search Bar Pill
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = CircleShape,
                color = Color.White,
                shadowElevation = 0.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Buscar",
                        modifier = modifier.size(20.dp),
                        tint = Color(0xFF757575)
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        text = "Buscar en InterCommerce",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF757575),
                        modifier = modifier.weight(1f)
                    )

                    Icon(
                        imageVector = Icons.Filled.Mic,
                        contentDescription = "Micrófono",
                        modifier = modifier.size(20.dp),
                        tint = Color(0xFF757575)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Delivery Address + Connection Status Sub-bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "Ubicación",
                        modifier = modifier.size(16.dp),
                        tint = Color(0xFF1A1A1A)
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        modifier = modifier,
                        text = "Enviar a Valentina · Bogotá",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF1A1A1A)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Wifi,
                        contentDescription = "En línea",
                        modifier = modifier.size(16.dp),
                        tint = Color(0xFF1A1A1A)
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        modifier = modifier,
                        text = "En línea",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1A1A1A)
                    )
                }
            }
        }
    }
}

package com.inter_rapidisimo.intercommerceapp.presentation.ui.home.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inter_rapidisimo.intercommerceapp.domain.product.Product

@Composable
fun HomeBottomNavigationBar(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Tab 0: Inicio
            BottomNavItem(
                label = "Inicio",
                isSelected = selectedTab == 0,
                onClick = { onTabSelected(0) },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Inicio",
                        modifier = Modifier.size(22.dp),
                        tint = if (selectedTab == 0) Color(0xFF1A1A1A) else Color(0xFF757575)
                    )
                }
            )

            // Tab 1: Explorar
            BottomNavItem(
                label = "Explorar",
                isSelected = selectedTab == 1,
                onClick = { onTabSelected(1) },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Explorar",
                        modifier = Modifier.size(22.dp),
                        tint = if (selectedTab == 1) Color(0xFF1A1A1A) else Color(0xFF757575)
                    )
                }
            )

            // Tab 2: Carrito (with badge)
            BottomNavItem(
                label = "Carrito",
                isSelected = selectedTab == 2,
                onClick = { onTabSelected(2) },
                icon = {
                    Box {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = "Carrito",
                            modifier = Modifier.size(22.dp),
                            tint = if (selectedTab == 2) Color(0xFF1A1A1A) else Color(0xFF757575)
                        )
                        Box(
                            modifier = Modifier
                                .size(14.dp)
                                .align(Alignment.TopEnd)
                                .clip(CircleShape)
                                .background(Color(0xFFD32F2F)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "1",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            )

            // Tab 3: Mi cuenta
            BottomNavItem(
                label = "Mi cuenta",
                isSelected = selectedTab == 3,
                onClick = { onTabSelected(3) },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Mi cuenta",
                        modifier = Modifier.size(22.dp),
                        tint = if (selectedTab == 3) Color(0xFF1A1A1A) else Color(0xFF757575)
                    )
                }
            )
        }
    }
}

@Composable
private fun BottomNavItem(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        if (isSelected) {
            Box(
                modifier = Modifier
                    .height(32.dp)
                    .width(56.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFFC72C)),
                contentAlignment = Alignment.Center
            ) {
                icon()
            }
        } else {
            Box(
                modifier = Modifier
                    .height(32.dp)
                    .width(56.dp),
                contentAlignment = Alignment.Center
            ) {
                icon()
            }
        }

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            color = Color(0xFF1A1A1A)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeBottomNavigationBar(
        selectedTab = 1,
        onTabSelected = {}
    )
}
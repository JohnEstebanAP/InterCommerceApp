package com.inter_rapidisimo.intercommerceapp.presentation.ui.home.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.outlined.Backpack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.inter_rapidisimo.intercommerceapp.presentation.ui.common.SkeletonLevel
import com.inter_rapidisimo.intercommerceapp.presentation.ui.common.skeleton

@Composable fun HomeCategoryShortcuts(   isLoading: Boolean) {
    val modifierBackground = Modifier.skeleton(isLoading, SkeletonLevel.BACKGROUND)

    Row(
        modifier = modifierBackground.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        CategoryShortcutItem("Tecnología", isLoading) {
            Icon(
                imageVector = Icons.Filled.Headphones,
                contentDescription = "Tecnología",
                modifier = Modifier.size(26.dp),
                tint = Color(0xFF1A1A1A)
            )
        }
        CategoryShortcutItem("Estilo de vida", isLoading) {
            Icon(
                imageVector = Icons.Outlined.Backpack,
                contentDescription = "Estilo de vida",
                modifier = Modifier.size(26.dp),
                tint = Color(0xFF1A1A1A)
            )
        }
        CategoryShortcutItem("Hogar", isLoading) {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Hogar",
                modifier = Modifier.size(26.dp),
                tint = Color(0xFF1A1A1A)
            )
        }
        CategoryShortcutItem("Ofertas", isLoading) {
            Icon(
                imageVector = Icons.Filled.LocalOffer,
                contentDescription = "Ofertas",
                modifier = Modifier.size(26.dp),
                tint = Color(0xFF1A1A1A)
            )
        }
    }
}

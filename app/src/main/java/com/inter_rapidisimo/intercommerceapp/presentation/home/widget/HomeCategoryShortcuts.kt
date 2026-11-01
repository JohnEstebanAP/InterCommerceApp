package com.inter_rapidisimo.intercommerceapp.presentation.home.widget

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

@Composable fun HomeCategoryShortcuts(    modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        CategoryShortcutItem("Tecnología") {
            Icon(
                imageVector = Icons.Filled.Headphones,
                contentDescription = "Tecnología",
                modifier = modifier.size(26.dp),
                tint = Color(0xFF1A1A1A)
            )
        }
        CategoryShortcutItem("Estilo de vida") {
            Icon(
                imageVector = Icons.Outlined.Backpack,
                contentDescription = "Estilo de vida",
                modifier = modifier.size(26.dp),
                tint = Color(0xFF1A1A1A)
            )
        }
        CategoryShortcutItem("Hogar") {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Hogar",
                modifier = modifier.size(26.dp),
                tint = Color(0xFF1A1A1A)
            )
        }
        CategoryShortcutItem("Ofertas") {
            Icon(
                imageVector = Icons.Filled.LocalOffer,
                contentDescription = "Ofertas",
                modifier = modifier.size(26.dp),
                tint = Color(0xFF1A1A1A)
            )
        }
    }
}

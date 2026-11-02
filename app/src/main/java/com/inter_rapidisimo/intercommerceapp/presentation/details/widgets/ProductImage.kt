package com.inter_rapidisimo.intercommerceapp.presentation.details.widgets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
 fun ProductImage(
    imageUrl: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(340.dp)
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(24.dp)
    ) {

        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }
}

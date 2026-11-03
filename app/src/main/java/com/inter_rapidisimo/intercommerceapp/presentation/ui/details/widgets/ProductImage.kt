package com.inter_rapidisimo.intercommerceapp.presentation.ui.details.widgets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.inter_rapidisimo.intercommerceapp.R

@Composable
 fun ProductImage(
    modifier: Modifier = Modifier,
    imageUrl: String
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(340.dp)
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(24.dp)
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .memoryCachePolicy(CachePolicy.ENABLED)
                .diskCachePolicy(CachePolicy.ENABLED)
                .networkCachePolicy(CachePolicy.ENABLED)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.Fit,
            placeholder = painterResource(
                R.drawable.ic_product_placeholder_foreground
            ),
            error = painterResource(
                R.drawable.ic_product_placeholder_foreground
            ),
            fallback = painterResource(
                R.drawable.ic_product_placeholder_foreground
            ),
        )
    }
}

package com.inter_rapidisimo.intercommerceapp.presentation.home.widget.skeleton

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.inter_rapidisimo.intercommerceapp.presentation.home.utils.shimmerEffect

@Composable
fun ProductSkeletonItem(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .shimmerEffect()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(16.dp)
                .shimmerEffect()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(16.dp)
                .shimmerEffect()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductSkeletonItemPreview() {
    ProductSkeletonItem()
}

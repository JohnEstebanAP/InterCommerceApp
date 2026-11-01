package com.inter_rapidisimo.intercommerceapp.presentation.home.utils

import java.util.Locale

object Utils {
    fun formatCopPrice(amountInUsdOrCop: Double): String {
        val roundedInt = amountInUsdOrCop.toLong()
        val formattedStr = String.format(Locale.US, "% ,d", roundedInt).replace(',', '.')
        return "$formattedStr"
    }
}
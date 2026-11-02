package com.inter_rapidisimo.intercommerceapp.presentation.ui.common.utils

import java.util.Locale

object Utils {
    fun formatCopPrice(amountInUsdOrCop: Double): String {
        val roundedInt = amountInUsdOrCop.toLong()
        val formattedStr = String.format(Locale.US, "% ,d", roundedInt).replace(',', '.')
        return "$formattedStr"
    }
}
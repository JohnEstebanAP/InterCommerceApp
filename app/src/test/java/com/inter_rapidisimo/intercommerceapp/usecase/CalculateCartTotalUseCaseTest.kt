package com.inter_rapidisimo.intercommerceapp.usecase

import com.inter_rapidisimo.intercommerceapp.data.source.local.entity.CartEntity
import com.inter_rapidisimo.intercommerceapp.domain.usecase.CalculateCartTotalUseCase
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculateCartTotalUseCaseTest {

    private lateinit var useCase: CalculateCartTotalUseCase

    @Before
    fun setup() {
        useCase = CalculateCartTotalUseCase()
    }

    @Test
    fun `should return zero when cart is empty`() {

        val result = useCase(emptyList())

        assertEquals(
            0.0,
            result,
            0.001
        )
    }

    @Test
    fun `should calculate total for one product`() {

        val items = listOf(
            CartEntity(
                productId = 1,
                title = "Laptop",
                price = 100.0,
                thumbnail = "",
                quantity = 2
            )
        )

        val result = useCase(items)

        assertEquals(
            200.0,
            result,
            0.001
        )
    }

    @Test
    fun `should calculate total for multiple products`() {

        val items = listOf(

            CartEntity(
                productId = 1,
                title = "Laptop",
                price = 100.0,
                thumbnail = "",
                quantity = 2
            ),

            CartEntity(
                productId = 2,
                title = "Mouse",
                price = 50.0,
                thumbnail = "",
                quantity = 3
            )
        )

        val result = useCase(items)

        assertEquals(
            350.0,
            result,
            0.001
        )
    }

    @Test
    fun `should calculate total with decimal prices`() {

        val items = listOf(
            CartEntity(
                productId = 1,
                title = "Monitor",
                price = 999.99,
                thumbnail = "",
                quantity = 2
            )
        )

        val result = useCase(items)

        assertEquals(
            1999.98,
            result,
            0.001
        )
    }
}
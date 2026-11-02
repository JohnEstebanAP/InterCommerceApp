package com.inter_rapidisimo.intercommerceapp.usecase

import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import com.inter_rapidisimo.intercommerceapp.domain.repository.ProductRepository
import com.inter_rapidisimo.intercommerceapp.domain.usecase.GetProductsUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetProductsUseCaseTest {

    private lateinit var repository: ProductRepository

    private lateinit var getProductsUseCase: GetProductsUseCase

    @Before
    fun setup() {

        repository = mockk()

        getProductsUseCase = GetProductsUseCase(
            repository
        )
    }

    @Test
    fun `should return products from repository`() = runTest {

        val products = listOf(
            mockk<Product>(),
            mockk<Product>()
        )

        coEvery {
            repository.getProducts(
                limit = 10,
                skip = 0
            )
        } returns products

        val result = getProductsUseCase(
            limit = 10,
            skip = 0
        )

        assertEquals(
            products,
            result
        )

        coVerify(exactly = 1) {
            repository.getProducts(
                limit = 10,
                skip = 0
            )
        }
    }
}
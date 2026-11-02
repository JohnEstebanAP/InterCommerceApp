package com.inter_rapidisimo.intercommerceapp.usecase

import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import com.inter_rapidisimo.intercommerceapp.domain.repository.CartRepository
import com.inter_rapidisimo.intercommerceapp.domain.usecase.AddToCartUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class AddToCartUseCaseTest {

    private lateinit var repository: CartRepository

    private lateinit var useCase: AddToCartUseCase

    @Before
    fun setup() {

        repository = mockk()

        useCase = AddToCartUseCase(
            repository
        )
    }

    @Test
    fun `should add product to cart`() = runTest {

        val product = mockk<Product>()

        coEvery {
            repository.addToCart(product)
        } returns Unit

        useCase(product)

        coVerify(exactly = 1) {
            repository.addToCart(product)
        }
    }
}
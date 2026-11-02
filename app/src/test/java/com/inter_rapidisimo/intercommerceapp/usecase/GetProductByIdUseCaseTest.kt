package com.inter_rapidisimo.intercommerceapp.usecase

import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import com.inter_rapidisimo.intercommerceapp.domain.repository.ProductRepository
import com.inter_rapidisimo.intercommerceapp.domain.usecase.GetProductByIdUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetProductByIdUseCaseTest {

    private lateinit var repository: ProductRepository

    private lateinit var useCase: GetProductByIdUseCase

    @Before
    fun setup() {

        repository = mockk()

        useCase = GetProductByIdUseCase(
            repository
        )
    }

    @Test
    fun `should return product by id`() = runTest {

        val product = mockk<Product>()

        coEvery {
            repository.getProductById(1)
        } returns product

        val result = useCase(1)

        assertEquals(
            product,
            result
        )

        coVerify(exactly = 1) {
            repository.getProductById(1)
        }
    }

    @Test
    fun `should return null when product does not exist`() = runTest {

        coEvery {
            repository.getProductById(999)
        } returns null

        val result = useCase(999)

        assertEquals(
            null,
            result
        )

        coVerify(exactly = 1) {
            repository.getProductById(999)
        }
    }
}
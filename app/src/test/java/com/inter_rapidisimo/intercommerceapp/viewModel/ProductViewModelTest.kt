package com.inter_rapidisimo.intercommerceapp.viewModel

import com.inter_rapidisimo.intercommerceapp.domain.product.Product
import com.inter_rapidisimo.intercommerceapp.domain.usecase.AddToCartUseCase
import com.inter_rapidisimo.intercommerceapp.domain.usecase.GetProductByIdUseCase
import com.inter_rapidisimo.intercommerceapp.domain.usecase.GetProductsUseCase
import com.inter_rapidisimo.intercommerceapp.presentation.ui.product.ProductViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ProductViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var getProductsUseCase: GetProductsUseCase

    private lateinit var getProductByIdUseCase: GetProductByIdUseCase

    private lateinit var addToCartUseCase: AddToCartUseCase

    private lateinit var viewModel: ProductViewModel

    @Before
    fun setup() {

        getProductsUseCase = mockk()

        getProductByIdUseCase = mockk()

        addToCartUseCase = mockk(relaxed = true)

        viewModel = ProductViewModel(
            getProductsUseCase,
            getProductByIdUseCase,
            addToCartUseCase
        )
    }

    @Test
    fun `fetchProducts should update products state`() = runTest {

        val products = listOf(
            mockk<Product>(),
            mockk<Product>()
        )

        coEvery {
            getProductsUseCase(10, 0)
        } returns products

        viewModel.fetchProducts()

        advanceUntilIdle()

        assertEquals(
            products,
            viewModel.products.value
        )

        assertEquals(
            false,
            viewModel.isLoading.value
        )

        assertEquals(
            null,
            viewModel.error.value
        )
    }

    @Test
    fun `loadProduct should update selectedProduct`() = runTest {

        val product = mockk<Product>()

        coEvery {
            getProductByIdUseCase(1)
        } returns product

        viewModel.loadProduct(1)

        advanceUntilIdle()

        assertEquals(
            product,
            viewModel.selectedProduct.value
        )
    }

    @Test
    fun `fetchProducts should update error state when exception occurs`() = runTest {

        coEvery {
            getProductsUseCase(10, 0)
        } throws Exception("Network Error")

        viewModel.fetchProducts()

        advanceUntilIdle()

        assertEquals(
            true,
            viewModel.error.value?.contains("Network Error")
        )
    }
}
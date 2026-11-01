data class ProductList(
    val total: Int,
    val skip: Int,
    val limit: Int,
    val products: List<Product>
)
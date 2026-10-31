data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val tags: List<String>,
    val brand: String,
    val sku: String,
    val weight: Int,
    val dimensions: Map<String, String>, // Or a more specific data class if you need more dimension details
    val warrantyInformation: String,
    val shippingInformation: String,
    val availabilityStatus: String,
    val reviews: List<String>,
    val returnPolicy: String,
    val minimumOrderQuantity: Int,
    val meta: Map<String, String>,
    val images: List<String>,
    val thumbnail: String
)

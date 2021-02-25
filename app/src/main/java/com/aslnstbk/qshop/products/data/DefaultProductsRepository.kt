package com.aslnstbk.qshop.products.data

import com.aslnstbk.qshop.products.domain.ProductsRepository
import com.aslnstbk.qshop.products.models.Product

class DefaultProductsRepository : ProductsRepository {

    override fun loadProductsList(
        result: (List<Product>) -> Unit,
        fail: (String) -> Unit
    ) {
        val productsList: MutableList<Product> = mutableListOf()

        productsList.add(Product(id = "1", photoUrl = "https://xiaomi-store.kz/images/stories/virtuemart/product/RN5_Black.jpg", shopName = "Xiaomi", productName = "Redmi note 5"))
        productsList.add(Product(id = "2", photoUrl = "https://aif-s3.aif.ru/images/012/576/7a3c63960852a2e23cfdfbd5acd56c57.jpg", shopName = "Starbucks", productName = "капучино"))
        productsList.add(Product(id = "3", photoUrl = "https://provapes.ru/wp-content/uploads/2018/09/stik-7-1-870x400.jpg", shopName = "iQos", productName = "стики iqos"))
        productsList.add(Product(id = "4", photoUrl = "https://i.pinimg.com/originals/fd/0e/4e/fd0e4edae7c0d61115db70d2453f5885.png", shopName = "iQos", productName = "IQOS 3 DUO Kit"))
        productsList.add(Product(id = "5", photoUrl = "https://fruitnews.ru/images/fruechte-und-gemuese-social_p39232.jpg", shopName = "Овощи'", productName = "Овощи'"))
        productsList.add(Product(id = "6", photoUrl = "https://xiaomi-store.kz/images/stories/virtuemart/product/RN5_Black.jpg", shopName = "Xiaomi", productName = "REdmi note 5"))
        productsList.add(Product(id = "7", photoUrl = "https://aif-s3.aif.ru/images/012/576/7a3c63960852a2e23cfdfbd5acd56c57.jpg", shopName = "Starbucks", productName = "капучино"))
        productsList.add(Product(id = "8", photoUrl = "https://provapes.ru/wp-content/uploads/2018/09/stik-7-1-870x400.jpg", shopName = "iQos", productName = "стики iqos"))
        productsList.add(Product(id = "9", photoUrl = "https://i.pinimg.com/originals/fd/0e/4e/fd0e4edae7c0d61115db70d2453f5885.png", shopName = "iQos", productName = "IQOS 3 DUO Kit"))
        productsList.add(Product(id = "10", photoUrl = "https://fruitnews.ru/images/fruechte-und-gemuese-social_p39232.jpg", shopName = "Овощи", productName = "Овощи'"))

        if (productsList.isNotEmpty()) {
            result(productsList)
        } else {
            fail("Error")
        }
    }
}
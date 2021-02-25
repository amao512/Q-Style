package com.aslnstbk.qshop.basket.data

import com.aslnstbk.qshop.basket.data.models.Basket
import com.aslnstbk.qshop.basket.domain.BasketRepository

class DefaultBasketRepository : BasketRepository {

    override fun loadBasketList(
        result: (List<Basket>) -> Unit,
        fail: (String) -> Unit
    ) {
        val basketList: MutableList<Basket> = mutableListOf()

        basketList.add(Basket(id = "1", photoUrl = "https://static.ralf.ru/upload/resize_cache/iblock/1ab/750_9999_1/1abefdcab27248638fbd2395dd75be5b.jpg", productName = "Мужские ботинки 43", shopName = "Lamoda"))
        basketList.add(Basket(id = "2", photoUrl = "https://coffeetee.ru/wp-content/uploads/2019/08/starbucks-made-it-crystal-clear-they-won-t-accept-cryptocurrency-as-payment-for-coffee-1024x682.jpg", productName = "Капучино средний 2", shopName = "Starbucks"))
        basketList.add(Basket(id = "3", photoUrl = "https://korzinka.com/upload/resize_cache/iblock/d02/250_133_1/d02fb93359e0877e0a5e2524ff2f6290.jpg", productName = "Ежемесячный ящик кока-колы", shopName = "Coca-Cola"))
        basketList.add(Basket(id = "4", photoUrl = "https://fastly.4sqi.net/img/general/200x200/50970612_jM8w5ve7xlkBkPmzF6ODwJzJDaIh0WY775ZlApy5Sz4.jpg", productName = "Шашлычный набор (блюдо на 5)", shopName = "Shipudim"))
        basketList.add(Basket(id = "5", photoUrl = "https://img.povar.ru/main/0e/66/dc/37/blinchiki_s_tvorogom_i_yagodami-140482.jpg", productName = "Блины с творогом, блины обычные'", shopName = "Medved'"))
        basketList.add(Basket(id = "6", photoUrl = "https://www.technodom.kz/media/catalog/product/cache/1366e688ed42c99cd6439df4031862c6/f/1/f19c5f4f2f9f01872e634da80dc847e9589b2d35_38107_5.jpg", productName = "Samsung 27'd", shopName = "Technodom"))
        basketList.add(Basket(id = "7", photoUrl = "https://cdn11.bigcommerce.com/s-uod0rcncsw/images/stencil/375x375/products/137/974/PV2_Wireless_SigBlack_Hero__27274.1603935230.png?c=1", productName = "Wifi Positive Vibration", shopName = "Sulpak"))
        basketList.add(Basket(id = "8", photoUrl = "https://xiaomi-store.kz/images/stories/virtuemart/product/RN5_Black.jpg", productName = "Xiaomi Redmi Note 5", shopName = "Xiaomi"))

        if (basketList.isNotEmpty()) {
            result(basketList)
        } else {
            fail("Error")
        }
    }
}
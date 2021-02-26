package com.aslnstbk.qshop.shops.data

import com.aslnstbk.qshop.shops.domain.ShopsRepository
import com.aslnstbk.qshop.shops.data.models.Shop

class DefaultShopsRepository : ShopsRepository {

    override fun loadShopList(
        result: (List<Shop>) -> Unit,
        fail: (String) -> Unit
    ) {
        val shopsList: MutableList<Shop> = mutableListOf()

        shopsList.add(Shop(id = "1", photoUrl = "https://hh.kz/employer-logo/3100037.jpeg", name = "Lamoda", description = "магазин одежды"))
        shopsList.add(Shop(id = "2", photoUrl = "https://upload.wikimedia.org/wikipedia/ru/thumb/d/d3/Starbucks_Corporation_Logo_2011.svg/1200px-Starbucks_Corporation_Logo_2011.svg.png", name = "Starbucks", description = "лучший кофе"))
        shopsList.add(Shop(id = "3", photoUrl = "https://yt3.ggpht.com/ytc/AAUvwnhUXvX9RSwd3iLVoPvSYWHo_CT3TSfaR2Ekt3ZK=s900-c-k-c0x00ffffff-no-rj", name = "Coca-Cola", description = "годовой запас кока-колы"))
        shopsList.add(Shop(id = "4", photoUrl = "https://nashe.menu/images/restaurant/84/image_logo.jpg", name = "Shipudim", description = "шашлычная номер 1"))
        shopsList.add(Shop(id = "5", photoUrl = "https://st.weblancer.net/download/2141062_935xp.jpg", name = "Medved'", description = "ресторан русский кухни'"))
        shopsList.add(Shop(id = "6", photoUrl = "https://media-exp1.licdn.com/dms/image/C4E0BAQHxPOnsBFdLsw/company-logo_200_200/0/1534394141180?e=2159024400&v=beta&t=wuke9DuCnnr3y1jqj-waWMqeB3AxbXESBxNqUw9GPpg", name = "Technodom", description = "магазин техники"))
        shopsList.add(Shop(id = "7", photoUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPQv_XJB4WoKNftFQBJMa3T0i0Af2-zRCYTw&usqp=CAU", name = "Sulpak", description = "магазин техники"))
        shopsList.add(Shop(id = "8", photoUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Xiaomi_logo.svg/480px-Xiaomi_logo.svg.png", name = "Xiaomi", description = "магазин техники"))

        if (shopsList.isNotEmpty()) {
            result(shopsList)
        } else {
            fail("Error")
        }
    }
}
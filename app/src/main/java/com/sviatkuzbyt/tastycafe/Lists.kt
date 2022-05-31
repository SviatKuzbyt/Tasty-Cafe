package com.sviatkuzbyt.tastycafe

data class MenuConstructor(
    val id: Int,
    val name: String,
    val price: Int,
    val weight: String,
    val image: Int,
    val info: Int
    )

val listMenu = arrayOf(
    MenuConstructor(0, "Цезар", 60, "210 г", R.drawable.food_0, R.string.food_0),
    MenuConstructor(1, "Грецький салат", 75, "250 г", R.drawable.food_1, R.string.food_1),
    MenuConstructor(2, "Салат Капрезе", 85, "215 г", R.drawable.food_2, R.string.food_2),
    MenuConstructor(3, "Капрезе з томатами та сиром моцарелла", 128, "200 г", R.drawable.food_3, R.string.food_3),
    MenuConstructor(4, "Овочеве плато", 103, "300 г", R.drawable.food_4, R.string.food_4),
    MenuConstructor(5, "Сирне плато", 150, "300 г", R.drawable.food_5, R.string.food_5),
    MenuConstructor(6, "Млинці з сиром", 100, "210 г", R.drawable.food_6, R.string.food_6),
    MenuConstructor(7, "Омлет натуральний", 75, "80 г", R.drawable.food_7, R.string.none),
    MenuConstructor(8, "Яєчня з салом", 66, "200 г", R.drawable.food_8, R.string.food_8),
    MenuConstructor(9, "Деруни з сметаною", 70, "", R.drawable.food_9, R.string.food_9),
    MenuConstructor(10, "Піца з сиром", 75, "300 г", R.drawable.food_10, R.string.food_10),
    MenuConstructor(11, "Піца гавайська", 117, "360 г", R.drawable.food_11, R.string.food_11),
    MenuConstructor(12, "Піца Маргарита", 99, "325 г", R.drawable.food_12, R.string.food_12),
    MenuConstructor(13, "Чорний чай", 30, "400 мл", R.drawable.food_13, R.string.none),
    MenuConstructor(14, "Зелений чай", 40, "400 мл", R.drawable.food_14, R.string.none),
    MenuConstructor(15, "Кава", 45, "100 мл", R.drawable.food_15, R.string.none),
    MenuConstructor(16, "Амерекано", 45, "100 мл", R.drawable.food_16, R.string.none),
    MenuConstructor(17, "Coca cola", 40, "500 мл", R.drawable.food_17, R.string.none),
    MenuConstructor(18, "Лимонад", 50, "300 мл", R.drawable.food_18, R.string.none),
    MenuConstructor(19, "Коктейль", 50, "300 мл", R.drawable.food_19, R.string.none),
    MenuConstructor(20, "Фруктове морозово", 65, "150 г", R.drawable.food_20, R.string.food_20),
    MenuConstructor(21, "Морозиво з горішкам", 65, "150 г", R.drawable.food_21, R.string.food_21),
    MenuConstructor(22, "Круасан", 40, "", R.drawable.food_22, R.string.food_22),
    MenuConstructor(23, "Фруктовий салат", 50, "150 г", R.drawable.food_23, R.string.food_23),
    MenuConstructor(24, "Шоколадне тістечко", 60, "100 г", R.drawable.food_24, R.string.none),
    MenuConstructor(25, "Фруктове тісточко", 40, "60 г", R.drawable.food_25, R.string.none)
)

val listOrders = mutableListOf<MenuConstructor>()
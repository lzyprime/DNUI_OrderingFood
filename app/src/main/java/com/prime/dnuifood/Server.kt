package com.prime.dnuifood

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.prime.dnuifood.Beans.*
import java.net.URL

object Server {
    val BaseUrl = "http://172.24.10.175:8080/foodService/"
    fun login(username: String, userpass: String) = Gson().fromJson(
        URL(BaseUrl + "userLogin.do?username=${username}&userpass=${userpass}").readText(),
        LoginBean::class.java
    )

    fun register(username: String, userpass: String, mobilenum: String, addrmess: String, comment: String) =
        Gson().fromJson(
            URL("userRegister.do?username=${username}&userpass=${userpass}&mobilenum=${mobilenum}&addrmess=${addrmess}&comment=${comment}").readText(),
            SuccessBean::class.java
        )

    fun getAllShops() = Gson().fromJson<List<ShopBean>>(
        URL(BaseUrl + "getAllShops.do").readText(),
        object : TypeToken<List<ShopBean>>() {}.type
    )

    fun getFoodByShop(shop_id: String) = Gson().fromJson<List<FoodBean>>(
        URL(BaseUrl + "getFoodByShop.do?shop_id=${shop_id}").readText(),
        object : TypeToken<List<FoodBean>>() {}.type
    )

    fun collectShop(user_id: String, shop_id: String) = Gson().fromJson(
        URL(BaseUrl + "userCollectShop.do?user_id=${user_id}&shop_id=1").readText(),
        SuccessBean::class.java
    )

    fun isCollected(user_id: String, shop_food_id: String, flag: String) = Gson().fromJson(
        URL(BaseUrl + "isCollected.do?user_id=${user_id}&shop_food_id=${shop_food_id}&flag=${flag}").readText(),
        CollectedBean::class.java
    )

    fun getAllUsrCollection(user_id: String, flag: String) =
        Gson().fromJson<List<CollectListBean>>(
            URL(BaseUrl + "getAllUserCollection.do?user_id=${user_id}&flag=${flag}").readText(),
            object : TypeToken<List<CollectListBean>>() {}.type
        )

    fun getAllCommentsByFood(food_id: String) = Gson().fromJson<List<CommentBean>>(
        URL(BaseUrl + "getAllCommentsByFood.do?food_id=${food_id}").readText(),
        object : TypeToken<List<CommentBean>>() {}.type
    )

    fun getFoodById(food_id: String) =
        Gson().fromJson(URL(BaseUrl + "getFoodById.do?food_id=${food_id}").readText(), FoodBean::class.java)

    fun insertOrder(user_id: String, food_id: String, num: String, sum: Double, time: String, address: String) =
        Gson().fromJson(
            URL(BaseUrl + "insertOrder.do?user_id=${user_id}&food_id=${food_id}&num=${num}&sum=${sum}&suggesttime=${time}&address=${address}").readText(),
            SuccessBean::class.java
        )
}
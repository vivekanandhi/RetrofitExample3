package com.vivi.retrofitexample3.network
import android.media.Image
import com.squareup.moshi.Json
data class Character (

    @Json(name="name")
    val name:String,
    @Json(name="image")
    val image: String

)
data class CharacterResponse(
                             @Json(name="results")
                             val result:List<Character>)
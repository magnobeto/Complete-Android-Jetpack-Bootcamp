package com.example.recycleviewdemo1

import android.content.Context
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.io.IOException

object ListConverter {
    fun getJsonDataFromAsset(context: Context): List<SpecialItem> {
        var jsonString = ""
        try {
            jsonString =
                context.assets.open("interativos.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return listOf()
        }
        val gson = Gson()
        val itemType = object : TypeToken<List<SpecialItem>>() {}.type
        val itemList =
            gson.fromJson<List<SpecialItem>>(
                jsonString,
                itemType
            )
        return itemList
    }
}


data class SpecialItem(
    @SerializedName("Interativos") val ano: String,
    @SerializedName("Column2") val categoria: String,
    @SerializedName("Column3") val nome: String,
    @SerializedName("Column4") val url: String
)

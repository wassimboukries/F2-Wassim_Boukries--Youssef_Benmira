package com.example.ecommerceapplication

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.ecommerceapplication.Model.CategoryModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

class CategoryViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    val liveData = MutableLiveData<MutableList<CategoryModel>>()
    val categoriesNames = arrayOf("TVs & Projectors", "Laptops & Computers", "Apple", "Video Games, Consoles & VR",
            "Cell Phones",
            "Major Appliances",
            "Tablets & E-Readers",
            "Sound Bars, Speakers & Streaming Devices" ,
            "Headphones",
            "PC Gaming",
            "Small Appliances, Floor Care & Home Air Quality",
            "Wearable Technology",
            "Smart Home & Networking",
            "Cameras, Camcorders & Drones",
            "Toys, Games & Collectibles",
            "Printers, Ink & Home Office",
            "Health, Fitness & Personal Care",
            "Electric Transportation")
    val categoriesId = arrayOf("abcat0101000", "abcat0502000", "pcmcat128500050005", "")
    val categoriesImagesLinks = arrayOf(R.drawable.tv, R.drawable.laptops, R.drawable.apple, R.drawable.video_games, R.drawable.phones, R.drawable.mappls, R.drawable.tablets, R.drawable.speakers, R.drawable.headphones,
        R.drawable.pcgaming, R.drawable.smappls, R.drawable.wearabletech, R.drawable.smarthome, R.drawable.cameras, R.drawable.toys, R.drawable.printers, R.drawable.health, R.drawable.etranspo)
    private val TAG = "Category"

    fun fetch(){
        viewModelScope.launch(Dispatchers.IO) {
            val myService = Service()
            val result = myService.getCategoriesList()
            Log.v(TAG, result)
            /*if (result != null) {
                try {
                    // Parse result string JSON to data class
                    //categories = Klaxon().parse(result)
                    val json = JSONObject(result)
                    val HommeCatList = json.getJSONArray("navigation").getJSONObject(0)
                    val childrenList = HommeCatList.getJSONArray("children").getJSONObject(4).getJSONArray("children")
                    val categories = mutableListOf<CategoryModel>()
                    for (i in 0 until 10) {
                        val categoryObject: JSONObject = childrenList.getJSONObject(i)
                        val content = categoryObject.getJSONObject("content")
                        val title = content.getString("title")
                        val id = categoryObject.getString("id")
                        val imageLink = content.getString("webLargeImageUrl")
                        val category = CategoryModel(id, title, "", imageLink)
                        categories.add(category)
                    }
                    //childrenList.get (0..10)
                    Log.v(TAG, categories.toString())
                    liveData.postValue(categories)
                }
                catch(err:Error) {
                    print("Error when parsing JSON: "+err.localizedMessage)
                }
            }
            else {
                print("Error: Get request returned no response")
            }*/
        }
    }
}
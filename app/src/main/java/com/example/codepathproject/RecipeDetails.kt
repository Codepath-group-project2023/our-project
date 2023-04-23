package com.example.codepathproject

import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class RecipeDetails : AppCompatActivity() {
    private var imageURL = ""
    private var instructions = ""
    private var mealName = ""
    private lateinit var ingredientsList: MutableList<String>
    private lateinit var measurementsList: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)

        var recipeName: TextView = findViewById(R.id.recipe_name)
        var image: ImageView = findViewById(R.id.recipe_picture)
        var instructs: TextView = findViewById(R.id.recipe_instructions)
        var ingreds: TextView = findViewById(R.id.recipe_ingredients)
        mealName = intent.getStringExtra("meal").toString()
        ingredientsList = mutableListOf()
        measurementsList = mutableListOf()

        getDetails(recipeName, image, instructs, ingreds)
    }
    private fun getDetails(recipeName: TextView,
                           image: ImageView,
                           instructs: TextView,
                           ingreds: TextView) {
        val client = AsyncHttpClient()

        client["https://www.themealdb.com/api/json/v1/1/search.php?s=$mealName", object: JsonHttpResponseHandler(){
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Recipe details error",errorResponse)
            }

            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                Log.d("Get recipe details","success")
                val recipe = json.jsonObject.getJSONArray("meals").getJSONObject(0)
                instructions = recipe.getString("strInstructions")
                imageURL = recipe.getString("strMealThumb")
                for (i in 1 until 21) {
                    val ingred = recipe.getString("strIngredient$i")
                    val measurements = recipe.getString("strMeasure$i")
                    if(ingred != null && ingred != ""){
                        ingredientsList.add(ingred)
                        measurementsList.add(measurements)
                    }
                }
                Log.d("details","$instructions")
                loadDetails(recipeName,image,instructs,ingreds)
            }
        }]
    }
    private fun loadDetails(recipeName: TextView,image: ImageView,instructs: TextView, ingreds: TextView){
        recipeName.text = mealName
        instructs.text = instructions
        var array = measurementsList.zip(ingredientsList) {a,b -> "$a $b"} //combines measurement and ingredients list
        var list = ""
        for(item in array)
            list = list + item + "\n"
        ingreds.text = list
        Glide.with(this)
            .load(imageURL)
            .into(image)
    }
    // ActivityTwo.kt
    fun onSubmit(v: View) {
        // closes the activity and returns to first screen
        this.finish();
    }
}

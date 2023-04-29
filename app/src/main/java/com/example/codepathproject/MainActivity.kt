package com.example.codepathproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers


class MainActivity : AppCompatActivity() {

    private lateinit var imagelist: MutableList<String>
    private lateinit var namelist: MutableList<String>
    private lateinit var categorylist: MutableList<String>
    private lateinit var arealist: MutableList<String>
    var inputText = ""
    private lateinit var rvRecipes: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        rvRecipes = findViewById(R.id.recipe_list)
        imagelist = mutableListOf()
        namelist = mutableListOf()
        categorylist = mutableListOf()
        arealist = mutableListOf()

        var button = findViewById<Button>(R.id.SearchButton)

        getRecipe(button)
        Log.d("RecipeURL", "Recipe URL set")

        var randomButton = findViewById<Button>(R.id.randomButton)
        random(randomButton)
    }

    private fun getRecipe(button: Button) {
        button.setOnClickListener {

            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(
                button.getWindowToken(),
                InputMethodManager.RESULT_UNCHANGED_SHOWN
            )

            var input = findViewById<EditText>(R.id.SearchBar)
            inputText = input.getText().toString()
            imagelist.clear()
            namelist.clear()
            categorylist.clear()
            arealist.clear()

            getRecipeURL()
        }
    }

    private fun getRecipeURL() {
        var client = AsyncHttpClient()

        client["https://www.themealdb.com/api/json/v1/1/search.php?s=$inputText", object :
            JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Recipe Error", errorResponse)
            }

            override fun onSuccess(
                statusCode: Int,
                headers: Headers,
                json: JsonHttpResponseHandler.JSON)
            {
                Log.d("Recipe Success", "$json")


                var getRecipe = json.jsonObject.getJSONArray("meals")
                if(getRecipe != null){
                    for (i in 0 until getRecipe.length()) {
                        var imageArray = getRecipe.getJSONObject(i)
                        imagelist.add(imageArray.getString("strMealThumb"))
                    }

                    for (i in 0 until getRecipe.length()) {
                        var imageArray = getRecipe.getJSONObject(i)
                        namelist.add(imageArray.getString("strMeal"))
                    }

                    for (i in 0 until getRecipe.length()) {
                        var imageArray = getRecipe.getJSONObject(i)
                        categorylist.add(imageArray.getString("strCategory"))
                    }

                    for (i in 0 until getRecipe.length()) {
                        var imageArray = getRecipe.getJSONObject(i)
                        arealist.add(imageArray.getString("strArea"))
                    }

                    var adapter = RecipeAdapter(imagelist, namelist, categorylist, arealist)
                    rvRecipes.adapter = adapter
                    rvRecipes.layoutManager = LinearLayoutManager(this@MainActivity)

                    val text = "Search successful!"
                    val duration = Toast.LENGTH_SHORT

                    val toast = Toast.makeText(applicationContext, text, duration)
                    toast.show()

                    //this is for being able to click on an item in recycler view
                    adapter.setOnItemClickListener(object : RecipeAdapter.onItemClickListener {
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@MainActivity, RecipeDetails::class.java)
                            intent.putExtra("meal", namelist[position])
                            startActivity(intent)
                        }
                    })
                }
                else{
                    Toast.makeText(this@MainActivity,"error",Toast.LENGTH_SHORT)
                }

            }
        }]
    }

    private fun random(randomButton: Button) {
        randomButton.setOnClickListener(){

            var client = AsyncHttpClient()

            client["https://www.themealdb.com/api/json/v1/1/random.php", object : JsonHttpResponseHandler() {
                override fun onFailure(
                    statusCode: Int,
                    headers: Headers?,
                    errorResponse: String,
                    throwable: Throwable?
                ) { Log.d("Recipe Error", errorResponse) }

                override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                    Log.d("Recipe Success", "$json")
                    var getRecipe = json.jsonObject.getJSONArray("meals")
                    var recipe = getRecipe.getJSONObject(0)
                    var name = recipe.getString("strMeal")


                val intent = Intent(this@MainActivity, RecipeDetails::class.java)
                intent.putExtra("meal", name)
                startActivity(intent)
                }
            }]

        }
    }
}
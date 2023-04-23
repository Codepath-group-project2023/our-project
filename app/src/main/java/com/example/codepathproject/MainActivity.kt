package com.example.codepathproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class MainActivity : AppCompatActivity() {

    private lateinit var imagelist: MutableList<String>
    private lateinit var userlist: MutableList<String>
    private lateinit var categorylist: MutableList<String>
    var input = ""
    private lateinit var rvRecipes: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvRecipes = findViewById(R.id.recipe_list)
        imagelist = mutableListOf()
        userlist = mutableListOf()
        categorylist = mutableListOf()

        configureCategories()
    }
    private fun configureCategories(){
        val client = AsyncHttpClient()

        client["https://www.themealdb.com/api/json/v1/1/categories.php", object : JsonHttpResponseHandler(){
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Category Error",errorResponse)
            }

            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                Log.d("Category Success", "categories")
            }
        }]
    }
}
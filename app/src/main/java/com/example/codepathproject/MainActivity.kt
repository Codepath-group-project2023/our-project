package com.example.codepathproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

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


    }
}
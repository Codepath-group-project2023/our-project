package com.example.codepathproject

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class RecipeDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)


    }

    // ActivityTwo.kt
    fun onSubmit(v: View) {
        // closes the activity and returns to first screen
        this.finish();
    }
}

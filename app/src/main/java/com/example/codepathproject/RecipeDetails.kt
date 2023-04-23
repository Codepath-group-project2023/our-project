package com.example.codepathproject

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipeDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_details)


    }

    // ActivityTwo.kt
    fun onSubmit(v: View) {
        // closes the activity and returns to first screen
        this.finish();
    }
}

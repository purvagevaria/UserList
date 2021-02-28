package com.app.assignment.utils

import android.app.Activity
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import coil.load
import coil.transform.RoundedCornersTransformation

fun ImageView.loadImg(imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        this.load(imageUrl) {
            transformations(RoundedCornersTransformation(4f))
        }
    }
}

inline fun <reified VM : ViewModel> AppCompatActivity.viewModelOf(factory: ViewModelProvider.Factory) =
    ViewModelProvider(this, factory).get(VM::class.java)


fun Activity.showToast(message: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, duration).show()
}
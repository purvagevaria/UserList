package com.app.purvaassignment.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.app.assignment.utils.loadImg

class BindingUtils {

    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun setDisplayPic(image: ImageView, imageUrl: String) {
            image.loadImg(imageUrl)
        }
    }

}
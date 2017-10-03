package com.ansgar.kotlinweatherapp.utils

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by kirill on 3.10.17.
 */
fun ImageView.loadUri(uri: Uri) {
    Glide.with(this).load(uri).into(this)
}
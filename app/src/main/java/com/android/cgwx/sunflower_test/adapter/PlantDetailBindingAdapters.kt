/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.cgwx.sunflower_test.adapter

import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.android.cgwx.sunflower_test.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
                .load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view)
    }
}

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter("wateringText")
fun bindWateringText(textView: TextView, wateringInterval: Int) {
    textView.text = textView.context.resources.getQuantityString(
        R.plurals.watering_needs_suffix,
        wateringInterval,
        wateringInterval
    )
}

@BindingAdapter("renderHtml")
fun bindRenderHtml(view: TextView, description: String?) {
    if (description != null) {
        view.text = HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_COMPACT)
        view.movementMethod = LinkMovementMethod.getInstance()
    }else{
        view.text = ""
    }
}
//@BindingAdapter("isFabGone")
//fun bindIsFabGone(view: FloatingActionButton, isGone: Boolean?) {
//    if (isGone == null || isGone) {
//        view.hide()
//    } else {
//        view.show()
//    }
//}
//
//@BindingAdapter("renderHtml")
//fun bindRenderHtml(view: TextView, description: String?) {
//    if (description != null) {
//        view.text = HtmlCompat.fromHtml(description, FROM_HTML_MODE_COMPACT)
//        view.movementMethod = LinkMovementMethod.getInstance()
//    } else {
//        view.text = ""
//    }
//}
//
//@BindingAdapter("wateringText")
//fun bindWateringText(textView: TextView, wateringInterval: Int) {
//    val resources = textView.context.resources
//    val quantityString = resources.getQuantityString(R.plurals.watering_needs_suffix,
//        wateringInterval, wateringInterval)
//
//    textView.text = quantityString
//}

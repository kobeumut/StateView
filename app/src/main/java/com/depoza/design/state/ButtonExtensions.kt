package com.depoza.design.state

import android.content.Context
import androidx.annotation.ColorInt
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.ViewCompat
import androidx.appcompat.widget.AppCompatButton
import android.widget.Button

/**
 * Creates Android Button widget based on [Button] description
 */
fun com.depoza.design.state.Button.createView(context: Context): Button {
    val result = AppCompatButton(context)
    result.text = this.text
    this.textHexColor?.let { result.setTextColor(it.toIntColor()) }
    this.bgHexColor.takeIf { !it.isNullOrBlank() }?.let {
        result.applyBackgroundColor(it.toIntColor())
    }
    return result
}

/**
 * Applies new [color] to the Android Button widget
 */
fun Button.applyBackgroundColor(@ColorInt color: Int) {
    val btnDrawable = DrawableCompat.wrap(this.background)
    DrawableCompat.setTint(btnDrawable, color)
    ViewCompat.setBackground(this, btnDrawable)
}

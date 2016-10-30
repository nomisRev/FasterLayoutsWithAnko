package be.vergauwen.simon.fasterankolayouts.ui

import android.view.View


interface ViewBinder<in T> {
    fun bind(t: T) : View
    fun unbind(t: T)
}

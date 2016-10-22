package be.vergauwen.simon.fasterankolayouts.ui

import android.view.View


interface ViewBinder<in T> {
    fun T.bind() : View
    fun T.unbind()
}
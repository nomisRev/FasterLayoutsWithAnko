package be.vergauwen.simon.fasterankolayouts.ui.detail

import android.view.View
import be.vergauwen.simon.fasterankolayouts.ui.ViewBinder
import org.jetbrains.anko.UI
import org.jetbrains.anko.dip
import org.jetbrains.anko.padding
import org.jetbrains.anko.textView


class DetailFragmentLayout : ViewBinder<ItemDetailFragment> {

    override fun ItemDetailFragment.bind(): View =
            activity.UI {
                textView = textView {
                    padding = dip(16)
                    setTextIsSelectable(true)
                }
            }.view

    override fun ItemDetailFragment.unbind() {
        textView = null
    }
}
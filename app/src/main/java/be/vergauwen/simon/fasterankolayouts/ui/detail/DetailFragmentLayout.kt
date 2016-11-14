package be.vergauwen.simon.fasterankolayouts.ui.detail

import android.view.View
import be.vergauwen.simon.fasterankolayouts.ui.ViewBinder
import org.jetbrains.anko.UI
import org.jetbrains.anko.dip
import org.jetbrains.anko.padding
import org.jetbrains.anko.textView


class DetailFragmentLayout : ViewBinder<ItemDetailFragment> {

    override fun bind(t: ItemDetailFragment): View =
            t.activity.UI {
                t.textView = textView {
                    padding = dip(16)
                    setTextIsSelectable(true)
                }
            }.view

    override fun unbind(itemDetailFragment: ItemDetailFragment) {
        itemDetailFragment.textView = null
    }
}

package be.vergauwen.simon.fasterankolayouts.ui.detail

import android.support.design.widget.AppBarLayout
import android.support.design.widget.AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
import android.support.design.widget.AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
import android.support.design.widget.CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PIN
import android.view.View
import be.vergauwen.simon.fasterankolayouts.R
import be.vergauwen.simon.fasterankolayouts.ui.ViewBinder
import be.vergauwen.simon.fasterankolayouts.ui.anko.actionBarSize
import be.vergauwen.simon.fasterankolayouts.ui.anko.collapseLayoutParams
import be.vergauwen.simon.fasterankolayouts.ui.anko.color
import org.jetbrains.anko.UI
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.collapsingToolbarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.support.v4.nestedScrollView


class DetailActivityLayout : ViewBinder<DetailActivity> {
    override fun bind(t: DetailActivity): View {
        return t.UI {
            coordinatorLayout {
                fitsSystemWindows = true

                appBarLayout {
                    fitsSystemWindows = true

                    collapsingToolbarLayout(R.style.AppTheme_PopupOverlay) {
                        fitsSystemWindows = true
                        setContentScrimColor(color(R.color.colorPrimary))
                        id = R.id.toolbar_layout

                        t.toolbar = toolbar(R.style.AppTheme_PopupOverlay) {
                            t.setSupportActionBar(this)
                            t.supportActionBar?.setDisplayHomeAsUpEnabled(true)
                        }.collapseLayoutParams(width = matchParent, height = actionBarSize()) {
                            collapseMode = COLLAPSE_MODE_PIN
                        }

                    }.lparams(width = matchParent, height = matchParent) {
                        scrollFlags = SCROLL_FLAG_SCROLL or SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
                    }

                }.lparams(width = matchParent, height = dip(200))

                t.detailContainer = nestedScrollView {
                    id = R.id.item_detail_container
                }.lparams(width = matchParent, height = matchParent) {
                    behavior = AppBarLayout.ScrollingViewBehavior()
                }
            }
        }.view
    }

    override fun unbind(t: DetailActivity) {
        t.toolbar = null
        t.detailContainer = null
    }
}
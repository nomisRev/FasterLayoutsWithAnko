package be.vergauwen.simon.fasterankolayouts.ui.main

import android.support.design.widget.AppBarLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import be.vergauwen.simon.fasterankolayouts.R
import be.vergauwen.simon.fasterankolayouts.dummy.DummyContent
import be.vergauwen.simon.fasterankolayouts.ui.ViewBinder
import be.vergauwen.simon.fasterankolayouts.ui.adapter.SimpleItemRecyclerViewAdapter
import be.vergauwen.simon.fasterankolayouts.ui.anko.actionBarSize
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView


class MainLayout : ViewBinder<MainActivity> {

    override fun bind(mainActivity: MainActivity): View =
            mainActivity.UI {
                coordinatorLayout {
                    fitsSystemWindows = true

                    appBarLayout {
                        toolbar(R.style.AppTheme_PopupOverlay) {
                            mainActivity.setSupportActionBar(this)
                            mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(false)
                        }.lparams(width = matchParent, height = actionBarSize())
                    }.lparams(width = matchParent)

                    linearLayout {

                        configuration(orientation = Orientation.PORTRAIT) {
                            mainActivity.recycView = recyclerView {
                                init()
                            }.lparams(width = matchParent, height = matchParent)
                        }

                        configuration(orientation = Orientation.LANDSCAPE) {
                            linearLayout {
                                mainActivity.recycView = recyclerView {
                                    init()
                                }.lparams(width = dip(200), height = matchParent)

                                mainActivity.detailContainer = frameLayout {
                                    id = R.id.item_detail_container
                                }.lparams(width = matchParent, height = matchParent)
                            }
                            mainActivity.recycView = recyclerView {
                                init()
                            }.lparams(width = dip(275), height = matchParent)

                            mainActivity.detailContainer = frameLayout {
                                id = R.id.item_detail_container
                            }.lparams(width = matchParent, height = matchParent)
                        }
                    }.lparams(width = matchParent, height = matchParent) {
                        behavior = AppBarLayout.ScrollingViewBehavior()
                    }

                }
            }.view

    override fun unbind(t: MainActivity) {
        t.recycView = null
        t.detailContainer = null

    }

    private fun RecyclerView.init() {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        adapter = SimpleItemRecyclerViewAdapter(DummyContent.ITEMS)
    }
}

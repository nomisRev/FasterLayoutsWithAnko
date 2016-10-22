package be.vergauwen.simon.fasterankolayouts.ui.main

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
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView


class MainLayout : ViewBinder<MainActivity> {

    override fun MainActivity.bind(): View =
            UI {
                coordinatorLayout {
                    toolbar {
                        setSupportActionBar(this)
                    }.lparams(width = matchParent, height = actionBarSize())

                    container = linearLayout {

                        configuration(orientation = Orientation.PORTRAIT) {
                            recycView = recyclerView {
                                init()
                            }.lparams(width = matchParent, height = matchParent)
                        }

                        configuration(orientation = Orientation.LANDSCAPE) {
                            recycView = recyclerView {
                                init()
                            }.lparams(width = dip(275), height = matchParent)

                            detailContainer = frameLayout {
                                id = R.id.item_detail_container
                            }.lparams(width = matchParent, height = matchParent)
                        }
                    }
                }
            }.view

    override fun MainActivity.unbind() {
        container = null
        recycView = null
        detailContainer = null
    }

    private fun RecyclerView.init() {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        adapter = SimpleItemRecyclerViewAdapter(DummyContent.ITEMS)
    }
}
package be.vergauwen.simon.fasterankolayouts.ui.util

import android.support.v7.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent

interface OnItemClickListener {
    fun onItemClick(viewHolder: RecyclerView.ViewHolder, position: Int)
}

fun RecyclerView.onItemClick(onItemClick: (RecyclerView.ViewHolder, Int) -> Unit) {
    addItemClickListener(object : OnItemClickListener {
        override fun onItemClick(viewHolder: RecyclerView.ViewHolder, position: Int) {
            onItemClick.invoke(viewHolder, position)
        }
    })
}

fun RecyclerView.addItemClickListener(listener: OnItemClickListener) {

    val gestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
        override fun onSingleTapUp(e: MotionEvent): Boolean {
            return true
        }
    })


    this.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
        override fun onTouchEvent(rv: RecyclerView?, e: MotionEvent?) {
        }

        override fun onInterceptTouchEvent(rv: RecyclerView?, e: MotionEvent): Boolean {
            val childView = this@addItemClickListener.findChildViewUnder(e.x, e.y)
            if (childView != null && rv != null && gestureDetector.onTouchEvent(e)) {
                listener.onItemClick(rv.getChildViewHolder(childView), this@addItemClickListener.getChildAdapterPosition(childView))
            }
            return false
        }

        override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        }
    })
}
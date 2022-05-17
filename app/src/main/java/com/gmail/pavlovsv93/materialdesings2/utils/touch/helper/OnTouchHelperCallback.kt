package com.gmail.pavlovsv93.materialdesings2.utils.touch.helper

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.gmail.pavlovsv93.materialdesings2.ui.recyclerviewfragment.RecyclerViewAdapter

class OnTouchHelperCallback(private val recyclerViewAdapter: RecyclerViewAdapter) :
	ItemTouchHelper.Callback() {
	override fun getMovementFlags(
		recyclerView: RecyclerView,
		viewHolder: RecyclerView.ViewHolder
	): Int {
		var dragFlag: Int? = null
		var swipeFlag: Int? = null
		var makeMovementFlag: Int
		if (viewHolder !is RecyclerViewAdapter.HeaderViewHolder) {
			dragFlag = ItemTouchHelper.DOWN or ItemTouchHelper.UP
			swipeFlag = ItemTouchHelper.END or ItemTouchHelper.START
		}
		if (dragFlag != null && swipeFlag != null) {
			makeMovementFlag = makeMovementFlags(dragFlag, swipeFlag)
		} else {
			makeMovementFlag = ItemTouchHelper.ACTION_STATE_IDLE
		}
		return makeMovementFlag
	}

	override fun onMove(
		recyclerView: RecyclerView,
		viewHolder: RecyclerView.ViewHolder,    // Положение начала движения
		target: RecyclerView.ViewHolder            // Положение окончания движения
	): Boolean {
		recyclerViewAdapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
		return true
	}

	override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
		if (direction == ItemTouchHelper.START) {
			recyclerViewAdapter.onItemDismiss(viewHolder.adapterPosition)
		} else if (direction == ItemTouchHelper.END) {
			recyclerViewAdapter.addElement(viewHolder.adapterPosition)
		}

	}

	override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
		if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
			when (viewHolder) {
				is RecyclerViewAdapter.MarsViewHolder -> {
					viewHolder.onItemSelected()
				}
				is RecyclerViewAdapter.EarthViewHolder -> {
					viewHolder.onItemSelected()
				}
			}
		}
	}

	override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
		when (viewHolder) {
			is RecyclerViewAdapter.MarsViewHolder -> {
				viewHolder.onItemClear()
			}
			is RecyclerViewAdapter.EarthViewHolder -> {
				viewHolder.onItemClear()
			}
		}
	}
}
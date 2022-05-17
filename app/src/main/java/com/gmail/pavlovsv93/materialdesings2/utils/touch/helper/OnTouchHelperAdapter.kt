package com.gmail.pavlovsv93.materialdesings2.utils.touch.helper

interface OnTouchHelperAdapter {
	fun onItemMove(fromPosition: Int, toPosition: Int)
	fun onItemDismiss(position: Int)
}
package com.gmail.pavlovsv93.materialdesings2.utils

import androidx.recyclerview.widget.DiffUtil
import com.gmail.pavlovsv93.materialdesings2.domain.entity.DataItemListEntity

class DiffUtilsCallback(
	val oldItemsList: List<Pair<DataItemListEntity, Boolean>>,
	val newItemsList: List<Pair<DataItemListEntity, Boolean>>
) : DiffUtil.Callback() {
	//todo Возвращаем количество элементов старого списка
	override fun getOldListSize(): Int = oldItemsList.size

	//todo Возвращаем количество элементов нового списка
	override fun getNewListSize(): Int = newItemsList.size

	//todo сравниваемм одинаковые элементы для поиска изменений в них
	override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
		oldItemsList[oldItemPosition].first.id == newItemsList[newItemPosition].first.id

	//todo сравнение элементов на совпадение всех возможных изменений в itemView двух списков
	override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
		return oldItemsList[oldItemPosition].first.title == newItemsList[newItemPosition].first.title
				&& oldItemsList[oldItemPosition].first.description == newItemsList[newItemPosition].first.description
	}

	override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
		val old = oldItemsList[oldItemPosition]
		val new = newItemsList[newItemPosition]
		return Change(old, new)
	}
}
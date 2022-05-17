package com.gmail.pavlovsv93.materialdesings2.ui.recyclerviewfragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gmail.pavlovsv93.materialdesings2.databinding.FragmentRecyclerViewEarthItemBinding
import com.gmail.pavlovsv93.materialdesings2.databinding.FragmentRecyclerViewEmptyItemBinding
import com.gmail.pavlovsv93.materialdesings2.databinding.FragmentRecyclerViewHeaderItemBinding
import com.gmail.pavlovsv93.materialdesings2.databinding.FragmentRecyclerViewMarsItemBinding
import com.gmail.pavlovsv93.materialdesings2.domain.entity.DataItemListEntity
import com.gmail.pavlovsv93.materialdesings2.domain.entity.TYPE_EARTH
import com.gmail.pavlovsv93.materialdesings2.domain.entity.TYPE_HEADER
import com.gmail.pavlovsv93.materialdesings2.domain.entity.TYPE_MARS
import com.gmail.pavlovsv93.materialdesings2.utils.touch.helper.OnTouchHelperAdapter
import com.gmail.pavlovsv93.materialdesings2.utils.touch.helper.OnTouchHelperViewHolder

class RecyclerViewAdapter(val clickItemListener: RecyclerViewFragment.OnClickItemListener) :
	RecyclerView.Adapter<RecyclerViewAdapter.BaseViewHolder>(), OnTouchHelperAdapter {

	private val listData: MutableList<Pair<DataItemListEntity, Boolean>> = mutableListOf()

	@SuppressLint("NotifyDataSetChanged")
	fun setData(listData: List<Pair<DataItemListEntity, Boolean>>) {
		this.listData.clear()
		this.listData.addAll(listData)
		notifyDataSetChanged()
	}
	fun addElement(adapterPosition: Int) {
		listData.add(listData.size,generationData())
		notifyItemInserted(listData.size)
		notifyItemChanged(adapterPosition)
	}

	fun generationData() = Pair(DataItemListEntity(title = "MarsAdd", type = TYPE_MARS), false)

	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): BaseViewHolder {
		return when (viewType) {
			TYPE_EARTH -> {
				val binding = FragmentRecyclerViewEarthItemBinding.inflate(
					LayoutInflater.from(parent.context),
					parent,
					false
				)
				EarthViewHolder(binding.root)
			}
			TYPE_MARS -> {
				val binding = FragmentRecyclerViewMarsItemBinding.inflate(
					LayoutInflater.from(parent.context),
					parent,
					false
				)
				MarsViewHolder(binding.root)
			}
			TYPE_HEADER -> {
				val binding = FragmentRecyclerViewHeaderItemBinding.inflate(
					LayoutInflater.from(parent.context),
					parent,
					false
				)
				HeaderViewHolder(binding.root)
			}
			else -> {
				val binding = FragmentRecyclerViewEmptyItemBinding.inflate(
					LayoutInflater.from(parent.context),
					parent,
					false
				)
				EmptyViewHolder(binding.root)
			}
		}
	}

	override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
		holder.bind(listData[position])
	}

	override fun getItemCount(): Int = listData.size

	override fun getItemViewType(position: Int): Int {
		return listData[position].first.type
	}

	abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		abstract fun bind(data: Pair<DataItemListEntity, Boolean>)
	}

	inner class EarthViewHolder(itemView: View) : BaseViewHolder(itemView), OnTouchHelperViewHolder {
		override fun bind(data: Pair<DataItemListEntity, Boolean>) {
			FragmentRecyclerViewEarthItemBinding.bind(itemView).apply {
				titleTextView.text = data.first.title
				descriptionTextView.text = data.first.description
				cardView.setOnClickListener {
					clickItemListener.onItemClick(data = data.first)
				}
			}
		}

		override fun onItemSelected() {
			itemView.isSelected = true
		}

		override fun onItemClear() {
			itemView.isSelected = false
		}
	}

	inner class MarsViewHolder(itemView: View) : BaseViewHolder(itemView), OnTouchHelperViewHolder {
		override fun bind(data: Pair<DataItemListEntity, Boolean>) {
			FragmentRecyclerViewMarsItemBinding.bind(itemView).apply {
				titleTextView.text = data.first.title
				cardView.setOnClickListener {
					listData[layoutPosition] = listData[layoutPosition].let {
						it.first to !it.second
					}
					descriptionTextView.visibility = if (data.second) {
						View.VISIBLE
					} else {
						View.GONE
					}
					notifyItemChanged(layoutPosition)
					clickItemListener.onItemClick(data = data.first)
				}
				delete.setOnClickListener {
					listData.removeAt(layoutPosition)
					notifyItemRemoved(layoutPosition)
				}
				add.setOnClickListener {
					listData.add(layoutPosition, generationData())
					notifyItemInserted(layoutPosition)
				}
				up.setOnClickListener {
					if (layoutPosition > 0 && listData[layoutPosition - 1].first.type != TYPE_HEADER) {
						listData.removeAt(layoutPosition).apply {
							listData.add(layoutPosition - 1, this)
						}
						notifyItemMoved(layoutPosition, layoutPosition - 1)
					}
				}
				down.setOnClickListener {
					if (listData.size - 1 > layoutPosition && listData[layoutPosition + 1].first.type != TYPE_HEADER) {
						listData.removeAt(layoutPosition).apply {
							listData.add(layoutPosition + 1, this)
						}
						notifyItemMoved(layoutPosition, layoutPosition + 1)
					}
				}
			}
		}

		override fun onItemSelected() {
			itemView.alpha = 0.7f
		}

		override fun onItemClear() {
			itemView.alpha = 1f
		}
	}

	inner class HeaderViewHolder(itemView: View) : BaseViewHolder(itemView) {
		override fun bind(data: Pair<DataItemListEntity, Boolean>) {
			FragmentRecyclerViewHeaderItemBinding.bind(itemView).apply {
				headerTitleTextView.text = data.first.title
				cardView.setOnClickListener {
					clickItemListener.onItemClick(data = data.first)
				}
			}
		}
	}

	inner class EmptyViewHolder(itemView: View) : BaseViewHolder(itemView) {
		override fun bind(data: Pair<DataItemListEntity, Boolean>) { return	}
	}

	override fun onItemMove(fromPosition: Int, toPosition: Int) {
		if (listData[toPosition].first.type != TYPE_HEADER) {
			listData.removeAt(fromPosition).apply {
				listData.add(toPosition, this)
			}
			notifyItemMoved(fromPosition, toPosition)
		}
	}

	override fun onItemDismiss(position: Int) {
		if (listData[position].first.type != TYPE_HEADER) {
			listData.removeAt(position)
			notifyItemRemoved(position)
		} else {
			notifyItemChanged(position)
		}
	}
}
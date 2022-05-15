package com.gmail.pavlovsv93.materialdesings2.ui.recyclerviewfragment

import android.annotation.SuppressLint
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

class RecyclerViewAdapter(val clickItemListener: RecyclerViewFragment.OnClickItemListener) :
	RecyclerView.Adapter<RecyclerView.ViewHolder>() {

	private val listData: MutableList<DataItemListEntity> = mutableListOf()

	@SuppressLint("NotifyDataSetChanged")
	fun setData(listData: List<DataItemListEntity>) {
		this.listData.clear()
		this.listData.addAll(listData)
		notifyDataSetChanged()
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
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

	override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
		when (holder) {
			is EarthViewHolder -> { holder.bind(listData[position]) }
			is MarsViewHolder -> { holder.bind(listData[position]) }
			is HeaderViewHolder -> { holder.bind(listData[position]) }
			is EmptyViewHolder -> { }
		}
	}

	override fun getItemCount(): Int = listData.size

	override fun getItemViewType(position: Int): Int {
		return listData[position].type
	}

	inner class EarthViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		fun bind(data: DataItemListEntity) {
			FragmentRecyclerViewEarthItemBinding.bind(itemView).apply {
				titleTextView.text = data.title
				descriptionTextView.text = data.description
				cardView.setOnClickListener {
					clickItemListener.onItemClick(data = data)
				}
			}
		}
	}

	inner class MarsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		fun bind(data: DataItemListEntity) {
			FragmentRecyclerViewMarsItemBinding.bind(itemView).apply {
				titleTextView.text = data.title
				cardView.setOnClickListener {
					clickItemListener.onItemClick(data = data)
				}
			}
		}
	}

	inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		fun bind(data: DataItemListEntity) {
			FragmentRecyclerViewHeaderItemBinding.bind(itemView).apply {
				headerTitleTextView.text = data.title
				cardView.setOnClickListener {
					clickItemListener.onItemClick(data = data)
				}
			}
		}
	}

	inner class EmptyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
	}
}
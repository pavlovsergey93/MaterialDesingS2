package com.gmail.pavlovsv93.materialdesings2.ui.recyclerviewfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmail.pavlovsv93.materialdesings2.data.MockRepos
import com.gmail.pavlovsv93.materialdesings2.databinding.FragmentRecyclerViewBinding
import com.gmail.pavlovsv93.materialdesings2.domain.ReposInterface
import com.gmail.pavlovsv93.materialdesings2.domain.entity.DataItemListEntity
import com.gmail.pavlovsv93.materialdesings2.utils.touch.helper.OnTouchHelperCallback

class RecyclerViewFragment : Fragment() {
	interface OnItemActionListener {
		fun onItemClick(data: DataItemListEntity)
		fun onItemDrag(viewHolder: RecyclerViewAdapter.BaseViewHolder)
	}

	private var _binding: FragmentRecyclerViewBinding? = null
	private val binding get() = _binding!!
	private val repos: ReposInterface by lazy { MockRepos() }
	private val itemTouchHelper: ItemTouchHelper by lazy {
		ItemTouchHelper(OnTouchHelperCallback(adapter))
	}
	private var flagRefreshList: Boolean = false

	companion object {
		fun newInstance() = RecyclerViewFragment()
	}

	private val adapter: RecyclerViewAdapter = RecyclerViewAdapter(object : OnItemActionListener {
		override fun onItemClick(data: DataItemListEntity) {
			Toast.makeText(requireContext(), data.title, Toast.LENGTH_SHORT).show()
		}

		override fun onItemDrag(viewHolder: RecyclerViewAdapter.BaseViewHolder) {
			itemTouchHelper.startDrag(viewHolder)
		}
	})

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onDestroy() {
		_binding = null
		super.onDestroy()
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val recyclerView: RecyclerView = binding.planetRecyclerView
		recyclerView.layoutManager =
			LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
		recyclerView.adapter = adapter
		itemTouchHelper.attachToRecyclerView(recyclerView)
		val data = repos.getDataRepos().shuffled()
		adapter.setData(data)
		binding.fragmentRecyclerViewFab.setOnClickListener {
			if (flagRefreshList){
				flagRefreshList = !flagRefreshList
				adapter.setData(repos.getOtherDataRepos())
			} else {
				flagRefreshList = !flagRefreshList
				adapter.setData(repos.getDataRepos())
			}
		}
	}
}
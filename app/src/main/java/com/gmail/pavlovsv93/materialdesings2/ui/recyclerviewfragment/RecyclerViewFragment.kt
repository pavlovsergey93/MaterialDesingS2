package com.gmail.pavlovsv93.materialdesings2.ui.recyclerviewfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmail.pavlovsv93.materialdesings2.data.MockRepos
import com.gmail.pavlovsv93.materialdesings2.databinding.FragmentRecyclerViewBinding
import com.gmail.pavlovsv93.materialdesings2.domain.ReposInterface
import com.gmail.pavlovsv93.materialdesings2.domain.entity.DataItemListEntity

class RecyclerViewFragment : Fragment() {
	interface OnClickItemListener {
		fun onItemClick(data: DataItemListEntity)
	}

	private var _binding: FragmentRecyclerViewBinding? = null
	private val binding get() = _binding!!
	private val repos: ReposInterface by lazy { MockRepos() }

	companion object {
		fun newInstance() = RecyclerViewFragment()
	}

	private val adapter: RecyclerViewAdapter = RecyclerViewAdapter(object : OnClickItemListener {
		override fun onItemClick(data: DataItemListEntity) {
			Toast.makeText(requireContext(), data.title, Toast.LENGTH_SHORT).show()
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
		val data = repos.getDataRepos().shuffled()
		adapter.setData(data)
	}
}
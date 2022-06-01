package com.gmail.pavlovsv93.materialdesings2.ui.fondfamilyfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gmail.pavlovsv93.materialdesings2.databinding.FragmentFondFamilyBinding
import com.gmail.pavlovsv93.materialdesings2.databinding.FragmentMaterialDesingBinding

class FondFamilyFragment: Fragment() {
	private var _binding: FragmentFondFamilyBinding? = null
	private val binding get() = _binding!!

	companion object {
		fun newInstance() = FondFamilyFragment()
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentFondFamilyBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onDestroy() {
		super.onDestroy()
		_binding = null
	}


}
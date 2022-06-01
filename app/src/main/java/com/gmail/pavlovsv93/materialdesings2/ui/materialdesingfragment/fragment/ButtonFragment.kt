package com.gmail.pavlovsv93.materialdesings2.ui.materialdesingfragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gmail.pavlovsv93.materialdesings2.databinding.FragmentMatrialDesingBtnBinding
import com.gmail.pavlovsv93.materialdesings2.databinding.FragmentMatrialDesingTextBinding

class ButtonFragment: Fragment() {
	private var _binding: FragmentMatrialDesingBtnBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentMatrialDesingBtnBinding.inflate(inflater, container, false)
		return binding.root
	}
}
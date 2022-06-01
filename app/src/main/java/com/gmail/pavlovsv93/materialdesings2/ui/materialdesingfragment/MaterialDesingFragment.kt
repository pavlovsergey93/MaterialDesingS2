package com.gmail.pavlovsv93.materialdesings2.ui.materialdesingfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gmail.pavlovsv93.materialdesings2.R
import com.gmail.pavlovsv93.materialdesings2.databinding.FragmentMaterialDesingBinding
import com.gmail.pavlovsv93.materialdesings2.databinding.FragmentSplashBinding
import com.gmail.pavlovsv93.materialdesings2.ui.materialdesingfragment.fragment.ButtonFragment
import com.gmail.pavlovsv93.materialdesings2.ui.materialdesingfragment.fragment.TextFragment
import com.gmail.pavlovsv93.materialdesings2.ui.materialdesingfragment.viewpager.ViewPagerAdapter
import com.gmail.pavlovsv93.materialdesings2.ui.splashfragment.SplashFragment
import com.google.android.material.tabs.TabLayout
import smartdevelop.ir.eram.showcaseviewlib.GuideView
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType
import smartdevelop.ir.eram.showcaseviewlib.config.Gravity

const val TEXT_KEY = 0
const val BTN_KEY = 1

class MaterialDesingFragment : Fragment() {
	private var _binding: FragmentMaterialDesingBinding? = null
	private val binding get() = _binding!!

	companion object {
		fun newInstance() = MaterialDesingFragment()
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentMaterialDesingBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onDestroy() {
		super.onDestroy()
		_binding = null
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val listFragment = listOf(TextFragment(), ButtonFragment())
		binding.viewPager.adapter = ViewPagerAdapter(requireActivity().supportFragmentManager, listFragment)
		binding.tabLayout.setupWithViewPager(binding.viewPager)
	}
}
package com.gmail.pavlovsv93.materialdesings2.ui.materialdesingfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gmail.pavlovsv93.materialdesings2.R
import com.gmail.pavlovsv93.materialdesings2.databinding.FragmentMaterialDesingBinding
import com.gmail.pavlovsv93.materialdesings2.databinding.FragmentSplashBinding
import com.gmail.pavlovsv93.materialdesings2.ui.splashfragment.SplashFragment
import com.google.android.material.tabs.TabLayout

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
		binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
			override fun onTabSelected(tab: TabLayout.Tab?) {

			}

			override fun onTabUnselected(tab: TabLayout.Tab?) {
				TODO("Not yet implemented")
			}

			override fun onTabReselected(tab: TabLayout.Tab?) {
				TODO("Not yet implemented")
			}

		})
	}

	private fun showFragment(fragment: Fragment) {
		parentFragmentManager.beginTransaction()
			.replace(R.id.tabs_fragment_container, fragment)
			.commit()
	}
}
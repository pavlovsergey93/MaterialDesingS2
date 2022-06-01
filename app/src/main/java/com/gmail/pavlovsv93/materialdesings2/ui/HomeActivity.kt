package com.gmail.pavlovsv93.materialdesings2.ui

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.core.view.marginBottom
import androidx.fragment.app.Fragment
import com.gmail.pavlovsv93.materialdesings2.R
import com.gmail.pavlovsv93.materialdesings2.databinding.ActivityHomeBinding
import com.gmail.pavlovsv93.materialdesings2.ui.fondfamilyfragment.FondFamilyFragment
import com.gmail.pavlovsv93.materialdesings2.ui.materialdesingfragment.MaterialDesingFragment
import com.gmail.pavlovsv93.materialdesings2.ui.recyclerviewfragment.RecyclerViewFragment
import com.gmail.pavlovsv93.materialdesings2.ui.splashfragment.SplashFragment

class HomeActivity : AppCompatActivity() {
	private lateinit var binding: ActivityHomeBinding
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setTheme(R.style.Theme_MaterialDesingS2)
		binding = ActivityHomeBinding.inflate(layoutInflater)
		setContentView(binding.root)
		if (savedInstanceState == null) {
			showFragment(SplashFragment.newInstance(), false)
			Handler(mainLooper).postDelayed({
				showFragment(RecyclerViewFragment.newInstance(), false)
			}, 3000L)
			Handler(mainLooper).postDelayed({
				binding.homeBottomNavigationView.visibility = View.VISIBLE
			}, 3100L)
		}
		binding.homeBottomNavigationView.setOnItemSelectedListener {
			when (it.itemId) {
				R.id.menu_recycler_view -> {
					showFragment(RecyclerViewFragment.newInstance(), false)
					true
				}
				R.id.menu_material_desing -> {
					showFragment(MaterialDesingFragment.newInstance(), false)
					true
				}
				R.id.menu_fond_family -> {
					showFragment(FondFamilyFragment.newInstance(), false)
					true
				}
				else -> false
			}
		}
	}

	private fun showFragment(fragment: Fragment, addToBackStack: Boolean) {
		val sfm = supportFragmentManager.beginTransaction()
			.replace(R.id.home_fragment_container, fragment)
		if (addToBackStack) {
			sfm.addToBackStack(null)
		}
		sfm.commit()
	}
}
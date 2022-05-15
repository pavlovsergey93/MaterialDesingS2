package com.gmail.pavlovsv93.materialdesings2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gmail.pavlovsv93.materialdesings2.R
import com.gmail.pavlovsv93.materialdesings2.ui.recyclerviewfragment.RecyclerViewFragment

class HomeActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_home)
		if(savedInstanceState == null){
			supportFragmentManager.beginTransaction()
				.replace(R.id.home_fragment_container, RecyclerViewFragment.newInstance())
				.commit()
		}
	}
}
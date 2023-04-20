package com.gmail.pavlovsv93.materialdesings2.ui.materialdesingfragment.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.gmail.pavlovsv93.materialdesings2.ui.materialdesingfragment.BTN_KEY
import com.gmail.pavlovsv93.materialdesings2.ui.materialdesingfragment.TEXT_KEY

class ViewPagerAdapter(
    fm: FragmentManager,
    fragmentList: List<Fragment>
) :
    FragmentStatePagerAdapter(fm) {

    private val fragmentListAdapter = fragmentList

    override fun getCount(): Int = fragmentListAdapter.size

    override fun getItem(position: Int): Fragment = fragmentListAdapter[position]

	override fun getPageTitle(position: Int): CharSequence? {
		return when(position){
			TEXT_KEY -> "ТЕКСТА"
			BTN_KEY -> "КНОПКИ"
			else -> ""
		}
	}
}
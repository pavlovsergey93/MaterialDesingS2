package com.gmail.pavlovsv93.materialdesings2.ui.materialdesingfragment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gmail.pavlovsv93.materialdesings2.databinding.FragmentMatrialDesingTextBinding
import smartdevelop.ir.eram.showcaseviewlib.GuideView
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType
import smartdevelop.ir.eram.showcaseviewlib.config.Gravity

class TextFragment : Fragment() {
	private var _binding: FragmentMatrialDesingTextBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentMatrialDesingTextBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		if(getView() != null && requireView().isShown)	{showTutorial()}
	}

	private fun showTutorial() {
		GuideView.Builder(requireContext())
			.setTitle("Навигация по уроку 8")
			.setContentText("Древний подход к формированию внимания")
			.setGravity(Gravity.auto)
			.setTargetView(binding.llContainerTextMock)
			.setDismissType(DismissType.anywhere)
			.setGuideListener {
				GuideView.Builder(requireContext())
					.setTitle("Навигация по уроку 8")
					.setContentText("Новый подход к формированию внимания")
					.setGravity(Gravity.auto)
					.setTargetView(binding.llContainerText)
					.setDismissType(DismissType.anywhere)
					.build()
					.show();
			}
			.build()
			.show();
	}
}
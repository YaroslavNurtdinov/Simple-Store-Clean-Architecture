package com.nurtdinov.simpleshop.presenter.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nurtdinov.simpleshop.R
import com.nurtdinov.simpleshop.databinding.FragmentFilterBottomSheetBinding

class FilterBottomSheetFragment : BottomSheetDialogFragment() {
    private var _binding : FragmentFilterBottomSheetBinding?=null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentFilterBottomSheetBinding.inflate(layoutInflater,container,false)

        binding.doneImageButton.setOnClickListener {
            findNavController().navigate(R.id.action_filterBottomSheetFragment_to_homeFragment)
        }
        binding.closeImageButton.setOnClickListener {
            findNavController().popBackStack()
        }


        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}

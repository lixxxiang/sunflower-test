package com.android.cgwx.sunflower_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.android.cgwx.sunflower_test.databinding.FragmentGardenBinding
import com.android.cgwx.sunflower_test.utilities.InjectorUtils
import com.android.cgwx.sunflower_test.viewmodels.GardenPlantingListViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GardenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GardenFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentGardenBinding
    private val viewModel: GardenPlantingListViewModel by viewModels {
        InjectorUtils.provideGardenPlantingListViewModelFactory(requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGardenBinding.inflate(inflater, container, false)
        viewModel
        subscribeUI(binding)
        return binding.root
    }

    private fun subscribeUI(binding: FragmentGardenBinding){
        viewModel.plantAndGardenPlantings.observe(viewLifecycleOwner){result ->
            binding.hp = (!result.isNullOrEmpty()).toString()
        }
    }
}
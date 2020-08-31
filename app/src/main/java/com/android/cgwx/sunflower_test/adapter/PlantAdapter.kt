package com.android.cgwx.sunflower_test.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.cgwx.sunflower_test.HomeViewPagerFragmentDirections
import com.android.cgwx.sunflower_test.data.Plant
import com.android.cgwx.sunflower_test.databinding.ListItemPlantBinding

class PlantAdapter : ListAdapter<Plant, RecyclerView.ViewHolder>(PlantDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlantViewHolder(ListItemPlantBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val plant = getItem(position)
        (holder as PlantViewHolder).bind(plant)
    }

    class PlantViewHolder(
        private val binding: ListItemPlantBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { it ->
                binding.plant.let { it2 ->
                    navigateToPlant(it2!!, it)
                }
            }
        }

        private fun navigateToPlant(plant: Plant, view: View){
            view.findNavController().navigate(HomeViewPagerFragmentDirections.actionViewPagerFragmentToPlantDetailFragment(plant.plantId))
        }

        fun bind(item: Plant){
            binding.apply {
                plant = item
                Log.d("TAG", (plant as Plant).imageUrl)
                executePendingBindings()
            }
        }
    }
}

private class PlantDiffCallback : DiffUtil.ItemCallback<Plant>() {

    override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem.plantId == newItem.plantId
    }

    override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem == newItem
    }
}
package com.android.cgwx.sunflower_test.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap

import com.android.cgwx.sunflower_test.data.Plant
import com.android.cgwx.sunflower_test.data.PlantRepository

class PlantListViewModel(
    plantRepository: PlantRepository,
    val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val plants: LiveData<List<Plant>> = getSavedGrowZoneNumber().switchMap {

    }

    private fun getSavedGrowZoneNumber(): MutableLiveData<Int> {
        return savedStateHandle.getLiveData(GROW_ZONE_SAVED_STATE_KEY, NO_GROW_ZONE)
    }

    companion object {
        private const val NO_GROW_ZONE = -1
        private const val GROW_ZONE_SAVED_STATE_KEY = "GROW_ZONE_SAVED_STATE_KEY"
    }
}
package com.android.cgwx.sunflower_test.utilities

import android.content.Context
import androidx.fragment.app.Fragment
import com.android.cgwx.sunflower_test.data.AppDatabase
import com.android.cgwx.sunflower_test.data.GardenPlantingRepository
import com.android.cgwx.sunflower_test.data.PlantRepository
import com.android.cgwx.sunflower_test.viewmodels.GardenPlantingListViewModelFactory
import com.android.cgwx.sunflower_test.viewmodels.PlantListViewModelFactory

object InjectorUtils{

    fun getPlantRepository(context: Context):PlantRepository{
        return PlantRepository.getInstance(AppDatabase.getInstance(context).plantDao())
    }

    fun getGardenPlantingRepository(context: Context):GardenPlantingRepository{
        val tempContext = context.applicationContext
        val appDatabase = AppDatabase.getInstance(tempContext)
        val gardenPlantingDao = appDatabase.gardenPlantingDao()
        var gardenPlantingRepository = GardenPlantingRepository.getInstance(gardenPlantingDao)
        return GardenPlantingRepository.getInstance(AppDatabase.getInstance(context.applicationContext).gardenPlantingDao())
    }

    fun provideGardenPlantingListViewModelFactory(context: Context): GardenPlantingListViewModelFactory{
        var gardenPlantingListViewModelFactory = GardenPlantingListViewModelFactory(getGardenPlantingRepository(context))
        return GardenPlantingListViewModelFactory(getGardenPlantingRepository(context))
    }

    fun providePlantListViewModelFactory(fragment: Fragment): PlantListViewModelFactory{
        return PlantListViewModelFactory(getPlantRepository(fragment.requireContext()),fragment)
    }
}

//private fun getPlantRepository(context: Context): PlantRepository {
//        return PlantRepository.getInstance(
//                AppDatabase.getInstance(context.applicationContext).plantDao())
//    }
//
//    private fun getGardenPlantingRepository(context: Context): GardenPlantingRepository {
//        return GardenPlantingRepository.getInstance(
//                AppDatabase.getInstance(context.applicationContext).gardenPlantingDao())
//    }
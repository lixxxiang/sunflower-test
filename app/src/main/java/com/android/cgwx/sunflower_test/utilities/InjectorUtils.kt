package com.android.cgwx.sunflower_test.utilities

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Transformations
import com.android.cgwx.sunflower_test.data.AppDatabase
import com.android.cgwx.sunflower_test.data.GardenPlantingRepository
import com.android.cgwx.sunflower_test.data.PlantRepository
import com.android.cgwx.sunflower_test.viewmodels.GardenPlantingListViewModelFactory
import com.android.cgwx.sunflower_test.viewmodels.PlantDetailViewModelFactory
import com.android.cgwx.sunflower_test.viewmodels.PlantListViewModelFactory


object InjectorUtils{

    fun getPlantRepository(context: Context):PlantRepository{
        Log.d("TAG", "getPlantRepository")
        val instance = AppDatabase.getInstance(context).plantDao().getPlants().value
//        Log.d("TAG",instance.getPlants())
//            instance.getPlants().value
        return PlantRepository.getInstance(AppDatabase.getInstance(context).plantDao())
    }

    fun getGardenPlantingRepository(context: Context):GardenPlantingRepository{
        Log.d("TAG", "getGardenPlantingRepository")

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

    fun providePlantDetailViewModelFactory(
        context: Context,
        plantId: String
    ):PlantDetailViewModelFactory{
        return PlantDetailViewModelFactory(getPlantRepository(context), getGardenPlantingRepository(context), plantId)
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
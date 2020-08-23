package com.android.cgwx.sunflower_test.utilities

import android.content.Context
import com.android.cgwx.sunflower_test.data.AppDatabase
import com.android.cgwx.sunflower_test.data.GardenPlantingRepository
import com.android.cgwx.sunflower_test.data.PlantRepository
import com.android.cgwx.sunflower_test.viewmodels.GardenPlantingListViewModelFactory

object InjectorUtils{

    fun getPlantRepository(context: Context):PlantRepository{
        return PlantRepository.getInstance(AppDatabase.getInstance(context).plantDao())
    }

    fun getGardenPlantingRepository(context: Context):GardenPlantingRepository{
        return GardenPlantingRepository.getInstance(AppDatabase.getInstance(context.applicationContext).gardenPlantingDao())
    }

    fun provideGardenPlantingListViewModelFactory(context: Context): GardenPlantingListViewModelFactory{
        return GardenPlantingListViewModelFactory(getGardenPlantingRepository(context))
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
package com.android.cgwx.sunflower_test.data

class GardenPlantingRepository private constructor(
    private val gardenPlantingDao: GardenPlantingDao
){
    fun getPlantedGardens() = gardenPlantingDao.getPlantenGardens()

    companion object {
        private var instance: GardenPlantingRepository?= null
        fun getInstance(gardenPlantingDao: GardenPlantingDao) =
            instance ?: synchronized(this) {
                instance ?: GardenPlantingRepository(gardenPlantingDao).also { instance = it }
            }
    }
}

//    companion object {
//
//        // For Singleton instantiation
//        @Volatile private var instance: GardenPlantingRepository? = null
//
//        fun getInstance(gardenPlantingDao: GardenPlantingDao) =
//                instance ?: synchronized(this) {
//                    instance ?: GardenPlantingRepository(gardenPlantingDao).also { instance = it }
//                }
//    }
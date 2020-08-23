package com.android.cgwx.sunflower_test.data

class PlantRepository private constructor(private val plantDao: PlantDao) {
    companion object {
        private var instance: PlantRepository? = null


        fun getInstance(plantDao: PlantDao) = instance ?: synchronized(this) {
            instance ?: PlantRepository(plantDao).also { instance = it }
        }
    }
}

//companion object {
//
//        // For Singleton instantiation
//        @Volatile private var instance: PlantRepository? = null
//
//        fun getInstance(plantDao: PlantDao) =
//                instance ?: synchronized(this) {
//                    instance ?: PlantRepository(plantDao).also { instance = it }
//                }
//    }
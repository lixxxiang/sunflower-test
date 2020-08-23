package com.android.cgwx.sunflower_test.workers

import android.content.Context
import android.util.JsonReader
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.android.cgwx.sunflower_test.data.AppDatabase
import com.android.cgwx.sunflower_test.data.Plant
import com.android.cgwx.sunflower_test.utilities.PLANT_DATA_FILENAME
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import kotlinx.coroutines.coroutineScope

class SeedDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = coroutineScope {
        applicationContext.assets.open(PLANT_DATA_FILENAME).use { inputStream ->
            JsonReader(inputStream.reader()).use { jsonReader ->
                val plantType = object : TypeToken<List<Plant>>() {}.type
                val plantList: List<Plant> = Gson().fromJson(jsonReader, plantType)
                val database = AppDatabase.getInstance(applicationContext)
                database.plantDao().insertAll(plantList)
                Result.success()
            }
        }
    }

}

//private fun Gson.fromJson(jsonReader: JsonReader, plantType: Type?): List<Plant> {
//
//}


//override suspend fun doWork(): Result = coroutineScope {
//        try {
//            applicationContext.assets.open(PLANT_DATA_FILENAME).use { inputStream ->
//                JsonReader(inputStream.reader()).use { jsonReader ->
//                    val plantType = object : TypeToken<List<Plant>>() {}.type
//                    val plantList: List<Plant> = Gson().fromJson(jsonReader, plantType)
//
//                    val database = AppDatabase.getInstance(applicationContext)
//                    database.plantDao().insertAll(plantList)
//
//                    Result.success()
//                }
//            }
//        } catch (ex: Exception) {
//            Log.e(TAG, "Error seeding database", ex)
//            Result.failure()
//        }
//    }
//
//    companion object {
//        private const val TAG = "SeedDatabaseWorker"
//    }
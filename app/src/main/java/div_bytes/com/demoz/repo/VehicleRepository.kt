package div_bytes.com.demoz.repo

import android.app.Application
import android.arch.lifecycle.LiveData
import div_bytes.com.demoz.repo.database.VehicleRoomDatabase
import div_bytes.com.demoz.repo.database.dao.VehicleDao
import div_bytes.com.demoz.ui.main.Vehicle
import android.os.AsyncTask



class VehicleRepository {
    lateinit var vehicleDao : VehicleDao
    lateinit var vehicles : LiveData<List<Vehicle>>
    constructor(application: Application){
        val db = VehicleRoomDatabase.getDatabase(application)
        vehicleDao = db!!.vehicleDao()
        vehicles = vehicleDao.getAllVehicles()
    }


    fun getAllVehicles(): LiveData<List<Vehicle>> {
        return vehicles
    }


    fun insert(vehicle: Vehicle) {
        insertAsyncTask(vehicleDao).execute(vehicle)
    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: VehicleDao) : AsyncTask<Vehicle, Void, Unit>() {

        override fun doInBackground(vararg params: Vehicle) {
            mAsyncTaskDao.insert(params[0])
        }
    }
}
package div_bytes.com.demoz.ui.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.content.res.AssetManager
import div_bytes.com.demoz.R
import div_bytes.com.demoz.repo.VehicleRepository
import java.io.FileInputStream

class MainViewModel(application : Application) : AndroidViewModel(application) {
    private lateinit var vehicleRepo : VehicleRepository
    lateinit var vehiclesLiveData : LiveData<List<Vehicle>>
    init {
        vehicleRepo = VehicleRepository(application);
        vehiclesLiveData = vehicleRepo.getAllVehicles();
    }

    fun insertVehicle(vehicle : Vehicle) { vehicleRepo.insert(vehicle)}
}

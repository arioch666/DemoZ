package div_bytes.com.demoz.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import div_bytes.com.demoz.ui.main.Vehicle

/**
 *@author div@hello.com (div-hello)
 */
@Dao
interface VehicleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vahicle: Vehicle)

    @Query("Select * from vehicle")
    fun getAllVehicles(): LiveData<List<Vehicle>>



}
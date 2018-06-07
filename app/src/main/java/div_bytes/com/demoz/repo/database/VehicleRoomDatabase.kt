package div_bytes.com.demoz.repo.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import div_bytes.com.demoz.repo.database.dao.VehicleDao
import div_bytes.com.demoz.ui.main.Vehicle
import android.arch.persistence.room.Room



@Database(entities = [Vehicle::class], version = 1)
abstract class VehicleRoomDatabase ():RoomDatabase(){
    abstract fun vehicleDao(): VehicleDao
companion object {
    private var INSTANCE: VehicleRoomDatabase? = null

    fun getDatabase(context: Context): VehicleRoomDatabase? {
        if (INSTANCE == null) {
            synchronized(VehicleRoomDatabase::class.java) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            VehicleRoomDatabase::class.java!!, "vehicle_database")
                            .build()
                }
            }
        }
        return INSTANCE
    }
}


}
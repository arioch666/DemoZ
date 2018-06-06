package div_bytes.com.demoz.datastore

import div_bytes.com.demoz.inputparser.parseVehiclesAssetFile
import div_bytes.com.demoz.ui.main.VehiclesJSON

/**
 *@author div@hello.com (div-hello)
 */

class DataStore {

    companion object {
        private lateinit var vehiclesJSON: VehiclesJSON
    }

    /**
     * Update the VehicleJson Object in our App.
     */
    fun updateVehiclesJson(): VehiclesJSON {

        vehiclesJSON = parseVehiclesAssetFile()
        return vehiclesJSON

    }

}
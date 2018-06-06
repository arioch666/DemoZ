package div_bytes.com.demoz.inputparser

import android.content.res.Resources
import com.google.gson.Gson
import div_bytes.com.demoz.ui.main.VehiclesJSON

/**
 *@author div@hello.com (div-hello)
 */

/**
 * used to parse the json asset and return the VehicleJsonObject
 */
fun parseVehiclesAssetFile() : VehiclesJSON {
    val jsonInputStream = Resources.getSystem().assets?.open("fleet_status.json")

    val gson = Gson()
//
    val inputStreamReader = jsonInputStream?.reader(Charsets.UTF_8)

    return gson.fromJson(inputStreamReader?.readText(), VehiclesJSON::class.java)

}
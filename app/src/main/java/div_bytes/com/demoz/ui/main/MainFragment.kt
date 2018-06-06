package div_bytes.com.demoz.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.gson.Gson
import div_bytes.com.demoz.R

data class VehiclesJSON(val vehicles: List<Vehicles>)

data class Vehicles(val id: String, val name: String)

class MainFragment : Fragment() {


    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val jsonInputStream = activity?.assets?.open("fleet_status.json")

        val gson = Gson()
//
        val inputStreamReader = jsonInputStream?.reader(Charsets.UTF_8)

        val json = gson.fromJson(inputStreamReader?.readText(), VehiclesJSON::class.java)
        Toast.makeText(activity, json?.toString(), Toast.LENGTH_SHORT).show()

//        Toast.makeText(activity, "HI", Toast.LENGTH_LONG).show()
//        Log.d("1111111111", json?.toString())

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




    }



}

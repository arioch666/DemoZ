package div_bytes.com.demoz.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.content.Context
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import div_bytes.com.demoz.R
import kotlinx.android.synthetic.main.main_fragment.*
import org.jetbrains.annotations.NotNull


data class VehiclesJSON(val vehicles: List<Vehicle>)

@Entity(tableName = "vehicle")
data class Vehicle(@PrimaryKey @NonNull val id: String,
                   @NotNull val name: String)

class MainFragment : Fragment() {

    lateinit var viewModel: MainViewModel
    lateinit var adapter: VehicleListAdapter

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        viewModel = ViewModelProviders.of(activity as FragmentActivity).get(MainViewModel::class.java)

        vehicleListAdapter()

        viewModel.vehiclesLiveData.observe(this, Observer<List<Vehicle>> { adapter.setData(it!!) })

        vehiclesListRecyclerView.setAdapter(adapter)
        vehiclesListRecyclerView.setLayoutManager(LinearLayoutManager(activity))
    }

    private fun vehicleListAdapter() {
        adapter = VehicleListAdapter(activity as Context)
    }
}

class VehicleListAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var dataList:List<Vehicle> = ArrayList()

    private lateinit var inflater: LayoutInflater

    constructor(context: Context):this() {
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return object: RecyclerView.ViewHolder(inflater.inflate(R.layout.vehicle_list_item, parent, false)) {

            var nameTextView: TextView = itemView.findViewById(R.id.vehicleNameTextView)

            fun bindData(vehicle: Vehicle) {
                nameTextView.text = vehicle.name
            }

        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    fun setData(dataList: List<Vehicle>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }
}

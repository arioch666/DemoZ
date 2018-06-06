package div_bytes.com.demoz.ui.main

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import div_bytes.com.demoz.R
import org.jetbrains.annotations.NotNull

data class VehiclesJSON(val vehicles: List<Vehicle>)

@Entity(tableName = "vehicle")
data class Vehicle(@PrimaryKey @NonNull val id: String,
                   @NotNull val name: String)

class MainFragment : Fragment() {


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




    }



}

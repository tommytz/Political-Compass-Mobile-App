package com.example.politicalcompass

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.richpath.RichPath
import com.richpath.RichPathView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ElectorateMapFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null


    val pathArray = mutableListOf<RichPath>()
    var currentPath: RichPath? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.electorate_map_one, container, false);
        val richPathView: RichPathView =
            view.findViewById(R.id.nz_map) //findViewById<RichPathView>(R.id.north_island_map)
        richPathView.setOnPathClickListener { richPath ->
            pathArray.add(richPath)
            currentPath = richPath
            richPath.strokeColor = Color.RED
            for (path in pathArray) {
                if (path == richPath) {
                    continue
                } else {
                    path.strokeColor = Color.WHITE
                }
            }

        }


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GreenPartyInfo.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ElectorateMapFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

}
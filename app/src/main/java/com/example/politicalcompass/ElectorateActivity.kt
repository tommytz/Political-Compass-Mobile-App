package com.example.politicalcompass

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.richpath.RichPath
import com.richpath.RichPathView

class ElectorateActivity : AppCompatActivity() {

    val pathArray = mutableListOf<RichPath>()
    var currentPath: RichPath? = null
    var currentPathNorthIsland: RichPath? = null
    var currentPathWellington: RichPath? = null


//    var currentFragment : Fragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.electorate_map_base)
        val fragmentManager = supportFragmentManager
//        val fragOne : Fragment = ElectorateMapFragment()
//        val fragTwo : Fragment = ElectorateMapNorthIslandFragment()
//        val fragmentList = listOf(ElectorateMapFragment(), ElectorateMapNorthIslandFragment())
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.map_fragment_container_view, ElectorateMapFragment())
        fragmentTransaction.commit()


//
//        val fragmentContainer : FragmentContainerView = findViewById(R.id.map_fragments)
//        fragmentManager.findFragmentById(fragmentContainer.id)
//
        val richPathView: RichPathView = findViewById(R.id.nz_map)
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


        val richPathViewHNorthIsland: RichPathView =
            findViewById<RichPathView>(R.id.north_island_map)
        richPathViewHNorthIsland.setOnPathClickListener { richPath ->
            pathArray.add(richPath)
            currentPathNorthIsland = richPath
            richPath.strokeColor = Color.RED
//            if (richPath.name == "north_island") {
//                richPath.strokeColor = Color.RED
//            } else if (richPath.name == "south_island") {
//                richPath.strokeColor = Color.BLUE
//            }
            for (path in pathArray) {
                if (path == richPath) {
                    continue
                } else {
                    path.strokeColor = Color.WHITE
                }
            }
        }

        val nextButton: Button = findViewById(R.id.next_button)
        nextButton.setOnClickListener {
//            val fragmentContainer : FragmentContainerView = findViewById(R.id.map_fragments)
//            currentFragment = fragmentManager.findFragmentById(fragmentContainer.id)
            if (currentPathWellington != null) {
//                fragmentTransaction.replace(/*list some mps*/)
//                fragmentTransaction.commit()
                return@setOnClickListener
            } else if (currentPathNorthIsland != null) {
                if (currentPathNorthIsland!!.name == "wellington") {
//                  fragmentTransaction.replace(R.id.map_fragments,ElectorateMapWellingtonFragment())
//                  fragmentTransaction.commit()
                    return@setOnClickListener
                } else {
                    Toast.makeText(this, "That ain't it", Toast.LENGTH_SHORT).show()
                }
            } else if (currentPath != null) {
                if (currentPath!!.name.equals("north_island")) {
                    fragmentTransaction.replace(
                        R.id.map_fragment_container_view,
                        ElectorateMapNorthIslandFragment()
                    )
                    fragmentTransaction.commit()
                } else {
                    Toast.makeText(this, "That ain't it", Toast.LENGTH_SHORT).show()
                }
            }

        }


    }

}
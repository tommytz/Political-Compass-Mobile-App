package com.example.politicalcompass

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LabourPartyInfo.newInstance] factory method to
 * create an instance of this fragment.
 */
class GreenPolicyInfo : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var buttonPressed = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        buttonPressed = activity?.intent?.extras?.getString("message").toString()
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_green_party_policy_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        var policyText : TextView = requireActivity().findViewById(R.id.greenPolicyText)
//        if (buttonPressed == "environment") {
//            policyText.setText(R.string.greenEnvironment)
//        }
//        else if (buttonPressed == "housing") {
//            policyText.setText(R.string.greenHousing)
//        }
//        else if (buttonPressed == "education") {
//            policyText.setText(R.string.greenEducation)
//        }
//        else if (buttonPressed == "economy") {
//            policyText.setText(R.string.greenEconomy)
//        }
//        else if (buttonPressed == "health") {
//            policyText.setText(R.string.greenHealth)
//        }
//        else if (buttonPressed == "infrastructure") {
//            policyText.setText(R.string.greenInfrastructure)
//        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LabourPartyInfo.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LabourPartyInfo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }}
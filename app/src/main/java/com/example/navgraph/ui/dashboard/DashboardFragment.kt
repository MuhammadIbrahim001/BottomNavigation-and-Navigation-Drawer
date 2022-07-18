package com.example.navgraph.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.navgraph.R
import com.example.navgraph.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v("LifeCycle","Dash Fragment onViewCreated")
//        _binding?.textDashboard?.setOnClickListener{
//            findNavController().navigate(R.id.blankFragment)
//        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        Log.v("LifeCycle","DashboardFragment onDestroyView")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("LifeCycle","DashboardFragment Destroy")
    }
}
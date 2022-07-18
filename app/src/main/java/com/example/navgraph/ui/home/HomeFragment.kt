package com.example.navgraph.ui.home

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
import com.example.navgraph.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v("LifeCycle","Home Fragment onViewCreated")
//        _binding?.textHome?.setOnClickListener{
//            findNavController().navigate(R.id.blankFragment)
//        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        Log.v("LifeCycle","Home Fragment onDestroyView")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("LifeCycle","Home Fragment Destroy")
    }
}
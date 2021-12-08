package com.example.testingfirebasengallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.testingfirebasengallery.databinding.FragmentUploadorDownloadBinding

class UploadorDownload : Fragment() {

    private var _binding: FragmentUploadorDownloadBinding ?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentUploadorDownloadBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.Upload.setOnClickListener{
            findNavController().navigate(R.id.action_uploadorDownload_to_upload)
        }
        binding.Download.setOnClickListener{
            findNavController().navigate(R.id.action_uploadorDownload_to_download)
        }
        binding.allimages.setOnClickListener {
            findNavController().navigate(R.id.action_uploadorDownload_to_allimages)
        }
        return view
    }

}
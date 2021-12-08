package com.example.testingfirebasengallery

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.SyncStateContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import com.example.testingfirebasengallery.databinding.FragmentUploadBinding
import com.google.firebase.storage.FirebaseStorage
import java.net.URI


class Upload : Fragment() {
    private val getResult =
        registerForActivityResult(
            StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                imageuri = it.data?.data!!
                binding.uploadimage.setImageURI(imageuri)
            }
        }
    lateinit var imageuri : Uri
    private var _binding : FragmentUploadBinding ?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentUploadBinding.inflate(inflater, container, false)
        binding.selectimage.setOnClickListener {


            selectimage()
        }
        binding.uploadimagebtn.setOnClickListener {
            uploadimage()
        }
        return binding.root
    }

    private fun uploadimage() {

        val imagename = binding.entername.text.toString()
        if(binding.entername == null){
            Toast.makeText(activity, "Enter Name", Toast.LENGTH_SHORT).show()
        }
        val storageReference = FirebaseStorage.getInstance().getReference("images/$imagename.jpg")
        storageReference.putFile(imageuri).addOnSuccessListener {
            binding.uploadimage.setImageURI(null)
            Toast.makeText(activity, "Success", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(activity, "FAiled", Toast.LENGTH_SHORT).show()
        }

    }

    private fun selectimage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        getResult.launch(intent)
        }
    }



package com.example.testingfirebasengallery

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.testingfirebasengallery.databinding.FragmentDownloadBinding
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class Download : Fragment() {
    private var _binding : FragmentDownloadBinding ?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentDownloadBinding.inflate(inflater, container, false)

        binding.getimage.setOnClickListener{

            val imagename = binding.downimagename.text.toString()
            val storageref = FirebaseStorage.getInstance().reference.child("images/$imagename.jpg")
            val localfile = File.createTempFile("tempimage", "jpg")
            storageref.getFile(localfile).addOnSuccessListener {

                val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
                binding.downimage.setImageBitmap(bitmap)
            }.addOnFailureListener{
                Toast.makeText(activity, "Failed", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

}
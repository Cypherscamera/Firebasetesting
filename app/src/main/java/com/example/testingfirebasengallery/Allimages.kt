package com.example.testingfirebasengallery

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ListResult
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.fragment_allimages.*

class Allimages : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_allimages, container, false)

        val storage = FirebaseStorage.getInstance()
        val storageref = storage.reference.child("images")
        val imagelist: ArrayList<Imagesdata> = ArrayList()

        val listAllTasks : Task<ListResult> = storageref.listAll()
        listAllTasks.addOnCompleteListener{result ->
            val items: List<StorageReference> = result.result!!.items
            items.forEachIndexed{index, item ->
                item.downloadUrl.addOnSuccessListener {
                    imagelist.add(Imagesdata(it.toString()))
                    Log.d("nope", "nope")
                }.addOnCompleteListener{

                    recycle.adapter = activity?.let { it1 -> Allimagesadapter(imagelist, it1) }
                    recycle.layoutManager = LinearLayoutManager(activity)

                }
            }
        }

        return view
    }

}
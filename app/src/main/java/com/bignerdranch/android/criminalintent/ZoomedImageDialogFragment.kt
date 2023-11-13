package com.bignerdranch.android.criminalintent

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import java.io.Serializable

class ZoomedImageDialogFragment:DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.zoomed_image_layout,container,false)
        val imageView = view.findViewById<ImageView>(R.id.zoomed_image)
        val photoName = arguments?.getSerializable("PHOTO_NAME") as String
        var directoryPath = requireContext().filesDir.path+"/"+photoName
        var bitmapWork = BitmapFactory.decodeFile(directoryPath)
        imageView.setImageBitmap(bitmapWork)
        return view

    }
    companion object{
        fun newInstance(photoName:String):ZoomedImageDialogFragment{

            val fragment = ZoomedImageDialogFragment()
            val args = Bundle()
            args.putSerializable("PHOTO_NAME",photoName)
            fragment.arguments = args
            return fragment
        }
    }
}
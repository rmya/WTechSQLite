package com.example.wtechsqlite.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.wtechsqlite.R
import com.example.wtechsqlite.databinding.FragmentTumOgrencilerBinding
import com.example.wtechsqlite.db.Veritabani
import com.example.wtechsqlite.models.OgrenciModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class TumOgrencilerFragment : Fragment() {

    private lateinit var binding: FragmentTumOgrencilerBinding
    private lateinit var veritabani: Veritabani

    private lateinit var ogrenciList : ArrayList<OgrenciModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        veritabani = Veritabani(requireContext())
        ogrenciList = ArrayList()
        veritabani.tumOgrencilerAl(ogrenciList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_tum_ogrenciler, container, false)
        binding = FragmentTumOgrencilerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (ogrenciList.isEmpty()){
            Snackbar.make(view,"Kayıtlı öğrenci bulunamadı !",1000).show()
        }    else {

            ogrenciYazdir(0, binding.ogrenci1AdSoyad, binding.ogrenci1Mail, binding.ogrenci1OgrNo, binding.ogrenci1Gorsel)
            ogrenciYazdir(1, binding.ogrenci2AdSoyad, binding.ogrenci2Mail, binding.ogrenci2OgrNo, binding.ogrenci2Gorsel)
            ogrenciYazdir(2, binding.ogrenci3AdSoyad, binding.ogrenci3Mail, binding.ogrenci3OgrNo, binding.ogrenci3Gorsel)
            ogrenciYazdir(2, binding.ogrenci4AdSoyad, binding.ogrenci4Mail, binding.ogrenci4OgrNo, binding.ogrenci4Gorsel)

        }

        binding.ogrenci1SilButton.ogrenciSil(0)
        binding.ogrenci2SilButton.ogrenciSil(1)
        binding.ogrenci3SilButton.ogrenciSil(2)
        binding.ogrenci4SilButton.ogrenciSil(3)

    }

    fun ogrenciYazdir(i: Int, adSoyatText: TextView, mailText: TextView, ogrNoText: TextView, imageView: ImageView) {
        Picasso.get().load(ogrenciList[i].gorsel).into(imageView)
        adSoyatText.text = ogrenciList[i].adSoyad
        mailText.text = ogrenciList[i].mail
        ogrNoText.text = ogrenciList[i].ogrNo
    }

    fun ImageView.ogrenciSil(id: Int){

        setOnClickListener {
            veritabani.ogrenciSil(id)
        }
    }

}
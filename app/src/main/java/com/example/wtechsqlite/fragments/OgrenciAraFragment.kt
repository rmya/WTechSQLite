package com.example.wtechsqlite.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wtechsqlite.R
import com.example.wtechsqlite.databinding.FragmentOgrenciAraBinding
import com.example.wtechsqlite.db.Veritabani
import com.example.wtechsqlite.models.OgrenciModel
import com.squareup.picasso.Picasso

class OgrenciAraFragment : Fragment() {

    private lateinit var binding : FragmentOgrenciAraBinding
    private lateinit var veritabani: Veritabani

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        veritabani = Veritabani(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_ogrenci_ara, container, false)
        binding = FragmentOgrenciAraBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.araButton.setOnClickListener {

            val ogrenci : OgrenciModel = veritabani.ogrenciAra(binding.adSoyadEditText.text.toString())

            Picasso.get().load(ogrenci.gorsel).into(binding.gorsel)
            binding.adSoyadText.text = ogrenci.adSoyad
            binding.mailText.text = ogrenci.mail
            binding.ogrNoText.text = ogrenci.ogrNo

        }

        binding.silButton.setOnClickListener {
            veritabani.ogrenciSil(2)
        }

    }
}
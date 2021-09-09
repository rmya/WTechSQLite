package com.example.wtechsqlite.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wtechsqlite.R
import com.example.wtechsqlite.databinding.FragmentOgrenciEkleBinding
import com.example.wtechsqlite.db.Veritabani

class OgrenciEkleFragment : Fragment() {

    private lateinit var binding: FragmentOgrenciEkleBinding
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
        //return inflater.inflate(R.layout.fragment_ogrenci_ekle, container, false)
        binding = FragmentOgrenciEkleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.kayitliVeriYukleButton.setOnClickListener {

            val gorselList = arrayListOf(
                "https://icon-library.com/images/default-profile-icon/default-profile-icon-3.jpg",
                "https://icon-library.com/images/default-profile-icon/default-profile-icon-3.jpg",
                "https://media.istockphoto.com/vectors/default-avatar-profile-icon-grey-photo-placeholder-hand-drawn-modern-vector-id1273297903?b=1&k=20&m=1273297903&s=612x612&w=0&h=UVD_WNKNyJlBHwJ6y229omlQyec7tdiEgyU7-UwSUKY=",
                "https://media.istockphoto.com/vectors/default-avatar-profile-icon-grey-photo-placeholder-hand-drawn-modern-vector-id1273297903?b=1&k=20&m=1273297903&s=612x612&w=0&h=UVD_WNKNyJlBHwJ6y229omlQyec7tdiEgyU7-UwSUKY="
            )

            val adSoyadList =
                arrayListOf("Caner Ture", "Mehmet Cavus", "Sibel Ozturk", "Arzum Parlak")
            val mailList = arrayListOf(
                "cnrture@gmail.com",
                "mehmet.cavus@gmail.com",
                "sibel.ozturk@gmail.com",
                "arzum.parlak@gmail.com"
            )
            val ogrNoList = arrayListOf("1302150035", "1302150036", "1302150037", "1302150038")

            for (i in 0 until gorselList.size) {
                veritabani.ogrenciEkle(gorselList[i], adSoyadList[i], mailList[i], ogrNoList[i])
            }

        }

        binding.kaydetButton.setOnClickListener {

            val gorsel = binding.gorselEditText.text.toString()
            val adSoyad = binding.adSoyadEditText.text.toString()
            val mail = binding.mailEditText.text.toString()
            val ogrNo = binding.ogrNoEditText.text.toString()

            veritabani.ogrenciEkle(gorsel,adSoyad,mail,ogrNo)
        }


    }
}

package com.example.wtechsqlite.fragments

import android.app.TabActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.wtechsqlite.R
import com.example.wtechsqlite.databinding.FragmentAnaSayfaBinding
import com.example.wtechsqlite.db.Veritabani
import com.example.wtechsqlite.models.OgrenciModel

class AnaSayfaFragment : Fragment() {

    private lateinit var binding : FragmentAnaSayfaBinding

    private lateinit var veriTabani : Veritabani

    private lateinit var ogrenciList : ArrayList<OgrenciModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        veriTabani = Veritabani(requireContext())
        ogrenciList = ArrayList()

        veriTabani.tumOgrencilerAl(ogrenciList)
        println(ogrenciList)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_ana_sayfa, container, false)
        binding = FragmentAnaSayfaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tumOgrencilerButton.setOnClickListener{
            findNavController().navigate(R.id.action_anaSayfaFragment_to_tumOgrencilerFragment)
        }

        binding.ogrenciAraButton.setOnClickListener {
            findNavController().navigate(R.id.action_anaSayfaFragment_to_ogrenciAraFragment2)
        }

        binding.ogrenciEkleButton.setOnClickListener {
            findNavController().navigate(R.id.action_anaSayfaFragment_to_ogrenciEkleFragment)
        }

        binding.ogrencileriTemizleButton.setOnClickListener {
            veriTabani.ogrencileriTemizle()
        }

    }


}
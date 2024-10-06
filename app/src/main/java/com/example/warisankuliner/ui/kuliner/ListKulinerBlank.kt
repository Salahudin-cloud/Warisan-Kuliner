package com.example.warisankuliner.ui.kuliner

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.warisankuliner.R
import com.example.warisankuliner.adapter.KulinerAdapter
import com.example.warisankuliner.databinding.FragmentListKulinerBlankBinding
import com.example.warisankuliner.models.Kuliner


class ListKulinerBlank : Fragment() {

    private lateinit var _binding: FragmentListKulinerBlankBinding
    private val binding get() = _binding!!

    private var kulinerList = ArrayList<Kuliner>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_list_kuliner_blank, container, false)
        _binding = FragmentListKulinerBlankBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recylerviewKuliner.setHasFixedSize(true)


        kulinerList.clear()
        kulinerList.addAll(getListKuliner())
        showRecyleView()
    }



    private fun showRecyleView(){
        binding.recylerviewKuliner.layoutManager = LinearLayoutManager(requireContext())
        val kulinerAdapter = KulinerAdapter(kulinerList)
        binding.recylerviewKuliner.adapter = kulinerAdapter


        // implement clicked item
        kulinerAdapter.setOnItemClickCallBack(object : KulinerAdapter.OnItemClickedCallBack {
            override fun onItemClicked(data: Kuliner) {
                val send = ListKulinerBlankDirections.actionListKulinerBlankToDetailKulinerFragment(data)
                findNavController().navigate(send)
            }
        })
    }


    private fun getListKuliner(): ArrayList<Kuliner> {
        val dataImageKuliner = resources.getStringArray(R.array.data_image_kuliner)
        val dataNamaKuliner = resources.getStringArray(R.array.data_nama_kuliner)
        val dataTempatAsalKuliner = resources.getStringArray(R.array.data_tempat_asal)
        val dataDaerahKuliner = resources.getStringArray(R.array.data_daerah)
        val dataBahanUtamaKuliner = resources.getStringArray(R.array.data_bahan_utama)
        val dataVariasiKuliner = resources.getStringArray(R.array.data_variasi)
        val dataDeskripsiKuliner = resources.getStringArray(R.array.data_desc_kuliner)

        val listKuliner = ArrayList<Kuliner>()
        for (i in dataImageKuliner.indices) {
            val kuliner = Kuliner(
                dataImageKuliner[i],
                dataNamaKuliner[i],
                dataTempatAsalKuliner[i],
                dataDaerahKuliner[i],
                dataBahanUtamaKuliner[i],
                dataVariasiKuliner[i],
                dataDeskripsiKuliner[i]
            )


            listKuliner.add(kuliner)
        }

        return listKuliner
    }

}
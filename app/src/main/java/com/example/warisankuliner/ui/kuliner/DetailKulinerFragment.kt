package com.example.warisankuliner.ui.kuliner

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.warisankuliner.R
import com.example.warisankuliner.databinding.FragmentDetailKulinerBinding
import com.example.warisankuliner.databinding.FragmentListKulinerBlankBinding


class DetailKulinerFragment : Fragment() {

    private lateinit var _binding: FragmentDetailKulinerBinding
    private val binding get() = _binding!!

    val  args : DetailKulinerFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
       _binding = FragmentDetailKulinerBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // acces the args
        val kulinerData = args.Kuliner
        // set
        // imageg kuliner
        Glide.with(requireContext())
            .load(kulinerData.imageKuliner)
            .into(binding.imageView2)

        // set valute kuliner
        binding.valueNamaKuliner.text = kulinerData.namaKuliner
        // set value tempat asal
        binding.valueTempatAsal.text = kulinerData.tempatAsalKuliner
        // set value nama daerah
        binding.valueNamaDaerah.text = kulinerData.daerahKuliner
        // set value bahan utama
        binding.valeuBahanUtama.text = kulinerData.bahanUtamaKuliner
        // set value variasi
        binding.valueVariasi.text = kulinerData.variasiKuliner
        // set desc kuliner
        binding.valueDesc.text = kulinerData.deskrpsiKuliner

        //implements share button
        val shareText = """
            Nama Kuliner: ${kulinerData.namaKuliner}
            Tempat Asal: ${kulinerData.tempatAsalKuliner}
            Daerah: ${kulinerData.daerahKuliner}
            Bahan Utama: ${kulinerData.bahanUtamaKuliner}
            Variasi: ${kulinerData.variasiKuliner}
            Deskripsi: ${kulinerData.deskrpsiKuliner}
        """.trimIndent()

        // click button
        binding.shareButton.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, shareText)
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Share Kuliner"))
        }
    }
}
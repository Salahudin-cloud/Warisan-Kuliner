package com.example.warisankuliner

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.warisankuliner.adapter.KulinerAdapter
import com.example.warisankuliner.data.Kuliner
import com.example.warisankuliner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val list = ArrayList<Kuliner>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.recyclerKuliner.setHasFixedSize(true)




        list.addAll(getListKuliner())

        showRecyclerKuliner()

    }

    private fun showRecyclerKuliner(){
        binding.recyclerKuliner.layoutManager = LinearLayoutManager(this)
        val kulinerAdapter = KulinerAdapter(list)
        binding.recyclerKuliner.adapter = kulinerAdapter


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
            // Print the name of the culinary item to Logcat
            Log.d("KulinerInfo", "Kuliner image: ${kuliner.imageKuliner}")


            listKuliner.add(kuliner)
        }

        return listKuliner
    }
}
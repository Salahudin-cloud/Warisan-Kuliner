package com.example.warisankuliner.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.warisankuliner.models.Kuliner
import com.example.warisankuliner.databinding.CardListKulinerBinding

class KulinerAdapter(
    private val listKuliner: ArrayList<Kuliner>
) : RecyclerView.Adapter<KulinerAdapter.ListViewHolder>(){

   inner class ListViewHolder (val binding : CardListKulinerBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
      val binding = CardListKulinerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listKuliner.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (
            setImageKuliner,
            setNamaKuliner,
        ) = listKuliner[position]

        // set image kuliner
        Glide.with(holder.itemView.context)
            .load(setImageKuliner)
            .into(holder.binding.kulinerImage)

        // set nama kuliner
        holder.binding.kulinerNama.text = setNamaKuliner



    }

}
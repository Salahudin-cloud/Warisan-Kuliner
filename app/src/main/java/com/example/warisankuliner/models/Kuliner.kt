package com.example.warisankuliner.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Kuliner(
    val imageKuliner:String,
    val namaKuliner: String,
    val tempatAsalKuliner:String,
    val daerahKuliner:String,
    val bahanUtamaKuliner:String,
    val variasiKuliner:String,
    val deskrpsiKuliner:String,
) : Parcelable

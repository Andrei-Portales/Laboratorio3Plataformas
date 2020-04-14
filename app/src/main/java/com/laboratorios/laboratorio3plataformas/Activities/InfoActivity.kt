package com.laboratorios.laboratorio3plataformas.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil

import com.laboratorios.laboratorio3plataformas.R
import com.laboratorios.laboratorio3plataformas.databinding.ActivityInfoBinding


class InfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_info)
        var tipo = intent.extras?.getInt("tipo") as Int
        crear(tipo)
    }


    fun crear(tipo:Int){

    }
}

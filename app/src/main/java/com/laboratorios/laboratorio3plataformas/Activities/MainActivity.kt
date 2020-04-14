package com.laboratorios.laboratorio3plataformas.Activities

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.laboratorios.laboratorio3plataformas.R
import com.laboratorios.laboratorio3plataformas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var cambio = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.txtInfo.text = getString(R.string.infoEdad)
        binding.txtInfo.visibility = View.GONE
        botones()
    }

    fun botones(){

        binding.apply {
            floatingChange.setOnClickListener {
                if (cambio == false){
                    textView.visibility = View.GONE
                    textView3.visibility = View.GONE
                    edtNombre.visibility = View.GONE
                    edtEdad.visibility = View.GONE
                    txtInfo.visibility = View.VISIBLE
                    cambio = true
                }else{
                    textView.visibility = View.VISIBLE
                    textView3.visibility = View.VISIBLE
                    edtNombre.visibility = View.VISIBLE
                    edtEdad.visibility = View.VISIBLE
                    txtInfo.visibility = View.GONE
                    cambio = false
                }

            }

            btnVirus.setOnClickListener { activityInfo(0) }
            btnSintomas.setOnClickListener { activityInfo(1) }
            btnIndicaciones.setOnClickListener { activityInfo(2) }


        }
    }

    fun activityInfo(tipo:Int){
        var intent = Intent(this,InfoActivity::class.java)
        intent.putExtra("tipo",tipo)
        startActivity(intent)
    }

}

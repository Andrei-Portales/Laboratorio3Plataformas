package com.laboratorios.laboratorio3plataformas.Activities

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil

import com.laboratorios.laboratorio3plataformas.R
import com.laboratorios.laboratorio3plataformas.Topic
import com.laboratorios.laboratorio3plataformas.databinding.ActivityInfoBinding


class InfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoBinding
    private lateinit var topic : Topic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_info)
        binding.txtTitulo.typeface = Typeface.createFromAsset(assets, "fonts/Roboto-Bold.ttf")
        var tipo = intent.extras?.getInt("tipo") as Int
        crear(tipo)
        botones()
    }


    fun crear(tipo:Int){
        when(tipo){
            0 -> topic = Topic(
                getString(R.string.titulo),
                getString(R.string.sub1),
                getString(R.string.desc1)
            )
            1 ->  topic = Topic(
                getString(R.string.titulo),
                getString(R.string.sub2),
                getString(R.string.desc2)
            )
            2 ->  topic = Topic(
                getString(R.string.titulo),
                getString(R.string.sub3),
                getString(R.string.desc3)
            )
            else -> topic =
                Topic("", "", "")
        }
        binding.topic = topic
    }

    fun botones(){

        binding.btnComentar.setOnClickListener {
            if (binding.txtComentario.text.toString().isNotEmpty()){
                comment(binding.txtComentario.text.toString())
            }else{
                Toast.makeText(this,"Campo Vacio",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun comment(comentario:String){
        var intent = Intent(this, MainActivity::class.java)
        intent.putExtra("comentario",comentario)
        startActivity(intent)

    }
}

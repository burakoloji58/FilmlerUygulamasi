package com.example.filmleruygulamasi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class KatagorilerAdapter(private val mContex:Context,private val katagorilerListe :List<Katagoriler>)
    : RecyclerView.Adapter<KatagorilerAdapter.cardTasarimKatagoriTutucu>(){

    inner class cardTasarimKatagoriTutucu(tasarim:View) : RecyclerView.ViewHolder(tasarim){

        val card_katagori : CardView
        val textViewKatagori : TextView

        init {
            card_katagori = tasarim.findViewById(R.id.card_katagori)
            textViewKatagori = tasarim.findViewById(R.id.textViewKatagori)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardTasarimKatagoriTutucu {
        val tasarim = LayoutInflater.from(mContex).inflate(R.layout.card_tasarim_katagori,parent,false)
        return cardTasarimKatagoriTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return katagorilerListe.size
    }

    override fun onBindViewHolder(holder: cardTasarimKatagoriTutucu, position: Int) {
        val katagori = katagorilerListe.get(position)

        holder.textViewKatagori.text = katagori.katagori_ad

        holder.card_katagori.setOnClickListener {
            val intent = Intent(mContex,FilmlerActivity::class.java)
            intent.putExtra("katagoriNesne",katagori)
            mContex.startActivity(intent)
        }
    }

}
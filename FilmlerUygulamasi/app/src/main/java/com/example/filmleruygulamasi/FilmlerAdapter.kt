package com.example.filmleruygulamasi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class FilmlerAdapter(private val mContex:Context, private val filmlerListe:List<Filmler>)
    : RecyclerView.Adapter<FilmlerAdapter.cardTasarimFilmTutucu>(){

    inner class cardTasarimFilmTutucu(tasarim:View) : RecyclerView.ViewHolder(tasarim){

        val card_film:CardView
        val imageViewFilmResim: ImageView
        val textViewFilmAd: TextView

        init {
            card_film = tasarim.findViewById(R.id.card_film)
            imageViewFilmResim = tasarim.findViewById(R.id.imageViewFilmResim)
            textViewFilmAd = tasarim.findViewById(R.id.textViewFilmAd)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardTasarimFilmTutucu {
        val tasarim = LayoutInflater.from(mContex).inflate(R.layout.card_tasarim_film,parent,false)
        return cardTasarimFilmTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return filmlerListe.size
    }

    override fun onBindViewHolder(holder: cardTasarimFilmTutucu, position: Int) {
        val film = filmlerListe.get(position)

        holder.textViewFilmAd.text = film.film_ad
        holder.imageViewFilmResim.setImageResource(mContex.resources.getIdentifier(film.film_resim,"drawable",mContex.packageName))

        holder.card_film.setOnClickListener {
            val intet = Intent(mContex,DetayActivity::class.java)
            intet.putExtra("filmNesne",film)
            mContex.startActivity(intet)
        }
    }

}
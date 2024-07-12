package com.example.filmleruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.filmleruygulamasi.databinding.ActivityDetayBinding

class DetayActivity : AppCompatActivity() {
    private lateinit var ulas : ActivityDetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        ulas = ActivityDetayBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(ulas.root)

        val gelenFilm = intent.getSerializableExtra("filmNesne") as Filmler

        ulas.imageViewFilmDetayResim.setImageResource(resources.getIdentifier(gelenFilm.film_resim,"drawable",packageName))
        ulas.textViewFilmDetayAd.text = gelenFilm.film_ad
        ulas.textViewFilmDetayYil.text = gelenFilm.film_yil.toString()
        ulas.textViewFilmDetayYonetmen.text = gelenFilm.film_yonetmen.yonetmen_ad

    }
}
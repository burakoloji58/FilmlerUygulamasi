package com.example.filmleruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmleruygulamasi.databinding.ActivityFilmlerBinding

class FilmlerActivity : AppCompatActivity() {
    private lateinit var ulas : ActivityFilmlerBinding
    private lateinit var adapter : FilmlerAdapter
    private lateinit var filmlerListe : ArrayList<Filmler>
    private lateinit var vt : VeritabaniYardimcisi
    override fun onCreate(savedInstanceState: Bundle?) {
        ulas = ActivityFilmlerBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(ulas.root)

        vt = VeritabaniYardimcisi(this)

        val katagoriAd = intent.getSerializableExtra("katagoriNesne") as Katagoriler

        ulas.toolbarFilmler.title= "Filmler: ${katagoriAd.katagori_ad}"
        setSupportActionBar(ulas.toolbarFilmler)

        ulas.rvFilmler.setHasFixedSize(true)
        ulas.rvFilmler.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        filmlerListe = Filmlerdao().TumFilmler(vt,katagoriAd.katagori_id)

        adapter = FilmlerAdapter(this,filmlerListe)

        ulas.rvFilmler.adapter = adapter


    }
}
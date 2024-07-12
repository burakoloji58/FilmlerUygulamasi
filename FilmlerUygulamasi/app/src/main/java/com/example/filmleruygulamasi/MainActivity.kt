package com.example.filmleruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmleruygulamasi.databinding.ActivityMainBinding
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper

class MainActivity : AppCompatActivity() {
    private lateinit var  ulas : ActivityMainBinding
    private lateinit var katagorilerListe : ArrayList<Katagoriler>
    private lateinit var adapter : KatagorilerAdapter
    private lateinit var vt : VeritabaniYardimcisi
    override fun onCreate(savedInstanceState: Bundle?) {
        ulas = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(ulas.root)

        VeriTabaniKopyala()

        vt = VeritabaniYardimcisi(this)

        ulas.toolbarKategori.title = "Kategoriler"
        setSupportActionBar(ulas.toolbarKategori)

        katagorilerListe = Katagorilerdao().TumKatagoriler(vt)

        ulas.rvKategori.setHasFixedSize(true)
        ulas.rvKategori.layoutManager = LinearLayoutManager(this)

        adapter = KatagorilerAdapter(this,katagorilerListe)

        ulas.rvKategori.adapter = adapter

    }

    fun VeriTabaniKopyala(){
        val copyHelper = DatabaseCopyHelper(this)

        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        }catch (e:Exception)
        {
            e.printStackTrace()
        }

    }


}
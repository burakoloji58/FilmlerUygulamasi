package com.example.filmleruygulamasi

import java.io.Serializable

data class Filmler(var film_id:Int,
                   var film_ad:String,
                   var film_yil:Int,
                   var film_resim:String,
                   var film_katagori:Katagoriler,
                   var film_yonetmen:Yonetmenler) :Serializable{

}
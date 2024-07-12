package com.example.filmleruygulamasi

class Filmlerdao {

    fun TumFilmler(vt : VeritabaniYardimcisi,kategori_id:Int) : ArrayList<Filmler>{
        val db = vt.writableDatabase

        val filmlerListe = ArrayList<Filmler>()

        val c = db.rawQuery("SELECT * FROM kategoriler,yonetmenler,filmler WHERE kategoriler.kategori_id=filmler.kategori_id AND yonetmenler.yonetmen_id=filmler.yonetmen_id AND filmler.kategori_id=$kategori_id",null)

        while (c.moveToNext())
        {

            val katagori = Katagoriler(c.getInt(c.getColumnIndex("kategori_id")),
                c.getString(c.getColumnIndex("kategori_ad")))

            val yonetmen = Yonetmenler(c.getInt(c.getColumnIndex("yonetmen_id")),
                c.getString(c.getColumnIndex("yonetmen_ad")))

            val film = Filmler(c.getInt(c.getColumnIndex("film_id")),
                c.getString(c.getColumnIndex("film_ad")),
                c.getInt(c.getColumnIndex("film_yil")),
                c.getString(c.getColumnIndex("film_resim")),katagori,yonetmen)

            filmlerListe.add(film)
        }
        return filmlerListe
    }

}
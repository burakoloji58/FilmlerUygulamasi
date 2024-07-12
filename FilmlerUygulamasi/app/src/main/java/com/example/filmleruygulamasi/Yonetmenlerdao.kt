package com.example.filmleruygulamasi

class Yonetmenlerdao {

    fun TumYonetmenler(vt : VeritabaniYardimcisi) : ArrayList<Yonetmenler>{
        val db = vt.writableDatabase

        val yonetmenlerListe = ArrayList<Yonetmenler>()

        val c = db.rawQuery("SELECT * FROM yonetmenler",null)

        while (c.moveToNext())
        {
            val yonetmen = Yonetmenler(c.getInt(c.getColumnIndex("yonetmen_id")),
                c.getString(c.getColumnIndex("yonetmen_ad")))

            yonetmenlerListe.add(yonetmen)
        }
        return yonetmenlerListe
    }
}
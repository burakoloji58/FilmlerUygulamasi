package com.example.filmleruygulamasi

class Katagorilerdao {

    fun TumKatagoriler(vt : VeritabaniYardimcisi) : ArrayList<Katagoriler>{
        val db = vt.writableDatabase

        val katagorilerListe = ArrayList<Katagoriler>()

        val c = db.rawQuery("SELECT * FROM kategoriler",null)

        while (c.moveToNext())
        {
            val katagori = Katagoriler(c.getInt(c.getColumnIndex("kategori_id")),
                c.getString(c.getColumnIndex("kategori_ad")))

            katagorilerListe.add(katagori)
        }
        return katagorilerListe
    }

}
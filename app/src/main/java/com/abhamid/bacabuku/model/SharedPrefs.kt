package com.abhamid.bacabuku.model

import android.preference.PreferenceManager
import com.abhamid.bacabuku.App

object SharedPrefs {
    //Keep getting error dont know why :(
    private const val GENRE_ID = "GENRE_ID"

    fun sharedPrefs() = PreferenceManager.getDefaultSharedPreferences(App.getAppContext())

    fun saveGenre(genreId: Int) {
        val editor = sharedPrefs().edit()
        editor.putInt(GENRE_ID, genreId).apply()
    }

    fun getGenre(): Int = sharedPrefs().getInt(GENRE_ID, 1)

}
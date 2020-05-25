package com.auas.aad.gamebacklog.ui

import android.util.Log
import android.view.View
import com.auas.aad.gamebacklog.model.Game
import com.auas.aad.gamebacklog.ui.main.MainActivityViewModel

class UndoListener(private val itemsToBeDeleted : ArrayList<Game>, private val mainActivityViewModel: MainActivityViewModel) : View.OnClickListener {

    override fun onClick(v: View) {
        for (game in itemsToBeDeleted) {
            Log.i("Hello: ", game.title)
        }
    }
}
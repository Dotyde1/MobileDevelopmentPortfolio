package com.auas.aad.notepad.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.auas.aad.notepad.database.NoteRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val noteRepository = NoteRepository(application.applicationContext)

    val note = noteRepository.getNotepad()

}
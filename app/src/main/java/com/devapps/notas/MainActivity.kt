package com.devapps.notas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devapps.notas.adapter.NoteAdapter
import com.devapps.notas.databinding.ActivityMainBinding
import com.devapps.notas.model.Note

class MainActivity : AppCompatActivity() {

    private lateinit var notes: MutableList<Note>

    private val mNoteAdapter by lazy { NoteAdapter(this, notes) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initNotes()

        setupListView()
    }

    private fun initNotes() {
        notes = mutableListOf()
        for (i in 1..10000) {
            var note = Note("Nota $i", "Nota $i inserida.")
            notes.add(note)
        }
    }

    private fun setupListView() {
        binding.noteList.adapter = mNoteAdapter
    }
}
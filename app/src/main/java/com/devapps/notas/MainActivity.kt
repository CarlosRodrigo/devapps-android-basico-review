package com.devapps.notas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devapps.notas.adapter.NoteRecyclerAdapter
import com.devapps.notas.databinding.ActivityMainBinding
import com.devapps.notas.model.Note

class MainActivity : AppCompatActivity() {

    private lateinit var notes: MutableList<Note>

    private val mNoteAdapter by lazy { NoteRecyclerAdapter(notes) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initNotes()

        setupRecyclerView()
    }

    private fun initNotes() {
        notes = mutableListOf()
        for (i in 1..10000) {
            var note = Note("Nota $i", "Nota $i inserida.")
            notes.add(note)
        }
    }

    private fun setupRecyclerView() {
        binding.noteRecyclerview.adapter = mNoteAdapter
        val layoutManager = LinearLayoutManager(this)
        binding.noteRecyclerview.layoutManager = layoutManager
    }
}
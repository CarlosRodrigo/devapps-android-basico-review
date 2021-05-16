package com.devapps.notas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devapps.notas.adapter.NoteAdapter
import com.devapps.notas.databinding.ActivityMainBinding
import com.devapps.notas.model.Note

class MainActivity : AppCompatActivity() {

    private val notes = mutableListOf(
        Note("Nota 1", "Primeira nota inserida"),
        Note("Nota 2", "Segunda nota inserida"),
        Note("Nota 3", "Terceira nota inserida"),
        Note("Nota 4", "Quarta nota inserida")
    )

    private val mNoteAdapter by lazy { NoteAdapter(this, notes) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupListView()
    }

    private fun setupListView() {
        binding.noteList.adapter = mNoteAdapter
    }
}
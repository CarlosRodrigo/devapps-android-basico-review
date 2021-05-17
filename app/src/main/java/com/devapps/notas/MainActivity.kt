package com.devapps.notas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.devapps.notas.adapter.NoteRecyclerAdapter
import com.devapps.notas.databinding.ActivityMainBinding
import com.devapps.notas.model.Note

class MainActivity : AppCompatActivity() {

    private lateinit var notes: MutableList<Note>

    private val mNoteAdapter by lazy { NoteRecyclerAdapter(notes) }
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val MAIN_ACTIVITY_REQUEST_CODE = 1
        const val MAIN_ACTIVITY_NOTE_EXTRA = "note_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initNotes()

        setupRecyclerView()

        binding.addNote.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivityForResult(intent, MAIN_ACTIVITY_REQUEST_CODE)
        }
    }

    private fun initNotes() {
        notes = mutableListOf()
        for (i in 1..2) {
            var note = Note("Nota $i", "Nota $i inserida.")
            notes.add(note)
        }
    }

    private fun setupRecyclerView() {
        binding.noteRecyclerview.adapter = mNoteAdapter
        val layoutManager = LinearLayoutManager(this)
        binding.noteRecyclerview.layoutManager = layoutManager
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == MAIN_ACTIVITY_REQUEST_CODE) {
                val note = data?.getParcelableExtra<Note>(MAIN_ACTIVITY_NOTE_EXTRA)
                note?.let { notes.add(it) }
                mNoteAdapter.notifyDataSetChanged()
            }
        }
    }
}
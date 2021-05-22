package com.devapps.notas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.devapps.notas.databinding.ActivityAddNoteBinding
import com.devapps.notas.model.Note

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private var position: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val note = intent?.getParcelableExtra<Note>(MainActivity.MAIN_ACTIVITY_NOTE_EXTRA)
        note?.let {
            binding.addNoteTitle.setText(note.title)
            binding.addNoteDescription.setText(note.description)
        }

        val data = intent?.getIntExtra(MainActivity.MAIN_ACTIVITY_NOTE_POSITION_EXTRA, -1)
        data?.let {
            position = data
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add_note, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.menu_add_note_ic_done -> {
            val title = binding.addNoteTitle.text.toString()
            val description = binding.addNoteDescription.text.toString()

            val note = Note(title, description)
            val returnIntent = Intent(this, MainActivity::class.java)
            returnIntent.putExtra(MainActivity.MAIN_ACTIVITY_NOTE_EXTRA, note)
            returnIntent.putExtra(MainActivity.MAIN_ACTIVITY_NOTE_POSITION_EXTRA, position)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
}
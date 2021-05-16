package com.devapps.notas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.devapps.notas.databinding.NoteItemBinding
import com.devapps.notas.model.Note

class NoteAdapter(private val context: Context,
                  private val notes: MutableList<Note>) : BaseAdapter() {

    override fun getCount() = notes.size

    override fun getItem(position: Int) = notes[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val note = notes[position]

        val binding = NoteItemBinding.inflate(LayoutInflater.from(context))
        val view = binding.root

        binding.noteItemTitle.text = note.title
        binding.itemNoteDescription.text = note.description

        return view
    }

}
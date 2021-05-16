package com.devapps.notas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devapps.notas.R
import com.devapps.notas.databinding.NoteItemBinding
import com.devapps.notas.model.Note

class NoteRecyclerAdapter(private val context: Context,
                          private  val notes: MutableList<Note>) : RecyclerView.Adapter<NoteRecyclerAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        val binding = NoteItemBinding.bind(view)

        val vh = VH(binding)
        return vh
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val note = notes[position]


        // Using findViewById
        val title = holder.itemView.findViewById<TextView>(R.id.note_item_title)
        title.text = note.title
        val description = holder.itemView.findViewById<TextView>(R.id.item_note_description)
        description.text = note.description
    }

    override fun getItemCount() = notes.size

    class VH(itemView: NoteItemBinding) : RecyclerView.ViewHolder(itemView.root) {

    }

}

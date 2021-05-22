package com.devapps.notas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devapps.notas.R
import com.devapps.notas.databinding.NoteItemBinding
import com.devapps.notas.model.Note
import java.util.*

class NoteRecyclerAdapter(private  val notes: MutableList<Note>,
                          private val callback: (Note, Int) -> Unit)
    : RecyclerView.Adapter<NoteRecyclerAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        val binding = NoteItemBinding.bind(view)

        val vh = VH(binding)

        vh.itemView.setOnClickListener {
            val note = notes[vh.adapterPosition]
            callback(note, vh.adapterPosition)
        }

        return vh
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val note = notes[position]
        holder.setValues(note.title, note.description)
    }

    override fun getItemCount() = notes.size

    fun remove(position: Int) {
        notes.removeAt(position)
        notifyDataSetChanged()
    }

    fun swap(initPosition: Int, targetPosition: Int) {
        Collections.swap(notes, initPosition, targetPosition)
        notifyDataSetChanged()
    }

    class VH(itemView: NoteItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val title = itemView.noteItemTitle
        private val description = itemView.itemNoteDescription

        fun setValues(title: String, description: String) {
            this.title.text = title
            this.description.text = description
        }
    }

}

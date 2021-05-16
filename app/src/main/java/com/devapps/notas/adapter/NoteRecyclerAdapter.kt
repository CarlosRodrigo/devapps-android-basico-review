package com.devapps.notas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
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

    }

    override fun getItemCount() = notes.size

    class VH(itemView: NoteItemBinding) : RecyclerView.ViewHolder(itemView.root) {

    }

}

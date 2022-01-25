package com.example.roomdatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.room.Note
import kotlinx.android.synthetic.main.adapter_movie.view.*

class MovieAdapter (private val note: ArrayList<Note>, private val listener: OnAdapterListener)
    : RecyclerView.Adapter<MovieAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_movie, parent, false)
        )
    }

    override fun getItemCount() = note.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = note[position]
        holder.view.text_title.text = note.title
        holder.view.text_title.setOnClickListener {
            listener.OnClick(note)
        }
        holder.view.icon_edit.setOnClickListener {
            listener.OnUpdate(note)
        }
        holder.view.icon_delete.setOnClickListener {
            listener.OnDelete(note)
        }
    }


    class NoteViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setData(list: List<Note>) {
        note.clear()
        note.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun OnClick (note: Note)
        fun OnUpdate (note: Note)
        fun OnDelete (note: Note)
    }
}
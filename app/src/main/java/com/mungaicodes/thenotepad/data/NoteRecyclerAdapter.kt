package com.mungaicodes.thenotepad.data

import android.content.Context
import android.content.Intent
import android.os.Build.VERSION_CODES.N
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mungaicodes.thenotepad.MainActivity
import com.mungaicodes.thenotepad.NOTE_POSITION
import com.mungaicodes.thenotepad.R
import com.mungaicodes.thenotepad.model.NoteInfo

class NoteRecyclerAdapter(private val context: Context, private val notes: List<NoteInfo>) :
    RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textCourse: TextView = itemView.findViewById(R.id.textCourse)
        val textTitle: TextView = itemView.findViewById(R.id.textTitle)
        var notePosition = 0
        init {
            itemView.setOnClickListener {
                val intent = Intent(context, MainActivity::class.java)
                intent.putExtra(NOTE_POSITION, notePosition)
                context.startActivity(intent)
            }
        }
    }

    //for inflating the views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_note_list, parent, false)
        return ViewHolder(itemView)
    }

    //responsible for displaying data
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.textCourse.text = note.course?.title
        holder.textTitle.text = note.title
        holder.notePosition = position
    }

    override fun getItemCount() = notes.size


}
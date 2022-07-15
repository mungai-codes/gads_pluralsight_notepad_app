package com.mungaicodes.thenotepad

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.mungaicodes.thenotepad.data.DataManager
import com.mungaicodes.thenotepad.databinding.ActivityNoteListBinding

class NoteListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteListBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            val actIntent = Intent(this, MainActivity::class.java)
            startActivity(actIntent)
        }

        val noteList: ListView = findViewById(R.id.listNotes)
        noteList.adapter = ArrayAdapter(this,
        android.R.layout.simple_list_item_1, DataManager.notes)

        noteList.setOnItemClickListener { parent, view, position, id ->

            val myIntent = Intent(this, MainActivity::class.java)
            myIntent.putExtra(NOTE_POSITION, position)
            startActivity(myIntent)
        }

    }


}
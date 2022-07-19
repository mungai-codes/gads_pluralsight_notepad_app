package com.mungaicodes.thenotepad

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mungaicodes.thenotepad.data.DataManager
import com.mungaicodes.thenotepad.data.NoteRecyclerAdapter
import com.mungaicodes.thenotepad.databinding.ActivityNoteListBinding
import com.mungaicodes.thenotepad.model.NoteInfo

class NoteListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoteListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener {
            val actIntent = Intent(this, MainActivity::class.java)
            startActivity(actIntent)
        }

        //associating a layout manager with the recycler view
        val recyclerView: RecyclerView = findViewById(R.id.listItemsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        //associating NoteRecyclerAdapter with the recycler view
        recyclerView.adapter = NoteRecyclerAdapter(this, DataManager.notes)


    }

    override fun onResume() {
        super.onResume()
        val recyclerView: RecyclerView = findViewById(R.id.listItemsRecyclerView)
        recyclerView.adapter?.notifyDataSetChanged()
    }


}
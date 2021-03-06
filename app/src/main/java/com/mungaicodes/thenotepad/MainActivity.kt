package com.mungaicodes.thenotepad

import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mungaicodes.thenotepad.data.DataManager
import com.mungaicodes.thenotepad.model.CourseInfo
import com.mungaicodes.thenotepad.model.NoteInfo
import android.os.Bundle as Bundle1

class MainActivity : AppCompatActivity() {

    private var notePosition = POSITION_NOT_SET


    override fun onCreate(savedInstanceState: Bundle1?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapterCourses = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, DataManager.courses.values.toList()
        )
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val coursesSpinner: Spinner = findViewById(R.id.coursesSpinner)
        coursesSpinner.adapter = adapterCourses

        notePosition = savedInstanceState?.getInt(NOTE_POSITION, POSITION_NOT_SET) ?:
            intent.getIntExtra(NOTE_POSITION, POSITION_NOT_SET)

        if (notePosition != POSITION_NOT_SET) {
            displayNote()
        } else {
            DataManager.notes.add(NoteInfo())
            notePosition = DataManager.notes.lastIndex
        }

    }

    private fun displayNote() {

        val note = DataManager.notes[notePosition]
        val noteTitle: TextView = findViewById(R.id.textNoteTitle)
        val noteText: TextView = findViewById(R.id.textNoteText)
        val courseSpinner: Spinner = findViewById(R.id.coursesSpinner)

        noteTitle.setText(note.title)
        noteText.setText(note.text)

        val coursePosition = DataManager.courses.values.indexOf(note.course)
        courseSpinner.setSelection(coursePosition)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.action_next -> {
                moveNext()
                true
            }
            R.id.action_back -> {
                movePrevious()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun moveNext() {
        ++notePosition
        displayNote()
        invalidateOptionsMenu()
    }

    private fun movePrevious() {
        --notePosition
        displayNote()
        invalidateOptionsMenu()
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        if (notePosition >= DataManager.notes.lastIndex) {
            val menuItem = menu.findItem(R.id.action_next)
            if (menuItem != null) {
                menuItem.icon = getDrawable(R.drawable.ic_block_white)
                menuItem.isEnabled = false
            }
        }
        if (notePosition < 1) {
            val menuItem = menu.findItem(R.id.action_back)
            if (menuItem != null) {
                menuItem.icon = getDrawable(R.drawable.ic_block_white)
                menuItem.isEnabled = false
            }
        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onPause() {
        super.onPause()
        saveNote()
    }

    private fun saveNote() {
        val note = DataManager.notes[notePosition]
        val noteTitle: TextView = findViewById(R.id.textNoteTitle)
        note.title = noteTitle.text.toString()
        val noteText: TextView = findViewById(R.id.textNoteText)
        note.text = noteText.text.toString()
        val courseSpinner: Spinner = findViewById(R.id.coursesSpinner)
        note.course = courseSpinner.selectedItem as CourseInfo

    }

    override fun onSaveInstanceState(outState: android.os.Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(NOTE_POSITION, notePosition)
    }



}
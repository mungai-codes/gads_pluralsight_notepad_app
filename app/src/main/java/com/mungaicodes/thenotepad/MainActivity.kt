package com.mungaicodes.thenotepad

import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mungaicodes.thenotepad.data.DataManager
import com.mungaicodes.thenotepad.model.CourseInfo
import android.os.Bundle as Bundle1

class MainActivity : AppCompatActivity() {

    private var notePosition = POSITION_NOT_SET

    override fun onCreate(savedInstanceState: Bundle1?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapterCourses = ArrayAdapter<CourseInfo>(
            this,
            android.R.layout.simple_spinner_item, DataManager.courses.values.toList()
        )
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val coursesSpinner: Spinner = findViewById(R.id.coursesSpinner)
        coursesSpinner.adapter = adapterCourses

        notePosition = intent.getIntExtra(EXTRA_NOTE_POSITION, POSITION_NOT_SET)

        if (notePosition != POSITION_NOT_SET) {
            displayNote()
        }

    }

    private fun displayNote() {

        val note = DataManager.notes[notePosition]
        val noteTitle: TextView = findViewById(R.id.textNoteTitle)
        val noteText: TextView = findViewById(R.id.textNoteText)
        val courseSpinner: Spinner = findViewById(R.id.coursesSpinner)

        noteTitle.setText(note.title)
        noteText.setText(note.text)

        val coursePosition = DataManager.courses.values.indexOf(note.courseInfo)
        courseSpinner.setSelection(coursePosition)
    }
}
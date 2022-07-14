package com.mungaicodes.thenotepad.data

import com.mungaicodes.thenotepad.model.CourseInfo
import com.mungaicodes.thenotepad.model.NoteInfo

object DataManager {

    val courses = hashMapOf<String, CourseInfo>()

    val notes = arrayListOf<NoteInfo>()

    init {
        initializeCourses()
        initializeNotes()
    }

    private fun initializeCourses() {
        var course = CourseInfo("android_intents", "Android Programming with Intents.")
        courses.set(course.courseId, course)
        course = CourseInfo("android_async", "Android Async Programming & Services.")
        courses.set(course.courseId, course)
        course = CourseInfo("java_lang", "Java Fundamentals: The Java Language.")
        courses.set(course.courseId, course)
        course = CourseInfo("java_core", "Java Fundamentals: The Core Platform.")
        courses.set(course.courseId, course)

    }

    private fun initializeNotes() {
        var note = NoteInfo(courses["android_intents"] as CourseInfo, "Dynamic intent resolution", "Wow intents allow components to be resolved at runtime")
        notes.add(note)

        note = NoteInfo(courses["android_intents"] as CourseInfo, "Deleting intents", "PendingIntents are powerful, they delegate much more than just a component invocation")
        notes.add(note)

        note = NoteInfo(courses["android_async"] as CourseInfo, "Service default threads", "Did you know that by default an Android Service will tie up the UI thread")
        notes.add(note)

        note = NoteInfo(courses["java_lang"] as CourseInfo, "Parameters", "Leverage variable-length parameters list")
        notes.add(note)

        note = NoteInfo(courses["java_lang"] as CourseInfo, "Anonymous classes", "Anonymous classes simplify implementing one use type")
        notes.add(note)

        note = NoteInfo(courses["java_core"] as CourseInfo, "Compiler options", "The .jar options isn't compatible with the -cp option")
        notes.add(note)

        note = NoteInfo(courses["java_core"] as CourseInfo, "Serialization", "Remember to include Serial/VersionUID to assure version compatibility")
        notes.add(note)
    }

}
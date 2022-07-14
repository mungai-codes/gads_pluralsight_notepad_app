package com.mungaicodes.thenotepad.data

import com.mungaicodes.thenotepad.model.CourseInfo
import com.mungaicodes.thenotepad.model.NoteInfo

class DataManager {

    val courses = hashMapOf<String, CourseInfo>()

    val notes = arrayListOf<NoteInfo>()

    init {
        initializeCourses()
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

}
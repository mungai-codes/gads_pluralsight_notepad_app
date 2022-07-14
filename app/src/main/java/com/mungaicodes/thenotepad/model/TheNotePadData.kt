package com.mungaicodes.thenotepad.model

data class CourseInfo(val courseId: String, val title: String) {
    override fun toString(): String {
        return title
    }
}

data class NoteInfo(val courseInfo: CourseInfo, var title: String, var text: String)
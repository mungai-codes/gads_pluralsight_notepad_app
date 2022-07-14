package com.mungaicodes.thenotepad.model

class CourseInfo(val courseId: String, val title: String)

class NoteInfo(val courseInfo: CourseInfo, var title: String, var text: String)
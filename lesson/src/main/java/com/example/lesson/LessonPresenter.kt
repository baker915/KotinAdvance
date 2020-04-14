package com.example.lesson;

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient.get
import com.example.core.utils.Utils.toast
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken

class LessonPresenter {
    companion object {
        const val LESSON_PATH = "lessons"
    }

    private var activity:LessonActivity? = null


    constructor(activity: LessonActivity) {
        this.activity = activity;
    }

    private lateinit var lessons: List<Lesson>
    private val type = object : TypeToken<List<Lesson>>() {}.type

    fun fetchData() {
        get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(lessons: List<Lesson>) {
                this@LessonPresenter.lessons = lessons
                activity!!.runOnUiThread { activity!!.showResult(lessons) }
            }

            override fun onFailure(message: String?) {
                activity!!.runOnUiThread { toast(message!!) }
            }
        })
    }

    fun showPlayback() {
        activity!!.showResult(lessons.filter { it.state == Lesson.State.PLAYBACK})
    }
}

fun main() {
    repeat(10) {
        println(it)
    }

    for (i in 0..9) {
        println(i)
    }

    for (i in 0 until 10) {
    }

    for (i in 9 downTo 0) {
        println(i)
    }
    val array = arrayOf(1,23,45,6,78,9)

    array.forEach {
        println(it)
    }

    for ((i,j) in array.withIndex()) {

    }









}
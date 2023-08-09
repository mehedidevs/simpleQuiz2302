package com.mehedi.simplequiz2302

data class QuizQuestion(
    val question: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)

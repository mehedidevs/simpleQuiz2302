package com.mehedi.simplequiz2302

import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    private var quizQuestions = DataSource.quizQuestions
    private var quizQuestion =quizQuestions


    init {
        quizQuestion.shuffle()

    }

    private var currentQuestionIndex = 0
    private var score = 0

    fun restart() {
        currentQuestionIndex = 0
    }

    fun getCurrentQuestion(): QuizQuestion {
        return quizQuestion[currentQuestionIndex]
    }

    fun getNextQuestion(): QuizQuestion? {
        currentQuestionIndex++
        return if (currentQuestionIndex < quizQuestion.size) {
            quizQuestion[currentQuestionIndex]
        } else {
            null
        }
    }

    fun checkAnswer(selectedIndex: Int): Boolean {
        val currentQuestion = quizQuestion[currentQuestionIndex]
        return if (selectedIndex == currentQuestion.correctAnswerIndex) {
            score++
            true
        } else {
            false
        }
    }

    fun getScore(): Int {
        return score
    }


    fun getQuestionSize(): Int {
        return quizQuestion.size
    }

}
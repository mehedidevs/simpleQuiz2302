package com.mehedi.simplequiz2302

import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    private var quizQuestions = DataSource.quizQuestions
    private var quizList : MutableList<QuizQuestion> =quizQuestions


    init {
        quizList.shuffle()



    }

    private var currentQuestionIndex = 0
    private var score = 0

    fun restart() {
        currentQuestionIndex = 0
    }

    fun getCurrentQuestion(): QuizQuestion {
        return quizList[currentQuestionIndex]
    }




    fun getNextQuestion(): QuizQuestion? {
        currentQuestionIndex++
        return if (currentQuestionIndex < quizList.size) {
            quizList[currentQuestionIndex]
        } else {
            null
        }
    }

    fun checkAnswer(selectedIndex: Int): Boolean {
        val currentQuestion = quizList[currentQuestionIndex]
        return if (selectedIndex == currentQuestion.correctAnswerIndex) {
            score +=2
            true
        } else {
            score--
            false
        }
    }

    fun getScore(): Int {
        return score
    }


    fun getQuestionSize(): Int {
        return quizList.size
    }

}
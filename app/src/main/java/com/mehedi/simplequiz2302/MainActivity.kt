package com.mehedi.simplequiz2302

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.mehedi.simplequiz2302.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: QuizViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextQuestion.setOnClickListener {
            val selectedOptionIndex =
                binding.optionsRadioGroup.indexOfChild(findViewById(binding.optionsRadioGroup.checkedRadioButtonId))

            if (selectedOptionIndex != -1) {
                viewModel.checkAnswer(selectedOptionIndex)
                showNExtQuestion()

            } else {
                Toast.makeText(this, "Select an Option", Toast.LENGTH_SHORT).show()
            }


        }


        showCurrentQuestion()

    }

    private fun showNExtQuestion() {
        val nextQuestion = viewModel.getNextQuestion()
        if (nextQuestion != null) {
            showCurrentQuestion()

        } else {
            showResult("Your Score : ${viewModel.getScore()} out of ${viewModel.getQuestionSize()} ")

        }


    }

    private fun showResult(msg: String) {

        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Your Result!")
            .setMessage(msg)
            .setPositiveButton("Restart") { _, _ ->
                viewModel.restart()
                showCurrentQuestion()

            }.setNegativeButton("Dismiss") { _, _ ->
                binding.nextQuestion.visibility = View.INVISIBLE


            }.setCancelable(false).create()
        alertDialog.show()


    }

    private fun showCurrentQuestion() {

        val currentQuestion = viewModel.getCurrentQuestion()

        binding.apply {
            questionTextView.text = currentQuestion.question
            option1RadioBtn.text = currentQuestion.options[0]
            option2RadioBtn.text = currentQuestion.options[1]
            option3RadioBtn.text = currentQuestion.options[2]
            option4RadioBtn.text = currentQuestion.options[3]
            optionsRadioGroup.clearCheck()


        }


    }


}
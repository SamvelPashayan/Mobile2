package com.example.geohz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import java.lang.Math.abs

private lateinit var true_button:Button
private lateinit var false_button:Button
private lateinit var nextButton:ImageButton
private lateinit var prevButton:ImageButton
private lateinit var questionTextView: TextView


private val questionBank = listOf(
    Question(R.string.question_australia, true),
    Question(R.string.question_oceans, true),
    Question(R.string.question_mideast, false),
    Question(R.string.question_africa, false),
    Question(R.string.question_americas, true),
    Question(R.string.question_asia, true))

private var currentIndex = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        true_button=findViewById(R.id.true_button)
        false_button=findViewById(R.id.false_button)
        nextButton=findViewById(R.id.next_button)
        prevButton=findViewById(R.id.prev_button)
        questionTextView = findViewById(R.id.question_text_view)

        true_button.setOnClickListener {
            //Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_SHORT).show()
            checkAnswer(true)
        }

        false_button.setOnClickListener {
           // val duration = Toast.LENGTH_LONG

            //val toast = Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_SHORT)
            //toast.setGravity(Gravity.TOP,0,0)
            //toast.show()
            checkAnswer(false)
        }

        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)

        nextButton.setOnClickListener {
            updateQuestion()
        }
        prevButton.setOnClickListener {
            backQuestion()
        }

        questionTextView.setOnClickListener{
            updateQuestion()
        }
        updateQuestion()

    }
    private fun updateQuestion() {
        currentIndex = (currentIndex + 1) % questionBank.size
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }
    private fun backQuestion() {
        currentIndex = abs(currentIndex - 1) % questionBank.size
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
    }
}
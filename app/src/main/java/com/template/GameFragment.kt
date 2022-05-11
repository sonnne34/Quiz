package com.template

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.template.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")

    private var mQuestionsList: ArrayList<DataQuestionModel>? = null
    private var mPosition: Int = 1
    private var countCorrectAnswers: Int = 0
    private var timer: CountDownTimer? = null

    private lateinit var questionTV: TextView
    private lateinit var answerOneTV: TextView
    private lateinit var answerTwoTV: TextView
    private lateinit var answerThreeTV: TextView
    private lateinit var answerFourTV: TextView
    private lateinit var timerTV: TextView
    private lateinit var btnNext: TextView
    private lateinit var icSmile: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mQuestionsList = DataQuestions.getDataQuestions()
        val question = mQuestionsList!![mPosition - 1]

        getBinding()
        defaultAnswersView()
        getDataAnswers(question)
        onClickAnswers()
    }

    private fun getBinding() {
        binding.apply {
            questionTV = tvQuestion
            answerOneTV = tvAnswer1
            answerTwoTV = tvAnswer2
            answerThreeTV = tvAnswer3
            answerFourTV = tvAnswer4
            btnNext = btnGoNext
            icSmile = icStatus
            timerTV = tvTimer
        }
    }

    private fun defaultAnswersView() {
        btnNext.isClickable = false
        btnNext.text = ""
        val answers = ArrayList<TextView>()
        answers.add(0, answerOneTV)
        answers.add(1, answerTwoTV)
        answers.add(2, answerThreeTV)
        answers.add(3, answerFourTV)

        for (answer in answers) {
            answer.setTextColor(Color.parseColor("#7A8089"))
            answer.typeface = Typeface.DEFAULT
            answer.setBackgroundResource(R.drawable.answer_bg)
            answer.setTextColor(Color.parseColor("#7A8089"))
        }
    }

    private fun getDataAnswers(question: DataQuestionModel) {
        startTimer()
        questionTV.text = question.question
        answerOneTV.text = question.answer1
        answerTwoTV.text = question.answer2
        answerThreeTV.text = question.answer3
        answerFourTV.text = question.answer4
        icSmile.setBackgroundResource(R.drawable.ic_question)
    }

    private fun onClickAnswers() {

        answerOneTV.setOnClickListener {
            selectedAnswer(1)
        }
        answerTwoTV.setOnClickListener {
            selectedAnswer(2)
        }
        answerThreeTV.setOnClickListener {
            selectedAnswer(3)
        }
        answerFourTV.setOnClickListener {
            selectedAnswer(4)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun btnNext() {
        timer?.cancel()
        btnNext.isClickable = true

        if (mPosition != mQuestionsList!!.size) {
            val question = mQuestionsList?.get(mPosition)
            btnNext.text = "NEXT"

            btnNext.setOnClickListener {
                clickable(true)
                defaultAnswersView()
                getDataAnswers(question!!)
                mPosition++
            }
        } else {
            btnNext.text = "FINISH"
            btnNext.setOnClickListener {
                findNavController().navigate(
                    GameFragmentDirections.actionGameFragmentToResultFragment(
                        countCorrectAnswers
                    )
                )
                mPosition = 1
                countCorrectAnswers = 0
            }
        }
    }

    private fun selectedAnswer(selectedNum: Int) {
        val question = mQuestionsList?.get(mPosition - 1)
        clickable(false)

        if (question!!.correctAnswer != selectedNum) {
            smile(R.drawable.ic_incorrect)
            answerView(selectedNum, R.drawable.answer_bg_wrong)
        } else {
            countCorrectAnswers++
            smile(R.drawable.ic_correct)
        }
        answerView(question.correctAnswer, R.drawable.answer_bg_correct)

        btnNext()
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                answerOneTV.setBackgroundResource(drawableView)
            }
            2 -> {
                answerTwoTV.setBackgroundResource(drawableView)
            }
            3 -> {
                answerThreeTV.setBackgroundResource(drawableView)
            }
            4 -> {
                answerFourTV.setBackgroundResource(drawableView)
            }
        }
    }

    private fun clickable(status: Boolean) {
        answerOneTV.isClickable = status
        answerTwoTV.isClickable = status
        answerThreeTV.isClickable = status
        answerFourTV.isClickable = status
    }

    private fun smile(drawableView: Int) {
        icSmile.setBackgroundResource(drawableView)
    }

    private fun startTimer() {
        timer = object : CountDownTimer(
            TIMES * MILLIS_IN_SECOND,
            MILLIS_IN_SECOND
        ) {
            override fun onTick(millisUntilFinished: Long) {
                timerTV.text = formatTime(millisUntilFinished)
            }

            override fun onFinish() {
                selectedAnswer(0)
                btnNext()
            }
        }
        timer?.start()
    }

    private fun formatTime(millisUntilFinished: Long): String {
        val seconds = millisUntilFinished / MILLIS_IN_SECOND
        val minutes = seconds / SECONDS_IN_MINUTES
        val leftSeconds = seconds - (minutes * SECONDS_IN_MINUTES)
        return String.format("%02d:%02d", minutes, leftSeconds)
    }

    companion object {
        private const val MILLIS_IN_SECOND = 1000L
        private const val SECONDS_IN_MINUTES = 60
        private const val TIMES = 10
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
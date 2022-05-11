package com.template

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.template.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding: FragmentResultBinding
        get() = _binding ?: throw RuntimeException("FragmentResultBinding == null")

    private val args by navArgs<ResultFragmentArgs>()

    private var avatar = 0
    private lateinit var sAvatarNumber: SharedPreferences

    private var nik = ""
    private lateinit var sNik: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getDataPerson()

        val count = args.count
        val scoreIncorrect = QUESTION_SIZE - count

        with(binding) {

            emojiResult.setBackgroundResource(icResult(count))

            tvScoreCorrectAnswers.text = String.format(
                getString(R.string.score_correct_answers),
                count
            )

            tvScoreIncorrect.text = String.format(
                getString(R.string.score_incorrect),
                scoreIncorrect
            )

            buttonRetry.setOnClickListener {
                retryGame()
            }

            buttonGoMenu.setOnClickListener {
                findNavController().navigate(R.id.action_resultFragment_to_menuFragment)
            }
        }
    }

    private fun getDataPerson() {
        if (getSharedPreferenceAvatar() != 0) {
            avatar = getSharedPreferenceAvatar()
            val avatarDrawable = imgAvatar(avatar)
            binding.imgAvatarResult.setBackgroundResource(avatarDrawable)
        } else {
            binding.imgAvatarResult.setBackgroundResource(R.drawable.avatar_3)
        }

        if (getSharedPreferenceNik() != "") {
            nik = getSharedPreferenceNik()
            binding.tvNikResult.text = nik
        } else {
            binding.tvNikResult.text = getString(R.string.nickname)
        }
    }

    private fun imgAvatar(avatarDraw: Int): Int {
        return when (avatarDraw) {
            1 -> R.drawable.avatar_1
            2 -> R.drawable.avatar_2
            3 -> R.drawable.avatar_3
            4 -> R.drawable.avatar_4
            5 -> R.drawable.avatar_5
            6 -> R.drawable.avatar_6
            7 -> R.drawable.avatar_7
            8 -> R.drawable.avatar_8
            9 -> R.drawable.avatar_9
            else -> R.drawable.avatar_3
        }
    }

    private fun icResult(count: Int): Int {
        return if (count <= (QUESTION_SIZE / 2)) {
            R.drawable.ic_lose
        } else {
            R.drawable.ic_victory
        }
    }

    private fun getSharedPreferenceNik(): String {
        sNik = this.requireActivity().getPreferences(AppCompatActivity.MODE_PRIVATE)
        return sNik.getString(ProfileFragment.APP_PREFERENCE_NIK, "").toString()
    }

    private fun getSharedPreferenceAvatar(): Int {
        sAvatarNumber = this.requireActivity().getPreferences(AppCompatActivity.MODE_PRIVATE)
        return sAvatarNumber.getInt(ProfileFragment.APP_PREFERENCE_AVATAR, 0)
    }

    private fun retryGame() {
        findNavController().popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val QUESTION_SIZE = 10
    }
}
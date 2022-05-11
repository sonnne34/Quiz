package com.template

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.template.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding: FragmentProfileBinding
        get() = _binding ?: throw RuntimeException("FragmentProfileBinding == null")

    private var avatar = 0
    private lateinit var sAvatarNumber: SharedPreferences
    private lateinit var sNik: SharedPreferences

    private lateinit var avatarOne: ImageButton
    private lateinit var avatarTwo: ImageButton
    private lateinit var avatarThree: ImageButton
    private lateinit var avatarFour: ImageButton
    private lateinit var avatarFive: ImageButton
    private lateinit var avatarSix: ImageButton
    private lateinit var avatarSeven: ImageButton
    private lateinit var avatarEight: ImageButton
    private lateinit var avatarNine: ImageButton
    private lateinit var etNik: EditText
    private lateinit var btnOk: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding()
        getDataPerson()
        btnOkOnClickListener()
        avatarsOnClickListeners()
    }

    private fun binding() {
        with(binding) {
            avatarOne = avatar1
            avatarTwo = avatar2
            avatarThree = avatar3
            avatarFour = avatar4
            avatarFive = avatar5
            avatarSix = avatar6
            avatarSeven = avatar7
            avatarEight = avatar8
            avatarNine = avatar9
            etNik = etNickname
            btnOk = btnEtOk
        }
    }

    private fun getDataPerson() {
        if (getSharedPreferenceNik() != "") {
            etNik.setText(getSharedPreferenceNik())
        }

        if (getSharedPreferenceAvatar() != 0) {
            avatar = getSharedPreferenceAvatar()
            defaultAvatarsView()
            backgroundSelectedAvatar(imgAvatar(avatar))
        }
    }

    private fun btnOkOnClickListener() {
        btnOk.setOnClickListener {
            etNik.hideKeyboard()
            saveSharedPreferenceAvatar(avatar)
            saveSharedPreferenceNik()
            findNavController().popBackStack()
        }
    }


    private fun avatarsOnClickListeners() {
        avatarOne.setOnClickListener {
            avatar = 1
            defaultAvatarsView()
            backgroundSelectedAvatar(avatarOne)
        }

        avatarTwo.setOnClickListener {
            avatar = 2
            defaultAvatarsView()
            backgroundSelectedAvatar(avatarTwo)
        }

        avatarThree.setOnClickListener {
            avatar = 3
            defaultAvatarsView()
            backgroundSelectedAvatar(avatarThree)
        }

        avatarFour.setOnClickListener {
            avatar = 4
            defaultAvatarsView()
            backgroundSelectedAvatar(avatarFour)
        }

        avatarFive.setOnClickListener {
            avatar = 5
            defaultAvatarsView()
            backgroundSelectedAvatar(avatarFive)
        }

        avatarSix.setOnClickListener {
            avatar = 6
            defaultAvatarsView()
            backgroundSelectedAvatar(avatarSix)
        }

        avatarSeven.setOnClickListener {
            avatar = 7
            defaultAvatarsView()
            backgroundSelectedAvatar(avatarSeven)
        }

        avatarEight.setOnClickListener {
            avatar = 8
            defaultAvatarsView()
            backgroundSelectedAvatar(avatarEight)
        }

        avatarNine.setOnClickListener {
            avatar = 9
            defaultAvatarsView()
            backgroundSelectedAvatar(avatarNine)
        }
    }

    private fun defaultAvatarsView() {
        val avatars = ArrayList<ImageButton>()
        avatars.add(0, avatarOne)
        avatars.add(1, avatarTwo)
        avatars.add(2, avatarThree)
        avatars.add(3, avatarFour)
        avatars.add(4, avatarFive)
        avatars.add(5, avatarSix)
        avatars.add(6, avatarSeven)
        avatars.add(7, avatarEight)
        avatars.add(8, avatarNine)

        for (avatar in avatars) {
            avatar.setBackgroundResource(R.drawable.shape_white)
        }
    }

    private fun imgAvatar(avatarDraw: Int): ImageButton {
        return when (avatarDraw) {
            1 -> avatarOne
            2 -> avatarTwo
            3 -> avatarThree
            4 -> avatarFour
            5 -> avatarFive
            6 -> avatarSix
            7 -> avatarSeven
            8 -> avatarEight
            9 -> avatarNine
            else -> avatarThree
        }
    }

    private fun getSharedPreferenceNik(): String {
        sNik = this.requireActivity().getPreferences(AppCompatActivity.MODE_PRIVATE)
        return sNik.getString(APP_PREFERENCE_NIK, "").toString()
    }

    private fun getSharedPreferenceAvatar(): Int {
        sAvatarNumber = this.requireActivity().getPreferences(AppCompatActivity.MODE_PRIVATE)
        return sAvatarNumber.getInt(APP_PREFERENCE_AVATAR, 0)
    }

    private fun saveSharedPreferenceNik() {
        val nik = etNik.text.toString()
        sNik = this.requireActivity().getPreferences(AppCompatActivity.MODE_PRIVATE)
        val sNikName: SharedPreferences.Editor = sNik.edit()
        sNikName.putString(APP_PREFERENCE_NIK, nik).toString()
        sNikName.apply()
    }

    private fun saveSharedPreferenceAvatar(av: Int) {
        sAvatarNumber = this.requireActivity().getPreferences(AppCompatActivity.MODE_PRIVATE)
        val avatarN: SharedPreferences.Editor = sAvatarNumber.edit()
        avatarN.putInt(APP_PREFERENCE_AVATAR, av)
        avatarN.apply()
    }

    private fun backgroundSelectedAvatar(av: ImageButton) {
        av.setBackgroundResource(R.drawable.shape_selected)
    }

    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val APP_PREFERENCE_AVATAR = "avatar"
        const val APP_PREFERENCE_NIK = "nik"
    }
}
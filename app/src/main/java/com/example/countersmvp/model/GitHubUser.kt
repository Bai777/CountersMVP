package com.example.countersmvp.model

import android.os.Parcelable
import com.example.countersmvp.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitHubUser(
    private val login: String = R.id.et_login.toString(),
    private val password: String = R.id.et_password.toString()
): Parcelable


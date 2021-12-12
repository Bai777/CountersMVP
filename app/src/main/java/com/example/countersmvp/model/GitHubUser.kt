package com.example.countersmvp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitHubUser(
    val login: String,
    val password: String
): Parcelable


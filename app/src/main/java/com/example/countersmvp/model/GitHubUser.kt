package com.example.countersmvp.model

import android.os.Parcelable
import com.example.countersmvp.databinding.FragmentUsersBinding
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitHubUser(
    val login: String,
    val password: String
): Parcelable


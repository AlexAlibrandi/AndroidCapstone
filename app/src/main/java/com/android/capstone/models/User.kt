package com.android.capstone.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class User(
    val id: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val results: @RawValue ArrayList<ResultsModel>? = ArrayList()

): Parcelable



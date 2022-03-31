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
<<<<<<< HEAD
    val results: @RawValue ArrayList<ResultsModel>? = ArrayList()

=======
    val results: @RawValue ArrayList<ResultsModel> = ArrayList()
>>>>>>> f2dcfa988c2e8be128298714f78c563b50e269f6

): Parcelable



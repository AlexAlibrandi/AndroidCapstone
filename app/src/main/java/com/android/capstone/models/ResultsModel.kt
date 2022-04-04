package com.android.capstone.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime

@Parcelize
data class ResultsModel(

    val title: String = "",
    val confidence: Float,
    val id: String = "",
    val date: String = ""

    ) : Parcelable

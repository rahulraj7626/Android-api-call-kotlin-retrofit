package com.example.apicall

import com.google.gson.annotations.SerializedName

data class DemoDataModelItem(
    @SerializedName("body")
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)
package com.joh.criminalintent

import java.util.*

data class Crime(
    var id: UUID = UUID.randomUUID(),
    var title: String? = null,
    var data: Date = Date(),
    var solved: Boolean = false
)
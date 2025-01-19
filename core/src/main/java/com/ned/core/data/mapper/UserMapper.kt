package com.ned.core.data.mapper

import com.ned.core.data.source.response.DataItem
import com.ned.core.domain.model.User

fun DataItem.toDomain(): User = User(
    id = id,
    firstName = firstName,
    lastName = lastName,
    email = email,
    avatar = avatar
)
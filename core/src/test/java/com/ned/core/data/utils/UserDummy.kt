package com.ned.core.data.utils

import com.ned.core.data.source.response.DataItem
import com.ned.core.data.source.response.Support
import com.ned.core.data.source.response.UsersResponse

object DummyData {
    fun generateDummyDataItems(count: Int = 10): List<DataItem> {
        return (1..count).map { id ->
            DataItem(
                lastName = "Doe$id",
                id = id,
                avatar = "https://example.com/avatar$id.jpg",
                firstName = "John$id",
                email = "john.doe$id@example.com"
            )
        }
    }

    fun generateDummyUsersResponse(
        page: Int = 1,
        perPage: Int = 10,
        totalPages: Int = 2
    ): UsersResponse {
        return UsersResponse(
            perPage = perPage,
            total = totalPages * perPage,
            data = generateDummyDataItems(perPage),
            page = page,
            totalPages = totalPages,
            support = Support(
                url = "https://example.com/support",
                text = "Support text"
            )
        )
    }
}
package com.androidmess.helix.discover.model.repository

import com.androidmess.helix.BaseTest
import com.androidmess.helix.common.network.NetworkConfig
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import retrofit2.Retrofit

class RetrofitDiscoverRepositoryTest : BaseTest() {

    companion object {
        const val TEST_API_KEY = "test_api_key1234"
    }

    val retrofitService = mock<RetrofitDiscoverService>()
    val retrofit = mock<Retrofit> {
        on { create(RetrofitDiscoverService::class.java) } doReturn retrofitService
    }
    val networkConfig = mock<NetworkConfig> {
        on { apiKey } doReturn TEST_API_KEY
    }

    val repository = RetrofitDiscoverRepository(retrofit, networkConfig)

    @Test
    fun `When discover movies request called should use page with given api key`() {
        val testPage = 1

        repository.discoverMovies(testPage)

        verify(retrofitService).discoverMovies(TEST_API_KEY, testPage)
    }
}

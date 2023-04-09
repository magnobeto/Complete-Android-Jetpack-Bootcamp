package com.example.appnews.data.api

import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldNotBe
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsAPIServiceTest {

    private lateinit var service: NewsAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun `GIVEN a correct parameters WHEN sent a request to service THEN check if the request and response is correct`() {
        runBlocking {
            enqueueMockResponse(MOCK_RESPONSE_FILE_NAME)
            val responseBody =
                service.getTopHeadlines(MOCK_COUNTRY_QUERY_PARAMETER, MOCK_PAGE_QUERY_PARAMETER)
                    .body()
            val request = server.takeRequest()
            responseBody shouldNotBe null
            request.path shouldBeEqualTo MOCK_REQUEST_URL_PARAMETER
        }
    }

    @Test
    fun `GIVEN a correct parameters WHEN sent a request to service THEN check if received correct pagesize`() {
        runBlocking {
            enqueueMockResponse(MOCK_RESPONSE_FILE_NAME)
            val responseBody =
                service.getTopHeadlines(MOCK_COUNTRY_QUERY_PARAMETER, MOCK_PAGE_QUERY_PARAMETER)
                    .body()
            val articleList = responseBody!!.articles
            articleList.size shouldBeEqualTo MOCK_PAGE_SIZE_COUNT
        }
    }

    fun enqueueMockResponse(fileName: String) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    companion object {
        private const val MOCK_REQUEST_URL_PARAMETER =
            "/v2/top-headlines?country=us&page=1&apiKey=ff099fc070bb4d70bb279d3cade0034c"
        private const val MOCK_RESPONSE_FILE_NAME = "newsresponse.json"
        private const val MOCK_COUNTRY_QUERY_PARAMETER = "us"
        private const val MOCK_PAGE_QUERY_PARAMETER = 1
        private const val MOCK_PAGE_SIZE_COUNT = 20
    }
}
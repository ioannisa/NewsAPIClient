package eu.anifantakis.newsapiclient.data.api

import eu.anifantakis.newsapiclient.BuildConfig
import eu.anifantakis.newsapiclient.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * API to define functions to get data from the newsapi.org
 * with url endpoints and query parameters
 */

interface NewsAPIService {

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country")   country:    String,
        @Query("page")      page:       Int,
        @Query("apiKey")    apiKey:     String = BuildConfig.API_KEY
    ): Response<APIResponse>

}
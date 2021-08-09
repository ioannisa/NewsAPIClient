package eu.anifantakis.newsapiclient.data.repository

import eu.anifantakis.newsapiclient.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(): Response<APIResponse>
}
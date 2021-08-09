package eu.anifantakis.newsapiclient.data.repository

import eu.anifantakis.newsapiclient.data.api.NewsAPIService
import eu.anifantakis.newsapiclient.data.model.APIResponse
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
        private val country: String,
        private val page: Int)
    : NewsRemoteDataSource {

    override suspend fun getTopHeadlines(): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country, page)
    }
}
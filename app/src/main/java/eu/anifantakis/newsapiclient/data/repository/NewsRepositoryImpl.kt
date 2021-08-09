package eu.anifantakis.newsapiclient.data.repository

import eu.anifantakis.newsapiclient.data.model.APIResponse
import eu.anifantakis.newsapiclient.data.model.Article
import eu.anifantakis.newsapiclient.data.util.Resource
import eu.anifantakis.newsapiclient.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource
): NewsRepository {

    /**
     * Transform the Response from Retrofit to a Resource as the custom Resource object defined
     * at the data.util package of this application
     */
    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse>{
        if (response.isSuccessful){
            response.body()?.let { apiResponse ->
                return Resource.Success(apiResponse)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun getNewsHeadlines(): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines())
    }

    override suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNewsArticle(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSavedNewsArticle(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNewsArticles(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}
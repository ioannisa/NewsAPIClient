package eu.anifantakis.newsapiclient.domain.repository

import eu.anifantakis.newsapiclient.data.model.APIResponse
import eu.anifantakis.newsapiclient.data.model.Article
import eu.anifantakis.newsapiclient.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNewsHeadlines(): Resource<APIResponse>
    suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse>
    suspend fun saveNewsArticle(article: Article)
    suspend fun deleteSavedNewsArticle(article: Article)
    fun getSavedNewsArticles(): Flow<List<Article>>
}
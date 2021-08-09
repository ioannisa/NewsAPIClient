package eu.anifantakis.newsapiclient.domain.usecase

import eu.anifantakis.newsapiclient.data.model.APIResponse
import eu.anifantakis.newsapiclient.data.model.Article
import eu.anifantakis.newsapiclient.data.util.Resource
import eu.anifantakis.newsapiclient.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(): Resource<APIResponse>{
        return newsRepository.getNewsHeadlines()
    }
}

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(searchQuery: String): Resource<APIResponse>{
        return newsRepository.getSearchedNews(searchQuery)
    }
}

class SaveNewsArticleUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article){
        return newsRepository.saveNewsArticle(article)
    }
}

class DeleteSavedNewsArticleUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article){
        return newsRepository.deleteSavedNewsArticle(article)
    }
}

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    // Flow represents background job, don't need suspend coroutines functions
    fun execute(): Flow<List<Article>>{
        return newsRepository.getSavedNewsArticles()
    }
}




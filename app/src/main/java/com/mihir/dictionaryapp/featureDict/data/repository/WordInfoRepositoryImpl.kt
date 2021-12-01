package com.mihir.dictionaryapp.featureDict.data.repository

import com.mihir.dictionaryapp.core.util.Resource
import com.mihir.dictionaryapp.featureDict.data.local.WordInfoDao
import com.mihir.dictionaryapp.featureDict.data.remote.DictionaryApi
import com.mihir.dictionaryapp.featureDict.domain.model.WordInfo
import com.mihir.dictionaryapp.featureDict.domain.repo.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api:DictionaryApi,
    private val dao:WordInfoDao
):WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfos = dao.getWordsInfo(word).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfos))

        try {
            val remoteWordInfos = api.getWordInfo(word)
            dao.deleteWordInfos(remoteWordInfos.map { it.word })
            dao.insertWordInfos(remoteWordInfos.map { it.toWordInfo() })
        }catch (e:HttpException){
            emit(Resource.Error(message = "opps something went wrong",data = wordInfos))
        }catch (e:IOException){
            emit(Resource.Error(message = "couldnot reach server, check connection",data = wordInfos))
        }

        val newWordInfos = dao.getWordsInfo(word = word).map { it.toWordInfo() }

        emit(Resource.Success(newWordInfos))
    }
}
package com.mihir.dictionaryapp.featureDict.domain.repo

import com.mihir.dictionaryapp.core.util.Resource
import com.mihir.dictionaryapp.featureDict.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word:String): Flow<Resource<List<WordInfo>>>
}
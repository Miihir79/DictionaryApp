package com.mihir.dictionaryapp.featureDict.domain.use_cases

import com.mihir.dictionaryapp.core.util.Resource
import com.mihir.dictionaryapp.featureDict.domain.model.WordInfo
import com.mihir.dictionaryapp.featureDict.domain.repo.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: WordInfoRepository
) {
    operator fun invoke(word:String): Flow<Resource<List<WordInfo>>> {
        if(word.isBlank()){
            return flow{}
        }
        return repository.getWordInfo(word)
    }
}
package com.mihir.dictionaryapp.featureDict.data.remote.dto

import com.mihir.dictionaryapp.featureDict.data.local.entity.WordInfoEntity
import com.mihir.dictionaryapp.featureDict.domain.model.WordInfo

data class WordInfoDTO(
    val meanings: List<MeaningDto>,
    val origin: String?,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val word: String
){
    fun toWordInfo():WordInfoEntity{
        return WordInfoEntity(
            meaning = meanings.map { it.toMeaning() },
            origin = origin,
            phonetic = phonetic,
            word = word
        )
    }

}
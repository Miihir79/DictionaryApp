package com.mihir.dictionaryapp.featureDict.data.remote.dto

import com.mihir.dictionaryapp.featureDict.domain.model.WordInfo

data class WordInfoDTO(
    val meanings: List<MeaningDto>,
    val origin: String,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val word: String
){
    fun toWordInfo():WordInfo{
        return WordInfo(
            meanings = meanings.map { it.toMeaning() },
            origin = origin,
            phonetic = phonetic,
            word = word
        )
    }
}
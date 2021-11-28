package com.mihir.dictionaryapp.featureDict.data.remote.dto

import com.mihir.dictionaryapp.featureDict.domain.model.Meaning

data class MeaningDto(
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String
){
    fun toMeaning():Meaning{
        return Meaning(
            defination = definitions.map { it.toDefinition() },
            partOfSpeech = partOfSpeech
        )
    }
}
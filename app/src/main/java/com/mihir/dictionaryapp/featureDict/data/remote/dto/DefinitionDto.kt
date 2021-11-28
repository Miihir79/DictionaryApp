package com.mihir.dictionaryapp.featureDict.data.remote.dto

import com.mihir.dictionaryapp.featureDict.domain.model.Defination

data class DefinitionDto(
    val antonyms: List<String>,
    val definition: String,
    val example:String?,
    val synonyms: List<String>
){
    fun toDefinition():Defination{
        return Defination(antonyms = antonyms,
        definition = definition,
        example = example,
        synonyms = synonyms)
    }
}
package com.mihir.dictionaryapp.featureDict.presentation

import com.mihir.dictionaryapp.featureDict.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading:Boolean = false
)

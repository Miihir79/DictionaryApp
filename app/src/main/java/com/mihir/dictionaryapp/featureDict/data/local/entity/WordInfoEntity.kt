package com.mihir.dictionaryapp.featureDict.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mihir.dictionaryapp.featureDict.domain.model.Meaning
import com.mihir.dictionaryapp.featureDict.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic:String,
    val origin:String,
    val meaning:List<Meaning>,
    @PrimaryKey val id: Int?=null
){
    fun toWordInfo():WordInfo{
        return WordInfo(
            meanings = meaning,
            word = word,
            origin = origin,
            phonetic = phonetic
        )
    }
}

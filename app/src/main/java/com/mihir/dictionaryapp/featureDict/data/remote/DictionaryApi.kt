package com.mihir.dictionaryapp.featureDict.data.remote

import com.mihir.dictionaryapp.featureDict.data.remote.dto.WordInfoDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {

    @GET("/api/v2/entries/en/{word}")
    suspend fun getWordInfo(
        @Path("word") word:String
    ):List<WordInfoDTO> // since multiple meanings of a single word can exist
}
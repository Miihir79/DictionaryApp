package com.mihir.dictionaryapp.featureDict.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.mihir.dictionaryapp.featureDict.data.util.JsonParser
import com.mihir.dictionaryapp.featureDict.domain.model.Meaning

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMeaningsJson(json:String):List<Meaning>{
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object :TypeToken<ArrayList<Meaning>>(){}.type
        )?: emptyList()
    }

    @TypeConverter
    fun toMeaningsJson(meaning: List<Meaning>):String{
        return jsonParser.toJson(
            meaning,
            object :TypeToken<ArrayList<Meaning>>(){}.type
        )?: "[]"
    }
}
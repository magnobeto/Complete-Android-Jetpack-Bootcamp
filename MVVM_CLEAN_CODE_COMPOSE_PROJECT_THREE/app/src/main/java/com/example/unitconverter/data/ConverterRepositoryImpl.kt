package com.example.unitconverter.data

import com.example.unitconverter.data.ConversionResult
import com.example.unitconverter.data.ConverterDAO
import com.example.unitconverter.data.ConverterRepository
import kotlinx.coroutines.flow.Flow

class ConverterRepositoryImpl(private val dao : ConverterDAO) : ConverterRepository {

    override suspend fun insertResult(result: ConversionResult) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteResult(result: ConversionResult) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllResults() {
        TODO("Not yet implemented")
    }

    override fun getSavedResults(): Flow<List<ConversionResult>> {
        TODO("Not yet implemented")
    }
}
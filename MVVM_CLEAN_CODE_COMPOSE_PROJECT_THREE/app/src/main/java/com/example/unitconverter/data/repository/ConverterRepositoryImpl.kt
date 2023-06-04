package com.example.unitconverter.data.repository

import com.example.unitconverter.data.db.ConverterDAO
import com.example.unitconverter.data.model.ConversionResult
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
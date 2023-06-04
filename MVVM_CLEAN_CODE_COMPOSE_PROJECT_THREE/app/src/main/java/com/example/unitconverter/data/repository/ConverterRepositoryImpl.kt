package com.example.unitconverter.data.repository

import com.example.unitconverter.data.db.ConverterDAO
import com.example.unitconverter.data.model.ConversionResult
import kotlinx.coroutines.flow.Flow

class ConverterRepositoryImpl(private val dao : ConverterDAO) : ConverterRepository {

    override suspend fun insertResult(result: ConversionResult) = dao.insertResult(result)

    override suspend fun deleteResult(result: ConversionResult) = dao.deleteResult(result)

    override suspend fun deleteAllResults() = dao.deleteAll()

    override fun getSavedResults(): Flow<List<ConversionResult>> = dao.getResults()
}
package com.example.unitconverter.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.unitconverter.data.model.ConversionResult

@Database(entities = [ConversionResult::class],version = 1)
abstract class ConverterDatabase : RoomDatabase() {
    abstract fun converterDAO() : ConverterDAO
}

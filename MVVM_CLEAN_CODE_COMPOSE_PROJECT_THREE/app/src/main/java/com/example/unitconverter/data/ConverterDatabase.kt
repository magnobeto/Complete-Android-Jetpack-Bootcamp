package com.example.unitconverter.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ConversionResult::class],version = 1)
abstract class ConverterDatabase : RoomDatabase() {
    abstract fun converterDAO() : ConverterDAO
}

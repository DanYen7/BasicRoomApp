package com.example.basicroomapp.database

import androidx.room.*
import java.util.*

@Dao
interface UserDao {
    @Query("SELECT * FROM $TABLE_USERS")
    fun getUsersFromDatabase(): List<UserEntity>

    @Query("SELECT * FROM $TABLE_USERS WHERE user_id = :uuid")
    fun getUsersByUuid(uuid: String): UserEntity

    @Delete
    fun delete(user:UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(user: UserEntity)
}
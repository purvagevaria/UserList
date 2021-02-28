package com.app.assignment.dbclasses.daoclasses

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.purvaassignment.dbclasses.enitity.UserEntity

@Dao
interface DAOUser {


    @Query("SELECT * FROM user")
    fun getAllUserData(): List<UserEntity>

    @Query("SELECT * FROM user where user_name=:userName")
    fun getSingleUser(userName: String): UserEntity

    @Query("UPDATE user set action_status=:actionStatus where user_name=:userName")
    fun updateUserStatus(actionStatus: Int, userName: String)

    @Insert
    fun insertAll(productData: UserEntity)

    @Query("DELETE FROM user")
    fun truncateArtist()

}
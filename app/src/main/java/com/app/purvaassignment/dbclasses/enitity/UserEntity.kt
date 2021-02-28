package com.app.purvaassignment.dbclasses.enitity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
class UserEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "user_name")
    var userName: String = ""

    @ColumnInfo(name = "server_user_id")
    var serverUserId: String = ""

    @ColumnInfo(name = "age")
    var age: Int = 0

    @ColumnInfo(name = "location")
    var location: String = ""

    @ColumnInfo(name = "image")
    var image: String = ""

    @ColumnInfo(name = "action_status")
    var actionStatus = 0

    @ColumnInfo(name = "gender")
    var gender = 0

}
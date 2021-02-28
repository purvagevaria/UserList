package com.app.purvaassignment.responsebean.user

data class UserResponse(
    val name: NameBean? = null,
    val location: LocationBean? = null,
    val dob: DobBean? = null,
    val phone: String = "",
    var cell: String = "",
    val picture: PictureBean? = null,
    val gender: String = "",
    val login: LoginBean? = null
)
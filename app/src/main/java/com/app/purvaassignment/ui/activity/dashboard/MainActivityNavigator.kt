package com.app.purvaassignment.ui.activity.dashboard

import com.app.purvaassignment.dbclasses.enitity.UserEntity
import com.app.purvaassignment.ui.base.BaseNavigator

interface MainActivityNavigator : BaseNavigator {


    fun onDataLoad(filterData: ArrayList<UserEntity>)

    fun onUpdateUserData(userData: UserEntity)


}
package com.app.purvaassignment.ui.activity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.purvaassignment.databinding.RowUserBinding
import com.app.purvaassignment.dbclasses.enitity.UserEntity
import com.app.purvaassignment.ui.activity.dashboard.MainViewModel


class UserAdapter(
    private val userList: ArrayList<UserEntity>,
    viewModel: MainViewModel
) :
    RecyclerView.Adapter<UserAdapter.UserHolder>() {

    var mainViewModel = viewModel

    init {
        this.mainViewModel = viewModel
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val itemBinding =
            RowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        itemBinding.viewModel = mainViewModel
        return UserHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val userBean: UserEntity = userList[position]

        holder.bind(userBean)
    }

    override fun getItemCount(): Int = userList.size

    fun changeData(userData: UserEntity) {
        val findData = userList.find { it.userName.equals(userData.userName, true) }
        val indexOf = userList.indexOf(findData)
        userList[indexOf] = userData
        notifyItemChanged(indexOf)
    }

    class UserHolder(private val itemBinding: RowUserBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(userBean: UserEntity) {
            itemBinding.position = adapterPosition
            itemBinding.beanData = userBean
        }
    }

}
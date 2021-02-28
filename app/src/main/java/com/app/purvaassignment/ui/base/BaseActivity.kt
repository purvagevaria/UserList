package com.app.purvaassignment.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding


abstract class BaseActivity<VM : ViewModel, VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var mViewModelProvider: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getBindingObject()
    }

    protected lateinit var binding: VB
    abstract fun getViewModel(): VM

    protected val mViewModel by lazy {
        getViewModel()
    }

    abstract fun getBindingObject(): VB
}
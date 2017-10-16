package com.ansgar.kotlinweatherapp.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

/**
 * Created by kirill on 2.10.17.
 */
fun AppCompatActivity.closeFragment(containerId: Int) {
    val manager: FragmentManager = supportFragmentManager;
    val transaction: FragmentTransaction = manager.beginTransaction()
    val currentFragment: Fragment = supportFragmentManager.findFragmentById(containerId)
    transaction.remove(currentFragment)
    transaction.commit()
    manager.popBackStack()
}

fun AppCompatActivity.replaceFragment(containerId: Int, fragment: Fragment, tag: String, addToBackStack: Boolean) {
    val manager: FragmentManager = supportFragmentManager
    val transaction: FragmentTransaction = manager.beginTransaction()
    transaction.replace(containerId, fragment, tag)
    if (addToBackStack) transaction.addToBackStack(null)
    transaction.commit()
}

package com.example.academynotesapp.appdata

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val getAll:LiveData<List<User>> = userDao.getAll()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}
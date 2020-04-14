package com.example.app.entity

data class User constructor(var username:String?, var password:String?, var code:String?) {
    constructor():this(null, null, null)
}

fun main() {
    val user = User("john", "123456", "Java")
    val userCopy = user.copy()
    println(user)
    println(userCopy)
    println(user == userCopy)//equals
    println(user === userCopy) //not same object
}
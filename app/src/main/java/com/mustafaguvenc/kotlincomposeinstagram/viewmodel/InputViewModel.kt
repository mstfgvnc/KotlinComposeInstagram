package com.mustafaguvenc.kotlincomposeinstagram.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class InputViewModel(): ViewModel()  {

    lateinit var auth : FirebaseAuth
    var currentUser : FirebaseUser? = null

    fun init(){
        auth = Firebase.auth
        currentUser = auth.currentUser
    }
}
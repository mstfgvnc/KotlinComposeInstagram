package com.mustafaguvenc.kotlincomposeinstagram.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class InputViewModel(): ViewModel()  {

    private lateinit var auth : FirebaseAuth

    fun init(){
        auth = Firebase.auth
    }
}
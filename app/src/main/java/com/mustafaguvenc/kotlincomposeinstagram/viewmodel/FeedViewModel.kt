package com.mustafaguvenc.kotlincomposeinstagram.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mustafaguvenc.kotlincomposeinstagram.repository.PostDownload
import com.mustafaguvenc.kotlincomposeinstagram.util.Resource
import com.mustafaguvenc.kotlincomposeinstagram.util.Status

class FeedViewModel(
   // private val postDownloadRepository : PostDownload
): ViewModel() {
    lateinit var auth : FirebaseAuth

    var postList = mutableStateOf<List<String>>(listOf()) // String sonra değişecek
    var postError = mutableStateOf("")
    var postLoading = mutableStateOf(false)
    fun init(){
        auth = Firebase.auth
    }

}
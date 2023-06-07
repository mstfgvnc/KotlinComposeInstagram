package com.mustafaguvenc.kotlincomposeinstagram.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mustafaguvenc.kotlincomposeinstagram.repository.PostDownload
import com.mustafaguvenc.kotlincomposeinstagram.util.Resource
import com.mustafaguvenc.kotlincomposeinstagram.util.Status

class FeedViewModel(
   // private val postDownloadRepository : PostDownload
): ViewModel() {

    var postList = mutableStateOf<List<String>>(listOf()) // String sonra değişecek
    var postError = mutableStateOf("")
    var postLoading = mutableStateOf(false)

}
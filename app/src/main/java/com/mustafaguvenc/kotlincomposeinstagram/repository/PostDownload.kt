package com.mustafaguvenc.kotlincomposeinstagram.repository

import com.mustafaguvenc.kotlincomposeinstagram.model.Post
import com.mustafaguvenc.kotlincomposeinstagram.util.Resource

interface PostDownload {
    suspend fun downloadPosts() : Resource<List<Post>>
}
package com.mustafaguvenc.kotlincomposeinstagram.repository

import com.mustafaguvenc.kotlincomposeinstagram.model.Post
import com.mustafaguvenc.kotlincomposeinstagram.service.PostAPI
import com.mustafaguvenc.kotlincomposeinstagram.util.Resource

class PostDownloadImpl(private val api :PostAPI) : PostDownload {
    /*
    override suspend fun downloadCryptos() : Resource<List<Post>> {
        return try {

            val response = api.getData()
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error",null)
            } else {
                Resource.error("Error",null)
            }


        } catch (e: Exception) {
            Resource.error("No data!",null)
        }
    }

     */
    override suspend fun downloadPosts(): Resource<List<Post>> {
        TODO("Not yet implemented")
    }

}
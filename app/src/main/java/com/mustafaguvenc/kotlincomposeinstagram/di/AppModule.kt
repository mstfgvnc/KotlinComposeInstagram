package com.mustafaguvenc.kotlincomposeinstagram.di

import com.mustafaguvenc.kotlincomposeinstagram.viewmodel.FeedViewModel
import com.mustafaguvenc.kotlincomposeinstagram.viewmodel.InputViewModel
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.scope.get
import org.koin.dsl.module

val appModule = module {

 //  viewModelOf(::FeedViewModel)
   viewModel {
    //  FeedViewModel()
      InputViewModel()
   }



}
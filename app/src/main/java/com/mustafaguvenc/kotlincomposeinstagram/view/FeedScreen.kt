package com.mustafaguvenc.kotlincomposeinstagram.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mustafaguvenc.kotlincomposeinstagram.R
import com.mustafaguvenc.kotlincomposeinstagram.viewmodel.FeedViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.compose.navigation.koinNavViewModel
import org.koin.androidx.compose.viewModel

@Composable
fun FeedScreen(
    navController: NavController,
){
    Surface(
        color = MaterialTheme.colors.secondary,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            PostList(navController = navController)
        }
    }
}

@Composable
fun PostList(navController: NavController,
             viewModel: FeedViewModel = koinViewModel()
) {

    val postList = remember { viewModel.postList }
    val errorMessage = remember { viewModel.postError }
    val isLoading = remember { viewModel.postLoading }

  //  postList.value?.data?.let { PostListView(posts = it, navController = navController) }

    postList.value.let { PostListView(posts = it, navController = navController) }

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
        if(isLoading.value){
            CircularProgressIndicator(color = MaterialTheme.colors.primary)
        }
        if(errorMessage.value.isNotEmpty()){

                RetyryView(error = errorMessage.value) {
                //    viewModel.loadPost()
                }

        }
    }

}


@Composable
fun PostListView(posts:List<String>,navController: NavController) {
    LazyColumn(contentPadding = PaddingValues(5.dp)){
        items(posts){post ->
            PostRow(navController = navController, post = post)
        }
    }
}

@Composable
fun PostRow(navController: NavController, post : String) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colors.secondary)
            /*
        .clickable {
            navController.navigate("crypto_detail_screen/${crypto.currency}/${crypto.price}")
        }

             */
    ) {
        Text(text = "User Email")
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "")
        Text(text = "Comment")
    }

}

@Composable
fun RetyryView(
    error:String,
    onRetry: () -> Unit
) {
    Column() {
        Text(error, color = Color.Red, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            onRetry
        }, modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Retry")
        }
    }
}


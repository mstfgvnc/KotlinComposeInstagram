package com.mustafaguvenc.kotlincomposeinstagram

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mustafaguvenc.kotlincomposeinstagram.ui.theme.KotlinComposeInstagramTheme
import com.mustafaguvenc.kotlincomposeinstagram.view.FeedScreen
import com.mustafaguvenc.kotlincomposeinstagram.view.InputScreen
import com.mustafaguvenc.kotlincomposeinstagram.view.UploadScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

         //   OptionMenu()
            KotlinComposeInstagramTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "user_input_screen"){
                    composable("user_input_screen"){
                        InputScreen(navController = navController)
                    }
                    composable("feed_screen"){
                        // sadece recylerview var
                        FeedScreen(navController = navController)
                    }
                    composable("upload_screen"){
                        UploadScreen(navController = navController)
                    }

/*
                    composable("crypto_detail_screen/{cryptoId}/{cryptoPrice}", arguments = listOf(
                        navArgument("cryptoId"){
                            type = NavType.StringType
                        },
                        navArgument("cryptoPrice"){
                            type = NavType.StringType
                        }
                    )){
                        val cryptoId = remember {
                            it.arguments?.getString("cryptoId")
                        }
                        val cryptoPrice = remember {
                            it.arguments?.getString("cryptoPrice")
                        }

                        CryptoDetailScreen(
                            id = cryptoId ?: "",
                            price = cryptoPrice ?: "",
                            navController = navController
                        )

                    }

 */
                }



            }
        }
    }


}


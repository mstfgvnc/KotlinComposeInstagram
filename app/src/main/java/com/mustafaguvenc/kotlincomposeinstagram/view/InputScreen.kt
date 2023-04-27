package com.mustafaguvenc.kotlincomposeinstagram.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun InputScreen(
    navController: NavController,
  //  viewModel : CryptoListViewModel = hiltViewModel()
) {
    var emailInput by remember {
        mutableStateOf("")
    }

    var passwordInput by remember {
        mutableStateOf("")
    }

    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondary)
            .padding(15.dp)
            .clickable {
                focusManager.clearFocus()
            },
        contentAlignment = Alignment.Center,
    ) {


        Column {

            TextField(value = emailInput,
                onValueChange ={
                    emailInput = it
            }, placeholder = { Text(text = "Enter Email...")},
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(5.dp, CircleShape)
                    .background(Color.White, CircleShape)
                    .padding(horizontal = 20.dp, vertical = 12.dp)
                    .focusRequester(focusRequester),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent),
                label = {
                    Text(
                        text = "Email"
                    )
                },
                maxLines = 2,
            )

            Spacer(modifier = Modifier.height(15.dp))

            TextField(value = passwordInput,
                onValueChange ={
                    passwordInput = it
                }, placeholder = { Text(text = "Enter Password...")},
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(5.dp, CircleShape)
                    .background(Color.White, CircleShape)
                    .padding(horizontal = 20.dp, vertical = 12.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent),
                label = {
                    Text(
                        text = "Password"
                    )
                },
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(15.dp))




            /*
            Text(text = "Crypto Crazy", modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
                textAlign = TextAlign.Center,
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            )
            Spacer(modifier = Modifier.height(10.dp))
            SearchBar(
                hint = "Search...", modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ){
                viewModel.searchCryptoList(it)
            }
            Spacer(modifier = Modifier.height(10.dp))
            CryptoList(navController = navController)

             */

        }
    }
}
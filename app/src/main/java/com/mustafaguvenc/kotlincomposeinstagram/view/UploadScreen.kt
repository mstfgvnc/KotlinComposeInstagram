package com.mustafaguvenc.kotlincomposeinstagram.view


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mustafaguvenc.kotlincomposeinstagram.R

@Composable
fun UploadScreen(
    navController: NavController,
    //  viewModel : CryptoListViewModel = hiltViewModel()
) {
    var emailInput by remember {
        mutableStateOf("")
    }

    var passwordInput by remember {
        mutableStateOf("")
    }

    var passwordVisibility: Boolean by remember { mutableStateOf(false) }

    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(15.dp)
            .clickable {
                focusManager.clearFocus()
            },
        contentAlignment = Alignment.Center,
    ) {
        Column (Modifier.fillMaxHeight()){
            Column (
                Modifier
                    .fillMaxHeight()
                    .weight(2f), verticalArrangement = Arrangement.Center){
                Text(
                    text = "MGtagram", modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 44.sp,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,

                    )
            }



            Column (
                Modifier
                    .fillMaxHeight()
                    .weight(4f)){

                TextField(value = emailInput,
                    onValueChange ={
                        emailInput = it
                    }, placeholder = {
                        Text(text = stringResource(id = R.string.enter_email),
                            fontFamily = FontFamily.Cursive
                        )},
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
                            text = stringResource(id = R.string.email),
                            fontFamily = FontFamily.Cursive
                        )
                    },
                    //  maxLines = 1,
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = stringResource(id = R.string.email_icon)
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = stringResource(id = R.string.person_icon)
                        )
                    }
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(value = passwordInput,
                    onValueChange ={
                        passwordInput = it
                    }, placeholder = {
                        Text(text =stringResource(id = R.string.enter_password),
                            fontFamily = FontFamily.Cursive
                        )},
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
                            text = stringResource(id = R.string.password),
                            fontFamily = FontFamily.Cursive
                        )
                    },
                    //   maxLines = 1,
                    singleLine = true,
                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = stringResource(id = R.string.lock_icon)
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                            Icon(
                                imageVector = if (passwordVisibility) Icons.Outlined.VisibilityOff else Icons.Outlined.Visibility,
                                contentDescription = if (passwordVisibility) stringResource(id = R.string.show_password) else stringResource(id = R.string.hide_password)
                            )
                        }
                    }

                )

                Spacer(modifier = Modifier.height(15.dp))

                Row( modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)) {
                    Button(onClick = {
                        navController.navigate("feed_screen")
                    }, shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(horizontal = 5.dp)
                            .border(
                                width = 2.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clickable {

                            }

                    ) {
                        Text(text = stringResource(id = R.string.sign_in),
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Cursive
                        )
                    }
                    Button(onClick = {

                    }, shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(horizontal = 5.dp)
                            .border(
                                width = 2.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(10.dp)
                            )) {
                        Text(text = stringResource(id = R.string.sign_up),
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Cursive
                        )
                    }
                }



            }
        }
    }
}
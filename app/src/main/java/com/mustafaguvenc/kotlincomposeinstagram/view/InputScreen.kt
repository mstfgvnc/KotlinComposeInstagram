package com.mustafaguvenc.kotlincomposeinstagram.view

import android.content.Intent
import android.graphics.drawable.VectorDrawable
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mustafaguvenc.kotlincomposeinstagram.R
import com.mustafaguvenc.kotlincomposeinstagram.viewmodel.InputViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun InputScreen(
    navController: NavController,
    viewModel : InputViewModel
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

    /*
    LaunchedEffect(key1 = Unit){
        viewModel.init()
        if (viewModel.currentUser != null) {
            navController.navigate("feed_screen")
        }
    }

     */



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

            val context = LocalContext.current

            TextField(value = emailInput,
                onValueChange ={
                    emailInput = it
            }, placeholder = {
                    Text(text = stringResource(R.string.enter_email),
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
                        text = stringResource(R.string.email),
                        fontFamily = FontFamily.Cursive
                    )
                },
              //  maxLines = 1,
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = stringResource(R.string.email_icon)
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = stringResource(R.string.person_icon)
                    )
                }
            )

            Spacer(modifier = Modifier.height(15.dp))

            TextField(value = passwordInput,
                onValueChange ={
                    passwordInput = it
                }, placeholder = {
                    Text(text = stringResource(R.string.enter_password),
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
                        text = stringResource(R.string.password),
                        fontFamily = FontFamily.Cursive
                    )
                },
             //   maxLines = 1,
                singleLine = true,
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Lock,
                        contentDescription = stringResource(R.string.lock_icon)
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            imageVector = if (passwordVisibility) Icons.Outlined.VisibilityOff else Icons.Outlined.Visibility,
                            contentDescription = if (passwordVisibility) stringResource(R.string.show_password) else stringResource(
                                                            R.string.hide_password)
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(
                    autoCorrect = true,
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    }
                )

                /*
                leadingIcon = {
                    IconButton( onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                        Icon(painter = painterResource(id = R.drawable.eye), contentDescription = "" )
                    }
                }

                 */
            )

            Spacer(modifier = Modifier.height(15.dp))

            Row( modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)) {
                Button(onClick = {

                    if (emailInput.isNotEmpty() && passwordInput.isNotEmpty()) {
                        viewModel.auth.signInWithEmailAndPassword(emailInput,passwordInput).addOnCompleteListener { task ->

                            if (task.isSuccessful) {
                                navController.navigate("feed_screen")
                            }

                        }.addOnFailureListener { exception ->
                            Toast.makeText(context,exception.localizedMessage,Toast.LENGTH_LONG).show()
                        }
                    }



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
                    Text(text = stringResource(R.string.sign_in),
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Cursive
                        )
                }
                Button(onClick = {

                    if (emailInput.isNotEmpty() && passwordInput.isNotEmpty()) {

                        viewModel.auth.createUserWithEmailAndPassword(emailInput,passwordInput).addOnCompleteListener { task ->

                            if (task.isSuccessful) {

                                navController.navigate("feed_screen")
                            }

                        }.addOnFailureListener { exception ->
                            Toast.makeText(context,exception.localizedMessage,Toast.LENGTH_LONG).show()

                        }
                    }

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
                    Text(text = stringResource(R.string.sign_up),
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Cursive
                        )
                }
            }






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
}
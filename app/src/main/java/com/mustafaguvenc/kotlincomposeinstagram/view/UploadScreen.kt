package com.mustafaguvenc.kotlincomposeinstagram.view


import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mustafaguvenc.kotlincomposeinstagram.R
import com.mustafaguvenc.kotlincomposeinstagram.viewmodel.InputViewModel

@Composable
fun UploadScreen(
    navController: NavController,
    viewModel : InputViewModel
) {

    var commentInput by remember {
        mutableStateOf("")
    }

    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(15.dp)
            .clickable {
                focusManager.clearFocus()
            }
            ,
        contentAlignment = Alignment.Center,
    ) {
        Column (Modifier.fillMaxHeight()){
            Column (
                Modifier
                    .fillMaxHeight()
                    .weight(1f), verticalArrangement = Arrangement.Center) {
                Text(
                    text = "Select Image",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 35.sp,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,

                    )
            }

            Column (
                Modifier
                    .fillMaxHeight()
                    .weight(2f), verticalArrangement = Arrangement.Center) {
                Image(painterResource(id = R.drawable.add_159647),"", modifier = Modifier.fillMaxSize())
            }

            Column (
                Modifier
                    .fillMaxHeight()
                    .weight(2f), verticalArrangement = Arrangement.Center) {
                TextField(value = commentInput,
                    onValueChange ={
                        commentInput = it
                    }, placeholder = {
                        Text(text = "Enter Comment...",
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
                            text = "Comment",
                            fontFamily = FontFamily.Cursive
                        )
                    }


                )
            }

            Column (
                Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(50.dp), verticalArrangement = Arrangement.Center) {
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
                        )
                        .clickable {

                        }

                ) {
                    Text(text = "UPLOAD",
                        fontSize = 2.sp,
                        fontFamily = FontFamily.Cursive
                    )
                }
            }



        }
    }
}
package com.mustafaguvenc.kotlincomposeinstagram.view


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import android.view.KeyEvent
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.mustafaguvenc.kotlincomposeinstagram.R
import com.mustafaguvenc.kotlincomposeinstagram.viewmodel.InputViewModel
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UploadScreen(
    navController: NavController,
    viewModel : InputViewModel
) {

    val scaffoldState = rememberScaffoldState() // this contains the `SnackbarHostState`
    val coroutineScope = rememberCoroutineScope()
    var selectedPicture by remember {
        mutableStateOf<Uri?>(android.net.Uri.parse("android.resource://com.mustafaguvenc.kotlincomposeinstagram/" + R.drawable.add_159647))
    }
    val bitmap =  remember {
        mutableStateOf<Bitmap?>(null)
    }
    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()){ uri: Uri? ->
            selectedPicture = uri
        }
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()){ isGranted ->
        if (isGranted) {
            // Open camera
        } else {
            // Show dialog
        }
    }


    var commentInput by remember {
        mutableStateOf("")
    }

    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current as Activity

    Scaffold(modifier = Modifier,
        scaffoldState = scaffoldState,
        ) {

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
            Column(Modifier.fillMaxHeight()) {
                Column(
                    Modifier
                        .fillMaxHeight()
                        .weight(1f), verticalArrangement = Arrangement.Center
                ) {
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

                Column(

                    Modifier
                        .fillMaxHeight()
                        .weight(2f), verticalArrangement = Arrangement.Center
                ) {


               //     Image(painter = painterResource(id = R.drawable.add_159647), "",
                         Image(painter = rememberAsyncImagePainter(selectedPicture), "",

                            modifier = Modifier
                                .fillMaxSize()
                                .clickable {
                                    if (ContextCompat.checkSelfPermission(
                                            context,
                                            android.Manifest.permission.READ_EXTERNAL_STORAGE
                                        ) != PackageManager.PERMISSION_GRANTED
                                    ) {
                                        if (ActivityCompat.shouldShowRequestPermissionRationale(
                                                context,
                                                android.Manifest.permission.READ_EXTERNAL_STORAGE
                                            )
                                        ) {


                                            coroutineScope.launch {
                                                // using the `coroutineScope` to `launch` showing the snackbar
                                                // taking the `snackbarHostState` from the attached `scaffoldState`
                                                val snackbarResult =
                                                    scaffoldState.snackbarHostState.showSnackbar(
                                                        message = "Permission need for gallery",
                                                        actionLabel = "Give permission"
                                                    )
                                                when (snackbarResult) {
                                                    SnackbarResult.Dismissed -> Log.d(
                                                        "SnackbarDemo",
                                                        "Dismissed"
                                                    )

                                                    SnackbarResult.ActionPerformed -> {Log.d(
                                                        "SnackbarDemo",
                                                        "Snackbar's button clicked"
                                                    )
                                                    permissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                                                    }
                                                }
                                            }


                                        } else {
                                            // request permission
                                            permissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                                        }
                                    } else {
                                        imagePicker.launch("image/*")
                                    }
                                })

                }



                Column(
                    Modifier
                        .fillMaxHeight()
                        .weight(2f), verticalArrangement = Arrangement.Center
                ) {

                    OutlinedTextField(value = commentInput,
                        onValueChange = {
                            commentInput = it
                        },
                        placeholder = {
                            Text(
                                text = "Enter Comment...",
                                fontFamily = FontFamily.Cursive
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(5.dp, CircleShape)
                            .background(Color.White, CircleShape)
                            .padding(horizontal = 20.dp, vertical = 12.dp)
                            .focusRequester(focusRequester)
                            //textfield da enter a basıldığında focus temizleniyordu.
                            .onKeyEvent {
                                if (it.key.equals(Key.Enter)) {
                                    focusRequester.requestFocus()
                                    return@onKeyEvent true
                                }
                                false
                            },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        label = {
                            Text(
                                text = "Comment",
                                fontFamily = FontFamily.Cursive
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = { focusManager.clearFocus() }) {
                                Icon(
                                    imageVector = Icons.Outlined.Done,
                                    contentDescription = ""
                                )
                            }
                        }


                    )
                }

                Row(
                    Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .padding(20.dp), horizontalArrangement = Arrangement.Center
                ) {
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
                        Text(
                            text = "Upload",
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Cursive
                        )
                    }
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
                        Text(
                            text = "Cancel",
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Cursive
                        )
                    }
                }


            }
        }
    }
}
package com.vvsu.mypass

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.web.*
import com.vvsu.mypass.ui.theme.MyPassTheme
import com.vvsu.mypass.ui.theme.WhiteCard

class Web_Forget : ComponentActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPassTheme {
                val montserrat_bold = FontFamily(Font(R.font.montserrat_medium))
                val url by remember { mutableStateOf("https://api.vvsu.ru/services/changepass") }
                val state = rememberWebViewState(url = url)
                val intent = Intent(this, LoginActivity::class.java)
                val navigator = rememberWebViewNavigator()
                var textFieldValue by remember(state.content.getCurrentUrl()) {
                    mutableStateOf(state.content.getCurrentUrl() ?: "")
                }

                Column {
                    TopAppBar {
                        IconButton(onClick = { navigator.navigateBack() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Назад"
                            )
                        }
                        IconButton(onClick = { navigator.navigateForward() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = "Вперёд"
                            )
                        }
                        Text(
                            modifier = Modifier,
                            text = "My.Браузер",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.h4.copy(
                                shadow = Shadow(
                                    offset = Offset(2f, 2f),
                                    blurRadius = 1f
                                ),
                                color = Color.White,
                                fontSize = 20.sp,
                                fontFamily = montserrat_bold
                            )
                        )
                        Row(
                            modifier = Modifier.weight(1f),
                            horizontalArrangement = Arrangement.End
                        ) {
                            IconButton(onClick = { navigator.reload() }) {
                                Icon(
                                    imageVector = Icons.Default.Refresh,
                                    contentDescription = "Обновить"
                                )
                            }
                            IconButton(onClick = { startActivity(intent) }) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Go"
                                )
                            }
                        }
                    }

                    Row(modifier = Modifier.padding(all = 12.dp)) {
                        BasicTextField(
                            modifier = Modifier.weight(9f),
                            value = textFieldValue,
                            onValueChange = { textFieldValue = it },
                            textStyle = LocalTextStyle.current.copy(color = WhiteCard),
                            maxLines = 1
                        )
                        if (state.errorsForCurrentRequest.isNotEmpty()) {
                            Icon(
                                modifier = Modifier
                                    .weight(1f),
                                imageVector = Icons.Default.Warning,
                                contentDescription = "Ошибка",
                                tint = Color.Red
                            )
                        }
                    }

                    val loadingState = state.loadingState
                    if (loadingState is LoadingState.Loading) {
                        LinearProgressIndicator(
                            progress = loadingState.progress,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    // A custom WebViewClient and WebChromeClient can be provided via subclassing
                    val webClient = remember {
                        object : AccompanistWebViewClient() {
                            override fun onPageStarted(
                                view: WebView?,
                                url: String?,
                                favicon: Bitmap?
                            ) {
                                super.onPageStarted(view, url, favicon)
                                Log.d("Accompanist WebView", "Page started loading for $url")
                            }
                        }
                    }

                    WebView(
                        state = state,
                        modifier = Modifier.weight(1f),
                        navigator = navigator,
                        onCreated = { webView ->
                            webView.settings.javaScriptEnabled = true
                        },
                        client = webClient
                    )
                }
            }
        }
    }
}
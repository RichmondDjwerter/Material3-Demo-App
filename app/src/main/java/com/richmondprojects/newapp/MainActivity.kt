package com.richmondprojects.newapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.richmondprojects.newapp.ui.theme.NewAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        floatingActionButton = {
                            FloatingActionButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        },
                        topBar = {
                            SmallTopAppBar(
                                title = {
                                    Text(text = "Demo Material3 App")
                                },
                                colors = TopAppBarDefaults.smallTopAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                                    titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        }
                    ) { paddingValues ->
                        LazyColumn(contentPadding = paddingValues) {
                            items(30) {
                                ImageContent(
                                    title = "travel inspiration",
                                    description = "This result from Lonely Planet, which ranks for the search term “travel inspiration”, " +
                                            "does a great job of both satisfying the search query and selling the brand. In the first two words, " +
                                            "it appeals to travel lovers who might be searching for inspiration, " +
                                            "before going on to outline concisely what the brand has to offer them. " +
                                            "The site links that appear beneath it also entice searchers to click on a more specific page.",
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
package com.example.cryptoapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptoapplication.common.Routes
import com.example.cryptoapplication.presentation.coin_detail.CoinDetailScreen
import com.example.cryptoapplication.presentation.coin_list.CoinListScreen
import com.example.cryptoapplication.presentation.ui.theme.CryptoApplicationTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoApplicationTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Routes.COIN_LIST
                    ){
                        composable(Routes.COIN_LIST) {
                            CoinListScreen(navController)
                        }
                        composable(Routes.COIN_DETAIL + "/{coinId}") {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}




package com.example.cryptoapplication.presentation.coin_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptoapplication.presentation.coin_detail.components.CoinTag
import com.example.cryptoapplication.presentation.coin_detail.components.TeamListItem
import com.example.cryptoapplication.presentation.coin_detail.viewmodel.CoinDetailViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()
            .padding(innerPadding)){
            state.coin?.let { coin ->
                LazyColumn(modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(20.dp)
                ) {
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "${coin.rank}. ${coin.name}  (${coin.symbol})",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.weight(8f)
                            )
                            Text(
                                text = if(coin.isActive) "active" else "inactive",
                                fontStyle = FontStyle.Italic,
                                color = if(coin.isActive) Color.Green else Color.Red,
                                textAlign = TextAlign.End,
                                modifier = Modifier
                                    .align(CenterVertically)
                                    .weight(2f)
                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = coin.description,
                            style = MaterialTheme.typography.bodySmall,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 5
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Tags",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        FlowRow(
                            maxItemsInEachRow = 3
                        ) {
                            coin.tags.forEach{tag ->
                                CoinTag(tag)
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Team Members",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                    items(coin.team){teamMembers ->
                        TeamListItem(
                            teamMembers,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        )
                        HorizontalDivider()
                    }
                }
            }
            if(state.error.isNotBlank()){
                Text(
                    text = state.error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if(state.isLoading){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

    }

}
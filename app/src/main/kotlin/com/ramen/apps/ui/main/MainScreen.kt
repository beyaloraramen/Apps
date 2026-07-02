package com.ramen.apps.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val tabs = listOf("Apps", "Restore")
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val coroutineScope = rememberCoroutineScope()
    val searchBarState = rememberSearchBarState()
    val textFieldState = rememberTextFieldState()

    Scaffold {
        Box(modifier = Modifier.fillMaxSize().padding(it)) {
            Column(modifier = Modifier.fillMaxSize()) {
                SearchBar(
                    state = searchBarState,
                    inputField = {
                        SearchBarDefaults.InputField(
                            textFieldState = textFieldState,
                            searchBarState = searchBarState,
                            onSearch = { searchBarState.collapse() },
                            placeholder = { Text("Search apps...") },
                            leadingIcon = { Icon(Icons.Default.Search, null) }
                        )
                    }
                ) {}

                SecondaryTabRow(selectedTabIndex = pagerState.currentPage) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = pagerState.currentPage == index,
                            onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                            text = { Text(title) }
                        )
                    }
                }

                HorizontalPager(state = pagerState, modifier = Modifier.weight(1f)) { page ->
                    Text("Content for ${tabs[page]}", modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}

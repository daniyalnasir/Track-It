package com.codeshod.navigation.viewModel

import com.codeshod.navigation.Screen

sealed interface HomeIntent {

    // On Screen Changed
    data class OnScreenChanged(val currentScreen: Screen) : HomeIntent
}
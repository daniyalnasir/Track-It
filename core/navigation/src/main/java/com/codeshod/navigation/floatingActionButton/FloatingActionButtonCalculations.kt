package com.codeshod.navigation.floatingActionButton

import com.codeshod.navigation.Screen


private val screensWithFloatingActionButton = listOf<Screen>(
    Screen.Dashboard
)

fun isFloatingActionButtonVisible(currentScreen: Screen?): Boolean {
    if (currentScreen != null) {
        return screensWithFloatingActionButton.contains(currentScreen)
    }

    return false
}
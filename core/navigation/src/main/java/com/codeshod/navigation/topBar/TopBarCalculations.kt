package com.codeshod.navigation.topBar

import com.codeshod.design_systems.EMPTY_STRING
import com.codeshod.navigation.Screen


private val screensWithoutTopBar = listOf<Screen>()

fun isTopBarVisible(currentScreen: Screen?): Boolean {
    if (currentScreen != null) {
        return !screensWithoutTopBar.contains(currentScreen)
    }

    return false
}

private val screensWithoutBackButton = listOf<Screen>(
    Screen.Dashboard
)

fun isBackNavigationButtonVisible(currentScreen: Screen?): Boolean {
    if (currentScreen != null) {
        return !screensWithoutBackButton.contains(currentScreen)
    }
    return false
}

fun getTopBarTitle(currentScreen: Screen?): String {
    return currentScreen?.title ?: EMPTY_STRING
}
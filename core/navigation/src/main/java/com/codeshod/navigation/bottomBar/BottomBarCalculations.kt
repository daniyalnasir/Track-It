package com.codeshod.navigation.bottomBar

import com.codeshod.navigation.R
import com.codeshod.navigation.Screen


val bottomBarNavigationItems = listOf(
    BottomBarNavigationItem(
        icon = R.drawable.ic_dashboard,
        route = Screen.Dashboard
    ),
    BottomBarNavigationItem(
        icon = R.drawable.ic_stats,
        route = Screen.Stats
    ),
    BottomBarNavigationItem(
        icon = R.drawable.ic_category,
        route = Screen.Categories
    ),
    BottomBarNavigationItem(
        icon = R.drawable.ic_wallet,
        route = Screen.Wallet
    ),
    BottomBarNavigationItem(
        icon = R.drawable.ic_settings,
        route = Screen.Settings
    )
)

fun provideSelectedBottomBarNavigationItem(currentScreen: Screen?): BottomBarNavigationItem? {
    if (currentScreen != null) {
        val isFound = bottomBarNavigationItems.find { it.route == currentScreen }

        return isFound
    }

    return null
}
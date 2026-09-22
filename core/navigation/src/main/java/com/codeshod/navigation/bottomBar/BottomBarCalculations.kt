package com.codeshod.navigation.bottomBar

import com.codeshod.design_systems.AppDrawables
import com.codeshod.navigation.Screen


val bottomBarNavigationItems = listOf(
    BottomBarNavigationItem(
        icon = AppDrawables.dashboard,
        route = Screen.Dashboard
    ),
    BottomBarNavigationItem(
        icon = AppDrawables.stats,
        route = Screen.Stats
    ),
    BottomBarNavigationItem(
        icon = AppDrawables.category,
        route = Screen.Categories
    ),
    BottomBarNavigationItem(
        icon = AppDrawables.wallet,
        route = Screen.Wallet
    ),
    BottomBarNavigationItem(
        icon = AppDrawables.settings,
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
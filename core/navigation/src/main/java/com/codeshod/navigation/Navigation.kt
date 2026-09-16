package com.codeshod.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.codeshod.categories.presentation.CategoriesScreen
import com.codeshod.dashboard.presentation.DashboardScreen
import com.codeshod.settings.presentation.SettingsScreen
import com.codeshod.stats.presentation.StatsScreen
import com.codeshod.wallet.presentation.WalletScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                onNavigate = { screen ->
                    navigateTo(screen, navController)
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(
                onNavigate = { screen ->
                    navigateTo(
                        screen = screen,
                        navController = navController
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingButton(
                onNavigate = { screen ->
                    navigateTo(
                        screen = screen,
                        navController = navController
                    )
                }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            graph = provideNavGraph(navController),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .imePadding(),

            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(500)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(500)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(500)
                )
            }
        )
    }
}

fun provideNavGraph(navController: NavHostController): NavGraph {
    val graph = navController.createGraph(
        startDestination = Screen.Dashboard
    ) {
        composable<Screen.Dashboard> {
            DashboardScreen()
        }
        composable<Screen.Stats> {
            StatsScreen()
        }
        composable<Screen.Categories> {
            CategoriesScreen()
        }
        composable<Screen.Settings> {
            SettingsScreen()
        }
        composable<Screen.Wallet> {
            WalletScreen()
        }
        composable<Screen.AddTransaction> {
        }
    }

    return graph
}

private fun navigateTo(
    screen: Screen,
    navController: NavController,
) {

    when (screen) {
        is Screen.PreviousScreen -> {
            navController.popBackStack()
        }

        else -> {
            navController.navigate(route = screen) {
                val popUp = needToPopUp(screen)

                if (popUp != null) {
                    popUpTo(popUp) {
                        inclusive = true
                    }
                }
//                launchSingleTop = true
//                restoreState = true
            }
        }
    }
}

private fun needToPopUp(screen: Screen): Screen? {
    return when (screen) {

        else -> {
            null
        }
    }
}


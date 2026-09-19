package com.codeshod.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.codeshod.categories.presentation.CategoriesScreen
import com.codeshod.dashboard.presentation.DashboardScreen
import com.codeshod.design_systems.CurvedHeader
import com.codeshod.navigation.Screen.Companion.toScreen
import com.codeshod.navigation.bottomBar.BottomNavigationBar
import com.codeshod.navigation.topBar.TopBar
import com.codeshod.navigation.viewModel.HomeIntent
import com.codeshod.navigation.viewModel.HomeViewModel
import com.codeshod.settings.presentation.SettingsScreen
import com.codeshod.stats.presentation.StatsScreen
import com.codeshod.wallet.presentation.WalletScreen

@Composable
fun Navigation(
    homeViewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = navBackStackEntry
        ?.destination
        ?.toScreen()

    LaunchedEffect(currentScreen) {
        if (currentScreen != null)
            homeViewModel.onIntent(HomeIntent.OnScreenChanged(currentScreen))
    }

    val homeViewState by homeViewModel.viewStateFlow.collectAsStateWithLifecycle()

    CurvedHeader {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Transparent,
            topBar = {
                TopBar(
                    topBarViewState = homeViewState.topBarViewState,
                    currentScreen = currentScreen,
                    onNavigate = { screen ->
                        navigateTo(screen, navController)
                    }
                )
            },
            bottomBar = {
                BottomNavigationBar(
                    bottomBarViewState = homeViewState.bottomBarViewState,
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


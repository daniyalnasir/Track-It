package com.codeshod.navigation

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import com.codeshod.design_systems.EMPTY_STRING
import com.codeshod.navigation.Route.ROUTE_ADD_TRANSACTION
import com.codeshod.navigation.Route.ROUTE_CATEGORIES
import com.codeshod.navigation.Route.ROUTE_DASHBOARD
import com.codeshod.navigation.Route.ROUTE_SETTINGS
import com.codeshod.navigation.Route.ROUTE_STATS
import com.codeshod.navigation.Route.ROUTE_WALLET
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen(val title: String = EMPTY_STRING) {

    @Serializable
    data object PreviousScreen : Screen(title = EMPTY_STRING)

    @Serializable
    object Dashboard : Screen(ROUTE_DASHBOARD)

    @Serializable
    object Stats : Screen(ROUTE_STATS)

    @Serializable
    object Categories : Screen(ROUTE_CATEGORIES)

    @Serializable
    object Settings : Screen(ROUTE_SETTINGS)

    @Serializable
    object Wallet : Screen(ROUTE_WALLET)

    @Serializable
    object AddTransaction : Screen(ROUTE_ADD_TRANSACTION)



    companion object {

        fun fromRoute(route: String?): Screen? {
            return when (route) {
                Dashboard.title -> Dashboard
                Stats.title -> Stats
                Categories.title -> Categories
                Settings.title -> Settings
                Wallet.title -> Wallet
                AddTransaction.title -> AddTransaction
                else -> null
            }
        }

        fun NavDestination.toScreen(): Screen? {
            return when {
                hasRoute<Dashboard>() -> Dashboard
                hasRoute<Stats>() -> Stats
                hasRoute<Categories>() -> Categories
                hasRoute<Settings>() -> Settings
                hasRoute<Wallet>() -> Wallet
                hasRoute<AddTransaction>() -> AddTransaction
                else -> null
            }
        }
    }
}
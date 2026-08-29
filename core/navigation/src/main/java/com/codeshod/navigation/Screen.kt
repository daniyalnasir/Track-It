package com.codeshod.navigation

import com.codeshod.navigation.Route.EMPTY_STRING
import com.codeshod.navigation.Route.ROUTE_CATEGORIES
import com.codeshod.navigation.Route.ROUTE_DASHBOARD
import com.codeshod.navigation.Route.ROUTE_SETTINGS
import com.codeshod.navigation.Route.ROUTE_STATS
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen(val route: String = EMPTY_STRING) {

    @Serializable
    object Dashboard : Screen(ROUTE_DASHBOARD)

    @Serializable
    object Stats : Screen(ROUTE_STATS)

    @Serializable
    object Categories : Screen(ROUTE_CATEGORIES)

    @Serializable
    object Settings : Screen(ROUTE_SETTINGS)
}
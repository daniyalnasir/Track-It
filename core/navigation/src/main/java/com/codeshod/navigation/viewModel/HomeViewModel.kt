package com.codeshod.navigation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeshod.design_systems.EMPTY_STRING
import com.codeshod.navigation.Screen
import com.codeshod.navigation.bottomBar.BottomBarNavigationItem
import com.codeshod.navigation.bottomBar.provideSelectedBottomBarNavigationItem
import com.codeshod.navigation.topBar.getTopBarTitle
import com.codeshod.navigation.topBar.isBackNavigationButtonVisible
import com.codeshod.navigation.topBar.isTopBarVisible
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private var viewState = ViewState()

    private val _viewStateFlow: MutableStateFlow<ViewState> = MutableStateFlow(viewState)
    val viewStateFlow: StateFlow<ViewState> = _viewStateFlow.asStateFlow()

    private val _viewActionFlow = MutableSharedFlow<ViewAction>(extraBufferCapacity = 1)
    val viewActionFlow = _viewActionFlow.asSharedFlow()

    data class ViewState(
        val topBarViewState: TopBarViewState = TopBarViewState(),
        val bottomBarViewState: BottomBarViewState = BottomBarViewState(),
    )

    data class TopBarViewState(
        val isVisible: Boolean = false,
        val isBackNavigationButtonVisible: Boolean = false,
        val title: String = EMPTY_STRING,
    )

    data class BottomBarViewState(
        val isVisible: Boolean = false,
        val selectedBottomBarNavigationItem: BottomBarNavigationItem? = null,
    )

    enum class BottomDestination {
        HOME,
        STATISTICS,
        WALLETS,
        PROFILE
    }

    sealed interface ViewAction {
    }

    sealed class Action {
        data class OnScreenChanged(val currentScreen: Screen) : Action()
    }

    fun onIntent(homeIntent: HomeIntent) {
        when (homeIntent) {

            is HomeIntent.OnScreenChanged -> {
                dispatch(Action.OnScreenChanged(currentScreen = homeIntent.currentScreen))
            }
        }
    }

    private fun emitCallBack(viewAction: ViewAction) {
        viewModelScope.launch {
            _viewActionFlow.emit(viewAction)
        }
    }

    private fun dispatch(action: Action) {
        viewModelScope.launch {
            val updatedViewState = reduce(action)
            viewState = updatedViewState

            _viewStateFlow.update {
                updatedViewState
            }
        }
    }

    private fun reduce(action: Action): ViewState {
        return when (action) {

            is Action.OnScreenChanged -> {
                onScreenChanged(action.currentScreen)
            }
        }
    }

    private fun onScreenChanged(currentScreen: Screen): ViewState {
        val topBarViewState = viewState.topBarViewState.copy(
            isVisible = isTopBarVisible(currentScreen = currentScreen),
            isBackNavigationButtonVisible = isBackNavigationButtonVisible(currentScreen = currentScreen),
            title = getTopBarTitle(currentScreen = currentScreen),
        )

        val bottomBarViewState =
            if (viewState.bottomBarViewState.selectedBottomBarNavigationItem == null ||
                viewState.bottomBarViewState.selectedBottomBarNavigationItem != currentScreen
            ) {
                viewState.bottomBarViewState.copy(
                    isVisible = isTopBarVisible(currentScreen = currentScreen),
                    selectedBottomBarNavigationItem = provideSelectedBottomBarNavigationItem(
                        currentScreen = currentScreen
                    ),
                )
            } else {
                viewState.bottomBarViewState
            }
        return viewState.copy(
            topBarViewState = topBarViewState,
            bottomBarViewState = bottomBarViewState
        )
    }
}
package ru.shtykin.ocv1.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.shtykin.ocv1.domain.Repository
import ru.shtykin.ocv1.presentation.state.ScreenState
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    private val _uiState =
        mutableStateOf<ScreenState>(
            ScreenState.MainScreen(
                temp = ""
            )
        )

    val uiState: State<ScreenState>
        get() = _uiState


}
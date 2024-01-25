package ru.shtykin.ocv1.presentation.state


sealed class ScreenState {

    data class MainScreen(
        val temp: String,
    ) : ScreenState()

    data class CameraScreen(
        val temp: String,
    ) : ScreenState()

}

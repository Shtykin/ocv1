package ru.shtykin.ocv1.navigation

sealed class Screen(
    val route: String
) {
    object Main: Screen(ROUTE_MAIN)
    object Camera: Screen(ROUTE_CAMERA)

    private companion object {
        const val ROUTE_MAIN = "route_main"
        const val ROUTE_CAMERA = "route_camera"
    }
}

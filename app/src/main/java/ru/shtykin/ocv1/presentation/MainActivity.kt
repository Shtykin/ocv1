package ru.shtykin.ocv1.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import org.opencv.android.OpenCVLoader
import ru.shtykin.ocv1.navigation.AppNavGraph
import ru.shtykin.ocv1.navigation.Screen
import ru.shtykin.ocv1.presentation.composable.screen.camera.CameraScreen
import ru.shtykin.ocv1.presentation.composable.screen.main.MainScreen
import ru.shtykin.ocv1.presentation.ui.theme.Ocv1Theme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (OpenCVLoader.initDebug()) Log.e("DEBUG1", "init");
        setContent {
            val navHostController = rememberNavController()
            val scope = rememberCoroutineScope()
            val uiState by viewModel.uiState
            val startScreenRoute = Screen.Main.route
            Ocv1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavGraph(
                        startScreenRoute = startScreenRoute,
                        navHostController = navHostController,
                        mainScreenContent = {
                            MainScreen(
                                uiState = uiState
                            )
                        },
                        cameraScreenContent = {
                            CameraScreen(
                                uiState = uiState
                            )
                        }
                    )
                }
            }
        }
    }
}
package com.hackillinois.snapchatUIComposeClone.common

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.hackillinois.snapchatUIComposeClone.R
import com.hackillinois.snapchatUIComposeClone.common.components.CustomBottomNavigation
import com.hackillinois.snapchatUIComposeClone.common.components.CustomTopBar
import com.hackillinois.snapchatUIComposeClone.common.config.navigationConfig
import com.hackillinois.snapchatUIComposeClone.common.utils.Navigation
import com.hackillinois.snapchatUIComposeClone.common.utils.topBarFormatter
import com.hackillinois.snapchatUIComposeClone.ui.theme.ComposeSnapChatUITheme
import io.realm.kotlin.*

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(
        ExperimentalFoundationApi::class,
        ExperimentalCoilApi::class,
        ExperimentalAnimationApi::class,
        ExperimentalPermissionsApi::class,
        ExperimentalMaterial3Api::class
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_ComposeCameraX)
        setContent {
            ComposeSnapChatUITheme {
                val navController = rememberNavController()
                val backStack = navController.currentBackStackEntryAsState()
                Scaffold(
                    topBar = {
                        Box {
                            Navigation(navController = navController)
                            CustomTopBar(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                topBarItem = topBarFormatter(backStack.value?.destination?.route)
                            )
                        }
                    },
                    bottomBar = {
                        CustomBottomNavigation(
                            items = navigationConfig(),
                            navController = navController,
                            modifier = Modifier,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    },
                ) {}
            }
        }
        // TODO how to pass this location provider (or just the last known location) down to the SnapMapScreen?
        // val fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
    }
}

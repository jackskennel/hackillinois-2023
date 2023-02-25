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
import com.hackillinois.snapchatUIComposeClone.common.models.Memory
import com.hackillinois.snapchatUIComposeClone.common.utils.Navigation
import com.hackillinois.snapchatUIComposeClone.common.utils.topBarFormatter
import com.hackillinois.snapchatUIComposeClone.ui.theme.ComposeSnapChatUITheme
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.query.find;
import io.realm.kotlin.*;
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.sync.SyncConfiguration
import kotlinx.coroutines.runBlocking

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

        println("Making app")

        val app = App.create("hackillinois2023-sync-sbyce")

        println("Going to runBlocking")
        val realm = runBlocking {


            val user = app.login(Credentials.apiKey("cv7ZZpsFcTxiIaQiWwIyRzEuX9F06GvGqINfUroGuqUIx7CSf8MUAcVdl6eDhZPx"))


            println("Building config")
//            val user = app.login(Credentials.anonymous())
            val config = SyncConfiguration.Builder(user, setOf(Memory::class))
                .maxNumberOfActiveVersions(10)
                .name("Memcache")
                .initialSubscriptions { realm ->
                    add(
                        realm.query(Memory::class), // subscribe to all Memory objects
                        "Memory subscription"
                    )
                }
                .build()

            println("Opening Realm")
            Realm.open(config).also {println("Successfully opened realm: ${it.configuration}") }
        }

        val items: RealmResults<Memory> = realm.query(Memory::class).find()
        println("Items: $items")
    }
}

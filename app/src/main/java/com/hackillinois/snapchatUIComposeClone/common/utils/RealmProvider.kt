package com.hackillinois.snapchatUIComposeClone.common.utils

import android.util.Log
import com.hackillinois.snapchatUIComposeClone.common.models.Memory
import io.realm.kotlin.Realm
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.sync.SyncConfiguration
import kotlinx.coroutines.runBlocking

class RealmProvider {
    private var realm: Realm? = null
    
    fun getRealm(): Realm {
        return realm ?: run {
            Log.d("RealmProvider", "Initializing realm")
            val app = App.create("hackillinois2023-sync-sbyce")

            runBlocking {
                val user = app.login(Credentials.apiKey("cv7ZZpsFcTxiIaQiWwIyRzEuX9F06GvGqINfUroGuqUIx7CSf8MUAcVdl6eDhZPx"))
                val config = SyncConfiguration.Builder(user, setOf(Memory::class))
                    .maxNumberOfActiveVersions(10)
                    .name("Memcache")
                    .initialSubscriptions { realm ->
                        // Subscribe to all Memory updates
                        add(realm.query(Memory::class), "Memory subscription")
                    }
                    .build()
                Realm.open(config).also { Log.d("RealmProvider", "Successfully initialized realm: ${it.configuration}") }
            }
        }
    }

    fun close() {
        realm?.let { it.close() }
    }
}
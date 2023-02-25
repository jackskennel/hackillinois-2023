package com.hackillinois.snapchatUIComposeClone.common.models

import org.mongodb.kbson.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

data class Location(val latitude: Double = 0.0, val longitude: Double = 0.0)

private val SIEBEL = Location(40.11395268359537, -88.22499888074972)

class Memory : RealmObject {
    /**
     * The primary key of the memory
     */
    @PrimaryKey
    var _id: ObjectId = ObjectId.invoke()

    /**
     * The ID of the owner of the memory
     */
    var owner_id: ObjectId = ObjectId.invoke()

    /**
     * The name of the memory
     */
    var name: String = ""

    /**
     * The latitude of the location of the memory
     */
    var latitude: Double = SIEBEL.latitude

    /**
     * The longitude of the location of the memory
     */
    var longitude: Double = SIEBEL.longitude

    /**
     * The content of the memory
     */
    var content: ByteArray = byteArrayOf()

    var uploadedAt: Long = 0

    /**
     * When the memory unlocks, in seconds since epoch
     */
    var unlockedAt: Long = 0

    override fun toString(): String =
        "Memory(_id=$_id, owner_id=$owner_id, name=${name}, location=(${latitude}, ${longitude}), content=${content}, uploadedAt=${uploadedAt}, unlockedAt=${unlockedAt})"
}


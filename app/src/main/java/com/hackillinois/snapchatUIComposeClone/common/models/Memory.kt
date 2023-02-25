package com.hackillinois.snapchatUIComposeClone.common.models

import org.mongodb.kbson.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.BsonBinary

data class Location(
    val latitude: Double,
    val longitude: Double
)

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
     * The location of the memory
     */
    var location: Location = SIEBEL

    /**
     * The content of the memory
     */
    var content: BsonBinary = BsonBinary(byteArrayOf())

    /**
     * When the memory unlocks, in seconds since epoch
     */
    var unlocksAt: Long = 0

    override fun toString(): String =
        "Memory(_id=$_id, owner_id=$owner_id, location=(${location.latitude},${location.longitude}), content=${content})"
}


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
    @PrimaryKey
    val _id: ObjectId = ObjectId.invoke()
//    var owner_id: ObjectId = ObjectId.invoke()
//    var location: Location = SIEBEL
//    var content: BsonBinary = BsonBinary(byteArrayOf())

//    constructor(owner_id: ObjectId, location: Location, content: BsonBinary) : this() {
//        this.owner_id = owner_id
//        this.location = location
//        this.content = content
//    }
}


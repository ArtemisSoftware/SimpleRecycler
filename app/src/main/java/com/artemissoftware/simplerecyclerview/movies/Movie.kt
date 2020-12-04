package com.artemissoftware.simplerecyclerview.movies

import java.util.*

class Movie(val id: String, var name: String, var rating: String) {

    constructor(name: String, rating: String) : this(UUID.randomUUID().toString(), name, rating)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Movie

        if (id != other.id) return false
        if (name != other.name) return false
        if (rating != other.rating) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + rating.hashCode()
        return result
    }


}
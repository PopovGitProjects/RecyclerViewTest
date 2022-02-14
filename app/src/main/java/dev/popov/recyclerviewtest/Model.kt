package dev.popov.recyclerviewtest

import java.io.Serializable

data class Model(
    val imageID: Int,
    val title: String,
    val discr: String
): Serializable

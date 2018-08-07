package ua.raylyan.cleanarch.presentation

import java.util.*

fun <T> Collection<T>.getRandomElement(): T {
    val randomIndex = Random().nextInt(this.size)
    return this.elementAt(randomIndex)
}

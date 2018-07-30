package ua.raylyan.cleanarch.domain.contract.entity

data class Address(
        val street: String,
        val suite: String,
        val city: String,
        val zipCode: String,
        val location: Location
)
package com.soar.network.bean.response

import java.io.Serializable

data class RecipesItem(
        val calories: String = "",
        val carbos: String = "",
        val card: String = "",
        val country: String = "",
        val deliverable_ingredients: List<String> = listOf(),
        val description: String = "",
        val difficulty: Int = 0,
        val fats: String = "",
        val favorites: Int = 0,
        val fibers: String = "",
        val headline: String = "",
        val highlighted: Boolean = false,
        val id: String = "",
        val image: String = "",
        val incompatibilities: String = "",
        val ingredients: List<String> = listOf(),
        val keywords: List<String> = listOf(),
        val name: String = "",
        val products: List<String> = listOf(),
        val proteins: String = "",
        val rating: Double = 0.0,
        val ratings: Int = 0,
        val thumb: String = "",
        val time: String = "",
        val undeliverable_ingredients: List<String> = listOf(),
        val user: User = User(),
        val weeks: List<String> = listOf()
): Serializable

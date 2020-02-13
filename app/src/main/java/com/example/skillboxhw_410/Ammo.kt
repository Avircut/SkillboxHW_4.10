package com.example.skillboxhw_410

import kotlin.random.Random

enum class Ammo (
    private val damage:Int,
    private val critChance: Int,
    private val critAmplify: Int
) {
    DEFAULT(20, 10, 2),
    AKAMMO(35, 10, 2),
    SNIPERAMMO(50, 20, 4);

    fun dealDamage(): Int {
        return if (Random.nextInt( 100) < critChance)
            (damage * critAmplify)
        else damage
    }
}
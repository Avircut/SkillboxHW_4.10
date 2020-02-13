package com.example.skillboxhw_410

interface Warrior {
    var currentHP:Int
    var isKilled: Boolean
    val chanceToEvade: Int
    fun attack(enemy:Warrior)
    fun takeDamage(incDmg:Int)
}
package com.example.skillboxhw_410.Warriors

import com.example.skillboxhw_410.AbstractWarrior
import com.example.skillboxhw_410.Weapons
import kotlin.random.Random

class Charger(
    override var isKilled: Boolean=false
):AbstractWarrior(Random.nextInt(100),225,40,Weapons.mp7,25)
{
    override var currentHP: Int=maximumHP
}
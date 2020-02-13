package com.example.skillboxhw_410.Warriors

import com.example.skillboxhw_410.AbstractWarrior
import com.example.skillboxhw_410.Weapons
import kotlin.random.Random

class Sniper(
    override var isKilled: Boolean=false
):AbstractWarrior(Random.nextInt(100),80,100,Weapons.awp,5)
{
    override var currentHP: Int=maximumHP
}
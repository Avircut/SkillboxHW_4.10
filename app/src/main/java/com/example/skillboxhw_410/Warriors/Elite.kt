package com.example.skillboxhw_410.Warriors

import com.example.skillboxhw_410.AbstractWarrior
import com.example.skillboxhw_410.Weapons
import kotlin.random.Random

class Elite(
    override var isKilled: Boolean=false
):AbstractWarrior(Random.nextInt(100),190,65,Weapons.ak47,15)
{
    override var currentHP: Int=maximumHP
}
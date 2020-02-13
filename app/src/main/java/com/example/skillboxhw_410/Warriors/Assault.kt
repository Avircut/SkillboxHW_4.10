package com.example.skillboxhw_410.Warriors

import com.example.skillboxhw_410.AbstractWarrior
import com.example.skillboxhw_410.Weapons
import kotlin.random.Random

class Assault(
    override var isKilled: Boolean=false
):AbstractWarrior(Random.nextInt(100),140,65,Weapons.m4a1,10)
{
    override var currentHP: Int=maximumHP
}
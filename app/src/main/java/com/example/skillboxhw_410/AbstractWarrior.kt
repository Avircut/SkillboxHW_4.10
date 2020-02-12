package com.example.skillboxhw_410

import kotlin.math.max
import kotlin.random.Random

abstract class AbstractWarrior(
    val id:Int,
    val maximumHP:Int,
    val accuracy: Int,
    val weapon: AbstractWeapon,
    override val chanceToEvade: Int
):Warrior{
    init {
        currentHP=maximumHP
    }

    fun checkForHit(enemy:Warrior):Boolean{
        if(Random.nextInt(0,100)<accuracy)
            if(Random.nextInt(100)<enemy.chanceToEvade)
                return true
        return false
    }
    override fun attack(enemy: Warrior) {
        var currentOutcomeDamage:Int=0
        val gotammo=weapon.getAmmo()
        if(gotammo!=null){
            when(weapon.fireType) {
                FireType.burst -> {
                    repeat(3) {
                        if (checkForHit(enemy)) currentOutcomeDamage += gotammo.dealDamage()
                    }
                }
                FireType.single -> {
                    if (checkForHit(enemy)) currentOutcomeDamage += gotammo.dealDamage()
                }
            }
        }
        else weapon.reload()
        enemy.takeDamage(currentOutcomeDamage)
    }

    override fun takeDamage(incDmg: Int) {
        currentHP= max(currentHP-incDmg,0)
        if(currentHP==0) isKilled=true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AbstractWarrior

        if (id != other.id) return false
        if (maximumHP != other.maximumHP) return false
        if (accuracy != other.accuracy) return false
        if (weapon != other.weapon) return false
        if (chanceToEvade != other.chanceToEvade) return false
        if (currentHP != other.currentHP) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + maximumHP
        result = 31 * result + accuracy
        result = 31 * result + weapon.hashCode()
        result = 31 * result + chanceToEvade
        result = 31 * result + currentHP
        return result
    }

}
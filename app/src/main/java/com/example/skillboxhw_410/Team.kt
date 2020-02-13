package com.example.skillboxhw_410

import com.example.skillboxhw_410.Warriors.Assault
import com.example.skillboxhw_410.Warriors.Charger
import com.example.skillboxhw_410.Warriors.Elite
import com.example.skillboxhw_410.Warriors.Sniper
import kotlin.random.Random

class Team (
    val warriorAmount:Int
){
    val listOfWarriors= mutableListOf<Warrior>()

    init{
        fillTheTeam()
    }
    private fun fillTheTeam(){
        var currentWarriorsCount:Int=0
        while (currentWarriorsCount<warriorAmount){
            when(Random.nextInt(0,100)){
                in 0..10->listOfWarriors.add(Elite(false))
                in 10..30->listOfWarriors.add(Sniper(false))
                in 30..70->listOfWarriors.add(Charger(false))
                in 70..100->listOfWarriors.add(Assault(false))
            }
            currentWarriorsCount++
        }
    }
}
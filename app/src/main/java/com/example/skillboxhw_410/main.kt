package com.example.skillboxhw_410


fun main() {
    println("Enter the team's warriors count")
    val warrioramount:Int= enterTheNumber()
    val team1=Team(warriorAmount= warrioramount)
    val team2=Team(warriorAmount = warrioramount)
    val battle =Battle(team1 = team1,team2 = team2)
    while(!battle.isBattleEnded){
        battle.battleIteration()
        battle.getAState()
    }
}
object Weapons:AbstractWeapon(ammoAmount = 30, fireType = FireType.single){
    val m4a1 =object:AbstractWeapon(ammoAmount = 30, fireType = FireType.single){
        override fun ammoCreate(): Ammo =Ammo.DEFAULT
    }
    val ak47 =object:AbstractWeapon(ammoAmount = 30, fireType = FireType.burst){
        override fun ammoCreate(): Ammo =Ammo.AKAMMO
    }
    val awp =object:AbstractWeapon(ammoAmount = 10, fireType = FireType.single){
        override fun ammoCreate(): Ammo =Ammo.SNIPERAMMO
    }
    val mp7 =object:AbstractWeapon(ammoAmount = 30, fireType = FireType.burst){
        override fun ammoCreate(): Ammo =Ammo.DEFAULT
    }

    override fun ammoCreate(): Ammo =Ammo.DEFAULT
}
fun enterTheNumber():Int {
    readLine()?.toIntOrNull()
        ?.let { N ->
            return N
        }
        ?: println("Вы ввели не число")
    return enterTheNumber()
}
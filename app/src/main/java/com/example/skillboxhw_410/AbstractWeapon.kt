package com.example.skillboxhw_410

abstract class AbstractWeapon (
    val ammoAmount: Int,
    val fireType: FireType
){
    var currentAmmo: MutableList<Ammo>

    init {
        currentAmmo= mutableListOf<Ammo>()
    }
    var isAmmoThere: Boolean=false

    abstract fun ammoCreate():Ammo
    fun reload(){
        currentAmmo.clear()
        while(currentAmmo.size<ammoAmount){
            currentAmmo.add(ammoCreate())
        }
        isAmmoThere=true
    }
    fun checkForAmmo():Boolean{
        return when(fireType){
            FireType.burst->currentAmmo.size>2
            FireType.single->currentAmmo.size>0
        }
    }
    fun getAmmo():Ammo?{
        var gotammo:Ammo
        if(checkForAmmo()) {
            when (fireType) {
                FireType.burst -> {
                    gotammo = currentAmmo[currentAmmo.lastIndex]
                    currentAmmo.removeAt(currentAmmo.lastIndex)
                    currentAmmo.removeAt(currentAmmo.lastIndex)
                    currentAmmo.removeAt(currentAmmo.lastIndex)
                }
                FireType.single -> {
                    gotammo = currentAmmo[currentAmmo.lastIndex]
                    currentAmmo.removeAt(currentAmmo.lastIndex)
                }
            }
            return gotammo
        }
        else return null
    }
}
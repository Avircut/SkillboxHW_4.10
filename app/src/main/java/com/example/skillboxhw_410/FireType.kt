package com.example.skillboxhw_410

sealed class FireType (
    ammoAmount: Int
){
    object single: FireType(1)
    object burst: FireType(3)
}

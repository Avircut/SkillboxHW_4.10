package com.example.skillboxhw_410

sealed class BattleState(
) {
    object Progress:BattleState()
    object Team1Won:BattleState()
    object Team2Won:BattleState()
    object Draw:BattleState()
}
package com.example.skillboxhw_410

import kotlin.concurrent.timer

class Battle (
    private var team1:Team,
    private var team2:Team
){

    var isBattleEnded:Boolean=false
    private set
    fun printAState(state:BattleState){
        when(state){
            BattleState.Progress->{
                var team1Health:Int=0
                var team2Health:Int=0
                for(warrior in team1.listOfWarriors){
                    team1Health+=warrior.currentHP
                }
                for(warrior in team2.listOfWarriors){
                    team2Health+=warrior.currentHP
                }
                println("[Battle] Team1 Health: $team1Health | Team2: Health:$team2Health")
                return
            }
            BattleState.Draw->println("Battle has ended. Draw!")
            BattleState.Team1Won->println("Battle has ended. Team 1 Won!")
            BattleState.Team2Won->println("Battle has ended. Team 2 Won!")
        }
    }
    fun getAState():BattleState{
        var currentState:BattleState=BattleState.Draw
        for(warrior in team1.listOfWarriors){
            if(warrior.isKilled)continue
            else {
                currentState=BattleState.Team1Won
                break
            }
        }
        for(warrior in team2.listOfWarriors){
            if(warrior.isKilled)continue
            else{
                if(currentState!=BattleState.Team1Won) {
                    currentState = BattleState.Team2Won
                    isBattleEnded=true
                }
                else currentState=BattleState.Progress
                break
            }
        }
        if(currentState==BattleState.Team1Won || currentState==BattleState.Draw) isBattleEnded=true
        printAState(currentState)
        return currentState
    }
    fun battleIteration(){
        val warriors=team1.listOfWarriors.shuffled()+team2.listOfWarriors.shuffled()
        warriors.forEach{
            if(it.isKilled)return@forEach
            else if(team1.listOfWarriors.contains(it))
                for(enemy in team2.listOfWarriors){
                    if(!enemy.isKilled) {
                        it.attack(enemy)
                        break
                    }
                    else continue
                }
            else if(team2.listOfWarriors.contains(it))
                for(enemy in team1.listOfWarriors){
                    if(!enemy.isKilled) {
                        it.attack(enemy)
                        break
                    }
                    else continue
                }
        }
        Thread.sleep(100)
    }
}
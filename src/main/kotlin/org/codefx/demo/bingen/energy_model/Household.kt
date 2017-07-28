package org.codefx.demo.bingen.energy_model

import java.util.*

class Household(val maxConsumption: Int) {

    init {
        if (maxConsumption < 0) {
            println("!! MAX CONSUMPTION NEGATIVE")
        }
    }

    val random: Random = Random()

    fun announceConsumption(): EnergyOrder {
        val consumption = random.nextInt(maxConsumption) + 1
        return EnergyOrder(consumption)
    }

    fun consume(energy: Energy) {
        println("Consume $energy, brr...")
    }

}

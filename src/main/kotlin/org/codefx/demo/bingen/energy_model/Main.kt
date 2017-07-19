package org.codefx.demo.bingen.energy_model

fun main(args: Array<String>) {
    val houseHolds = listOf(HouseHold(10), HouseHold(20), HouseHold(30), HouseHold(20), HouseHold(10), HouseHold(10))
    val plants = listOf(PowerPlant(40), PowerPlant(20))
    val exchange = EnergyExchange(houseHolds, plants)

    exchange.simulationStep()
}

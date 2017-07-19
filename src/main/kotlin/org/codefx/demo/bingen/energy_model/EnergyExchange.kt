package org.codefx.demo.bingen.energy_model

class EnergyExchange(val houseHolds: List<HouseHold>, val plants: List<PowerPlant>) {

    fun simulationStep() {
        for (houseHold in houseHolds) {
            val order = houseHold.announceConsumption()
            val produced = fulfillOrderWithSomePlant(order)
            houseHold.consume(produced)
        }
    }

    fun fulfillOrderWithSomePlant(order: EnergyOrder): Energy {
        for (plant in plants) {
            if (plant.canFulfill(order)) {
                return plant.fulfill(order)
            }
        }
        return Energy(0)
    }

}

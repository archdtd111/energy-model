package org.codefx.demo.bingen.energy_model

class EnergyExchange(val households: List<Household>, val plants: List<PowerPlant>) {

    val productionPerPlant: MutableMap<PowerPlant, Energy> = mutableMapOf()

    fun simulationStep() {
        for (houseHold in households) {
            val order = houseHold.announceConsumption()
            val produced = fulfillOrderWithSomePlant(order)
            houseHold.consume(produced)
        }
    }

    fun fulfillOrderWithSomePlant(order: EnergyOrder): Energy {
        for (plant in plants) {
            if (plant.canFulfill(order)) {
                return fulfillOrderWithPlant(order, plant)
            }
        }
        return Energy(0)
    }

    fun fulfillOrderWithPlant(order: EnergyOrder, plant: PowerPlant): Energy {
        val energy = plant.fulfill(order)
        if (productionPerPlant.containsKey(plant)) {
            // add energy to existing amount
            val producedEnergy: Energy = productionPerPlant.get(plant)!!
            val totalEnergy = producedEnergy.add(energy)
            productionPerPlant.put(plant, totalEnergy)
        } else {
            // put plant with energy
            productionPerPlant.put(plant, energy)
        }
        return energy
    }

}

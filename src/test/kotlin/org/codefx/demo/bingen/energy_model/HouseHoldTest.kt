package org.codefx.demo.bingen.energy_model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class HouseHoldTest {

    @Test
    fun houseHoldAnnouncesConsumptionGivenAtConstruction() {
        val houseHold = HouseHold(10)

        val order = houseHold.announceConsumption()

        assertTrue(order.compareTo(EnergyOrder(10)) <= 0)
    }

}

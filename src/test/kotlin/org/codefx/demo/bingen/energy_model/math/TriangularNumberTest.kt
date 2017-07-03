package org.codefx.demo.bingen.energy_model.math

import org.junit.Assert.assertEquals
import org.junit.Test

class TriangularNumberTest {

    @Test
    fun isTriangularNumber10() {
        val test = isTriangularNumber(10)
        assertEquals(true, test)
    }

    @Test
    fun isTriangularNumberMinus10() {
        val test = isTriangularNumber(-10)
        assertEquals(false, test)
    }

    @Test
    fun isTriangularNumber20() {
        val test = isTriangularNumber(20)
        assertEquals(false, test)
    }

    @Test
    fun isTriangularNumber1225() {
        val test = isTriangularNumber(1225)
        assertEquals(true, test)
    }


}
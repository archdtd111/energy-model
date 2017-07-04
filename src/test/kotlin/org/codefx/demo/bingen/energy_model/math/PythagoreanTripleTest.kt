package org.codefx.demo.bingen.energy_model.math

import org.junit.Assert.assertEquals
import org.junit.Test

class PythagoreanTripleTest {

    @Test
    fun isPythagoreanTriple1() {
        val result = isPythagoreanTriple(3 , 4 , 5)
        assertEquals(true, result)
    }

    @Test
    fun isPythagoreanTriple2() {
        val result = isPythagoreanTriple(2 , 2 , 2)
        assertEquals(false, result)
    }

    @Test
    fun isPythagoreanTriple3() {
        val result = isPythagoreanTriple(-3 , 4 , 5)
        assertEquals(false, result)
    }

    @Test
    fun isPythagoreanTriple4() {
        val result = isPythagoreanTriple(140 , 171 , 221)
        assertEquals(true, result)
    }

}
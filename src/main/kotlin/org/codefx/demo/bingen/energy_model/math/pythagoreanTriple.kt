package org.codefx.demo.bingen.energy_model.math

fun isPythagoreanTriple (n_1 : Int , n_2 : Int, n_3: Int) : Boolean {
    // Three numbers are Pythagorean Triples if a combination of the numbers n_1 , n_2 , n_3
    // is able to come up to the following equation (1): a^2 + b^2 = c^2
    val a : Int
    val b : Int
    val c : Int

    var result : Boolean

    // Just positive numbers are possible here
    if (n_1 >= 0 && n_2 >= 0 && n_3 >= 0){
        // The biggest number needs to be the c in the equation (1)
        if (n_1 > n_2 && n_1 > n_3){
            c = n_1
            a = n_2
            b = n_3

        } else if (n_2 > n_1 && n_2 > n_3){
            c = n_2
            a = n_1
            b = n_3
        } else {
            a = n_1
            b = n_2
            c = n_3
        }

        // Now testing the equation (1)

        if (a*a + b*b == c*c){
            result = true
        } else {
            result = false
        }

    } else {
        result = false
    }

    return result
}
package org.codefx.demo.bingen.energy_model.math

fun isTriangularNumber (x : Int) : Boolean {
    var result : Boolean = false

    // A given number is a Triangular Number if the number can be formed out of the sum
    // of the infinite row 1 ; 2 ; 3 ; 4 ; 5 ; 6 ; ...
    // Example
    // The number 10 is a Triangular Number as 10 equals 1+2+3+4

    var calculatedSum : Int = 0
    var iteratedNumber : Int = 0

    // Our approach is to sum up the numbers of the theoretically infinite row until the
    // calculated sum equals the given number or the calculated sum is greater than
    // the given number (as the number is not a Triangular Number in this case).
    // Also just positive numbers are possible.

    if (x < 0){
        result = false
    } else {

        while (calculatedSum <= x) {

            if (calculatedSum == x) {
                result = true
            }

            calculatedSum = calculatedSum + iteratedNumber
            iteratedNumber = iteratedNumber + 1

        }
    }

        return result

    }
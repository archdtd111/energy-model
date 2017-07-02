package org.codefx.demo.bingen.energy_model.math

fun asRoman(n: Int): String {                               // function --> declaration
    var decimalRemainder = n                                // variable declaration
    var romanOutput = ""
    while (decimalRemainder >= 1) {                         // loop for the construction of Roman numerals

        var Loop = ""

        if (decimalRemainder >= 51 ) {                      // system limits for numbers up to 50
            return "invalid value for roman numerals"
        } else {
            if (decimalRemainder == 50 && Loop == "") {     // If-conditions for each relevant number
                romanOutput += "L"
                decimalRemainder -= 50
                Loop += "1"
            }
            if (decimalRemainder >= 40 && Loop == "") {
                romanOutput += "XL"
                decimalRemainder -= 40
                Loop += "1"
            }
            if (decimalRemainder >= 10 && Loop == "") {
                romanOutput += "X"
                decimalRemainder -= 10
                Loop += "1"
            }
            if (decimalRemainder >= 9 && Loop == "") {
                romanOutput += "IX"
                decimalRemainder -= 9
                Loop += "1"
            }
            if (decimalRemainder >= 5 && Loop == "") {
                romanOutput += "V"
                decimalRemainder -= 5
                Loop += "1"
            }
            if (decimalRemainder >= 4 && Loop == "") {
                romanOutput += "IV"
                decimalRemainder -= 4
                Loop += "1"
            }
            if (decimalRemainder >= 1 && Loop == "") {
                romanOutput += "I"
                decimalRemainder -= 1
                Loop += "1"
            }
        }
    }
    return romanOutput                                      // output --> return of the calculated Roman number
}
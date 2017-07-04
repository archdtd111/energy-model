package org.codefx.demo.bingen.energy_model

class Account(var balance: Int, var limit: Int) {

    fun deposit(amount: Int): Int {
        if (amount >= 0)  {
            // Condition the balance is not negative
            balance += amount
            return amount
        }
        else {
            // insufficient balance; pay out 0
            return 0
        }
    }
    fun withdraw(amount: Int): Int {
        if (limit <= balance - amount && amount > 0) {
            // balance suffices, pay out the money

            balance = balance - amount
            return amount
        } else {
            // insufficient balance; pay out 0
            return 0
        }
    }
    fun currentBalance(): Int {
        return balance
    }
}

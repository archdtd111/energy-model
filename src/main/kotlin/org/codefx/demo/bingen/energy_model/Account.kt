package org.codefx.demo.bingen.energy_model

class Account(var balance: Int, var limit: Int) {

    fun deposit(amount: Int): Int {
        balance += amount
        return amount
    }

    fun withdraw(amount: Int): Int {
        if (balance >= amount) {
            // balance suffices, pay out the money
            balance -= amount
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

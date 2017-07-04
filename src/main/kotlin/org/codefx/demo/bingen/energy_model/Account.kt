package org.codefx.demo.bingen.energy_model

class Account(var balance: Int, var limit: Int) {

    fun deposit(amount: Int): Int {
        // only positive amounts are allowed
        if (amount < 0) {
            return 0
        }

        // deposit amount
        balance += amount
        return amount
    }
    fun withdraw(amount: Int): Int {
        // only positive amounts are allowed
        if (amount < 0) {
            return 0
        }

        if (balance - amount >= limit) {
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

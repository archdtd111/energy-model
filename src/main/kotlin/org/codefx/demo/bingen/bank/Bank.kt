package org.codefx.demo.bingen.bank

import org.codefx.demo.bingen.NullSafeComparator

class Bank {

    /*
     * TODO #4: improve [Bank]
     *
     * Currently the bank hands out accounts (e.g. [openAccount] returns an [Account]).
     * That's weird because it allows customers to interact directly with the account
     * without going through the bank.
     *
     * Instead of acting on [Account] entities all methods should receive and return
     * [AccountNumber] values (i.e. data classes). Before starting to write any code
     * consider carefully:
     *
     *  - what should the [AccountNumber] value class have as fields
     *    (think about what your account number looks like but keep it simple)
     *  - who needs to know about the account numbers? the account? the customer? the bank?
     *  - given an account number how does the bank get the corresponding account
     *    (two ideas: collect all accounts in a map[1] or put them all in the list
     *    and search through that)
     *  - if you have any problems, open a PR with what you have
     *
     * [1] https://www.youtube.com/watch?v=FUqD6srpuPY
     */

    val customers: MutableList<Customer> = mutableListOf()

    fun openAccount(customer: Customer, openingDeposit: Money = Money(0), limit: Balance = Balance(0)): Account {
        if (!customers.contains(customer)) {
            println("!! CUSTOMER DOES NOT BELONG TO THIS BANK")
        }

        val newAccount = Account()
        customer.accounts.add(newAccount)
        return newAccount
    }

    fun closeAccount(customer: Customer, account: Account): Money {
        if (!customers.contains(customer)) {
            println("!! CUSTOMER DOES NOT BELONG TO THIS BANK")
            return Money(0)
        }

        if (account.balance.isOverdrawn()) {
            println("!! OVERDRAWN ACCOUNT CAN NOT BE CLOSED")
            return Money(0)
        }

        customer.accounts.remove(account)

        if (customer.accounts.isEmpty()) {
            customers.remove(customer)
        }

        return account.withdrawRemaining()
    }

    fun newCustomer(name: String): Customer {
        val newAccount = Account()
        val newCustomer = Customer(name, newAccount)
        customers.add(newCustomer)
        return newCustomer
    }

    fun balance(account: Account): Balance {
        return account.balance
    }

    fun deposit(account: Account, amount: Money): Money {
        return account.deposit(amount)
    }

    fun withdraw(account: Account, amount: Money): Money {
        return account.deposit(amount)
    }

    fun transferBetweenAccounts(from: Account, to: Account, amount: Money): Money {
        val withdrawnAmount = from.withdraw(amount)
        to.deposit(withdrawnAmount)
        // TODO: reporting
        return withdrawnAmount
    }

    fun transferBetweenCustomers(from: Customer, to: Customer, amount: Money): Money {
        val fromAccount = from.defaultAccount
        val toAccount = from.defaultAccount
        return transferBetweenAccounts(fromAccount, toAccount, amount)
    }

    override fun toString(): String {
        var string = "Bank:"
        // note that customers.sortWith sorts the customers list
        // whereas customers.sortedWith returns a new list that is sorted,
        // i.e. customers remains unchanged
        for (customer in customers.sortedWith(CustomerByNameComparator())) {
            string += "\n\t$customer"
        }
        return string
    }

}

class CustomerByNameComparator: NullSafeComparator<Customer> {

    override fun compareNonNull(o1: Customer, o2: Customer): Int {
        // to compare customers by name we can fall back to String's compareTo method
        return o1.name.compareTo(o2.name)
    }

}

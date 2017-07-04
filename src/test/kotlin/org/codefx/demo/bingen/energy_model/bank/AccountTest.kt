package org.codefx.demo.bingen.energy_model.bank

import org.junit.Assert.assertEquals
import org.junit.Test

class AccountTest {

    /*
     * THESE TESTS PASS WHEN THE CODE WAS CHECKED OUT
     */

    @Test
    fun newAccountHasSpecifiedBalance() {
        // SETUP
        val account = Account (balance = 100, limit = 0)

        // EXECUTE
        val balance = account.currentBalance()

        // ASSERT
        assertEquals(100, balance)
    }

    @Test
    fun depositIncreasesBalance() {
        // SETUP
        val account = Account (balance = 0, limit = 0)

        // EXECUTE
        account.deposit(50)

        // ASSERT
        val balance = account.currentBalance()
        assertEquals(50, balance)
    }

    @Test
    fun withdrawalDecreasesBalance() {
        // SETUP
        val account = Account (balance = 100, limit = 0)

        // EXECUTE
        val received = account.withdraw(60)

        // ASSERT
        assertEquals(60, received)
        val balance = account.currentBalance()
        assertEquals(40, balance)
    }

    /*
     * THESE TESTS DON'T PASS - IMPROVE 'Account' SO THEY DO
     */

    @Test
    fun negativeDepositDoesNotChangeBalance() {
        // SETUP
        val account = Account (balance = 100, limit = 0)

        // EXECUTE
        val deposited = account.deposit(-50)

        // ASSERT
        assertEquals(0, deposited)
        val balance = account.currentBalance()
        assertEquals(100, balance)
    }

    @Test
    fun negativeWithdrawalDoesNotChangeBalance() {
        // SETUP
        val account = Account (balance = 100, limit = 0)

        // EXECUTE
        val received = account.withdraw(-50)

        // ASSERT
        assertEquals(0, received)
        val balance = account.currentBalance()
        assertEquals(100, balance)
    }

    @Test
    fun accountCanBeOverdrawnToLimit() {
        // SETUP
        val account = Account (balance = 100, limit = -100)

        // EXECUTE
        val received = account.withdraw(150)

        // ASSERT
        assertEquals(150, received)
        val balance = account.currentBalance()
        assertEquals(-50, balance)
    }

}

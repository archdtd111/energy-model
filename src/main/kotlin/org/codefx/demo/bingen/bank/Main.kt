package org.codefx.demo.bingen.bank

import com.univocity.parsers.common.record.Record
import com.univocity.parsers.csv.CsvParser
import com.univocity.parsers.csv.CsvParserSettings
import com.univocity.parsers.csv.CsvWriter
import com.univocity.parsers.csv.CsvWriterSettings
import org.codefx.demo.bingen.FileAccess

/*
 * TODO #5: Read/write the bank
 *
 * Use the readBankFromCsv and writeBankToCsv methods to read/write the bank.
 * Depending on the other tasks, it is possible that the code needs to be changed.
 */

fun main(args: Array<String>) {
    val bank = Bank()

    val john = bank.newCustomer("John Doe")
    val jane = bank.newCustomer("Jane Doe")
    val jennifer = bank.newCustomer("Jennifer Doe")

    bank.deposit(john.defaultAccount, Money(3500))
    bank.deposit(jane.defaultAccount, Money(3500))
    bank.deposit(jennifer.defaultAccount, Money(50))

    println(bank)

    val savings = bank.openAccount(jane, limit = Balance(-5000))
    bank.transferBetweenAccounts(john.defaultAccount, savings, Money(1000))
    bank.transferBetweenAccounts(jane.defaultAccount, savings, Money(1500))

    println(bank)
    println(savings)
}

//private fun readBankFromCsv(fileName: String): Bank {
//    val settings = CsvParserSettings()
//    settings.format.setLineSeparator("\n")
//    settings.isHeaderExtractionEnabled = true
//
//    val csvParser = CsvParser(settings)
//    val reader = FileAccess().getReader(fileName)
//    val customerRows: MutableList<Record> = csvParser.parseAllRecords(reader)
//
//    val bank = Bank()
//
//    for (record in customerRows) {
//        val name = record.values.get(0)
//        val newCustomer = bank.newCustomer(name)
//
//        val balanceCents = recordValueToCents(record, 1)
//        val limitCents = recordValueToCents(record, 2)
//
//        newCustomer.defaultAccount.limit = Balance(limitCents)
//        newCustomer.defaultAccount.deposit(Money(balanceCents))
//    }
//
//    return bank
//}
//
//private fun recordValueToCents(record: Record, index: Int): Int {
//    // record -> extract string
//    val string = record.getString(index)
//    // string -> double
//    val double = string.toDouble()
//    // double -> value * 100
//    val doubleCents = double * 100
//    // double -> int
//    val intCents = doubleCents.toInt()
//    return intCents
//
//    // less readable but fewer lines:
////    return (record.getString(index).toDouble() * 100).toInt()
//}
//
//private fun writeBankToCsv(bank: Bank, fileName: String) {
//    val settings = CsvWriterSettings()
//    settings.format.setLineSeparator("\n")
//
//    val writer = FileAccess().getWriter(fileName)
//    val csvWriter = CsvWriter(writer, settings)
//    csvWriter.writeHeaders("Customer", "Balance", "Limit")
//
//    val customerRows: MutableList<Array<Any>> = mutableListOf()
//    for (customer in bank.customers) {
//        val name = customer.name
//        val balance = centsToString(customer.defaultAccount.balance.centAmount)
//        val limit = centsToString(customer.defaultAccount.limit.centAmount)
//        val row: Array<Any> = arrayOf(name, balance, limit)
//        customerRows.add(row)
//    }
//
//    csvWriter.writeRowsAndClose(customerRows)
//}
//
//private fun centsToString(cents: Int): String {
//    val amount: Double = cents / 100.0
//    val string = "%.2f".format(amount)
//    return string
//}

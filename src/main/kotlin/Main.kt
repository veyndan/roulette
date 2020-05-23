@file:Suppress(
    "EXPERIMENTAL_API_USAGE",
    "EXPERIMENTAL_FEATURE_WARNING",
)

import org.javamoney.moneta.Money
import javax.money.Monetary

private val CURRENCY = Monetary.getCurrency("USD")

fun main() {
    val initialFunds = Money.of(100, CURRENCY)
    val desiredFunds = Money.of(150, CURRENCY)

    val initialWager = Money.of(1, CURRENCY)

    var funds = initialFunds

    println("FUNDS: $initialFunds")

    // Doesn't terminate as fold isn't lazy
    Roulette().spins()
        .map { it.color }
        .fold(listOf(initialFunds to initialWager)) { history, color ->
            val (funds1, wager) = history.last()

            funds = funds1

            funds -= wager

            println("$color funds($funds) wager($wager)")

            if (color == Roulette.Color.RED) {
                funds += wager * Roulette.Color.RED.payout.value
                history + (funds to Money.of(1, CURRENCY))
            } else {
                history + (funds to if (funds < wager) Money.of(1, CURRENCY) else wager * 2)
            }
        }
        .takeWhile { funds in Money.zero(CURRENCY)..desiredFunds }

    println("FUNDS: $funds")
}

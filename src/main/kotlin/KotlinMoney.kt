import org.javamoney.moneta.Money
import javax.money.MonetaryAmount

operator fun Money.plus(amount: MonetaryAmount): Money = add(amount)
operator fun Money.minus(subtrahend: MonetaryAmount): Money = subtract(subtrahend)
operator fun Money.times(multiplicand: Long): Money = multiply(multiplicand)

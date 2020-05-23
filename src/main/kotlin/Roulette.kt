@file:Suppress(
    "EXPERIMENTAL_API_USAGE",
    "EXPERIMENTAL_FEATURE_WARNING",
)

class Roulette {

    fun spins() = generateSequence { Number.values().random() }

    enum class Number(val color: Color) {

        ZERO(Color.GREEN),
        ONE(Color.RED),
        TWO(Color.BLACK),
        THREE(Color.RED),
        FOUR(Color.BLACK),
        FIVE(Color.RED),
        SIX(Color.BLACK),
        SEVEN(Color.RED),
        EIGHT(Color.BLACK),
        NINE(Color.RED),
        TEN(Color.BLACK),
        ELEVEN(Color.BLACK),
        TWELVE(Color.RED),
        THIRTEEN(Color.BLACK),
        FOURTEEN(Color.RED),
        FIFTEEN(Color.BLACK),
        SIXTEEN(Color.RED),
        SEVENTEEN(Color.BLACK),
        EIGHTEEN(Color.RED),
        NINETEEN(Color.RED),
        TWENTY(Color.BLACK),
        TWENTY_ONE(Color.RED),
        TWENTY_TWO(Color.BLACK),
        TWENTY_THREE(Color.RED),
        TWENTY_FOUR(Color.BLACK),
        TWENTY_FIVE(Color.RED),
        TWENTY_SIX(Color.BLACK),
        TWENTY_SEVEN(Color.RED),
        TWENTY_EIGHT(Color.BLACK),
        TWENTY_NINE(Color.BLACK),
        THIRTY(Color.RED),
        THIRTY_ONE(Color.BLACK),
        THIRTY_TWO(Color.RED),
        THIRTY_THREE(Color.BLACK),
        THIRTY_FOUR(Color.RED),
        THIRTY_FIVE(Color.BLACK),
        THIRTY_SIX(Color.RED)
    }

    interface IPayout {

        val payout: Payout
    }

    enum class Color : IPayout {

        BLACK, RED, GREEN;

        override val payout = Payout(2)
    }
}

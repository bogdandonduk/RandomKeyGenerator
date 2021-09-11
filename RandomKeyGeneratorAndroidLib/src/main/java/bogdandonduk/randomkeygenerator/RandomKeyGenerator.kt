package bogdandonduk.randomkeygenerator

import kotlin.random.Random

object RandomKeyGenerator {
    fun generateWithPrefix(prefix: String, regenerationPredicate: ((attemptKey: String) -> Boolean)? = null) : String {
        var key = "${prefix}_${Random.nextInt(0, 1000000000)}"

        if(regenerationPredicate != null)
            while(regenerationPredicate.invoke(key)) {
                key = "${prefix}_${Random.nextInt(0, 1000000000)}"
            }

        return key
    }

    fun generateWithClassPrefix(host: Any, regenerationPredicate: ((attemptKey: String) -> Boolean)? = null) : String {
        var key = "${host::class.java}_${Random.nextInt(0, 1000000000)}"

        if(regenerationPredicate != null)
            while(regenerationPredicate.invoke(key)) {
                key = "${host::class.java}_${Random.nextInt(0, 1000000000)}"
            }

        return key
    }
}
package com.github.nianliu.structural_patterns

class Chinese(val content: String)

open class English(val content: String)

class EnglishSpeaker {
    fun hear(english: English) {
        val decoded = when (english.content) {
            "one" -> 1
            "two" -> 2
            "three" -> 3
            else -> throw IllegalArgumentException("I heard something that I don't understand: ${english.content}")
        }
        println("I heard number $decoded")
    }
}

class EnglishChineseAdapter(chinese: Chinese) : English(translateChinesToEnglish(chinese)) {

    companion object {
        fun translateChinesToEnglish(cn: Chinese): String {
            return when (cn.content) {
                "一" -> "one"
                "二" -> "two"
                "三" -> "three"
                else -> throw IllegalArgumentException("Out of my understanding Chinese ${cn.content}")
            }
        }
    }
}

class Adapter {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val englishSpeaker = EnglishSpeaker()

            englishSpeaker.hear(English("one"))
            englishSpeaker.hear(English("two"))
            englishSpeaker.hear(English("three"))

            englishSpeaker.hear(EnglishChineseAdapter(Chinese("一")))
            englishSpeaker.hear(EnglishChineseAdapter(Chinese("二")))
            englishSpeaker.hear(EnglishChineseAdapter(Chinese("三")))

            englishSpeaker.hear(EnglishChineseAdapter(Chinese("五")))
        }
    }
}

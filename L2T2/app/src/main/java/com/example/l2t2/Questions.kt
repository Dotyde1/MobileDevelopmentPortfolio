package com.example.l2t2

data class Questions(
    var questionText: String,
    var QuestionTruth: Boolean
) {
    companion object {
        val questionText = arrayOf(
            "Correct",
            "Incorrect",
            "Correct",
            "Incorrect",
            "Correct",
            "correct"
        )
        val QuestionTruth = arrayOf(
            true,
            false,
            true,
            false,
            true,
            true
        )
    }
}

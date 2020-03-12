package com.example.l3t2


data class Portals(
    var portalName: String,
    var PortalURL: String
) {
    companion object {
        val questionText = arrayOf(
            "Mijn HVA"
        )
        val QuestionTruth = arrayOf(
            "https://fdmci.mijnhva.nl"

        )
    }
}

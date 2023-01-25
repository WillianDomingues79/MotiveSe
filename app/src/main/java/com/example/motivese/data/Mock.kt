package com.example.motivese.data

import com.example.motivese.infra.MotivacaoConstants

class Phrase(val description: String, val categoryId: Int)

class Mock {
    private val sunny = MotivacaoConstants.FILTER.SUNNY

    val mListPhrase = listOf<Phrase>(
        Phrase("", sunny)
    )
}
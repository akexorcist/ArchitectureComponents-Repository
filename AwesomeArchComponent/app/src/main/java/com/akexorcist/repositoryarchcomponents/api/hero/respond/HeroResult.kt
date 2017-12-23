package com.akexorcist.repositoryarchcomponents.api.hero.respond

/**
 * Created by aniru on 22-Dec-17.
 */
data class HeroResult(
        var status: String,
        var message: String,
        var heroes: List<Hero>
)
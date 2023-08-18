package com.chungha.core_domain.model
enum class GenreModel(val genreName: String) {
    ACTION(ACTION_NAME),
    ADVENTURE(ADVENTURE_NAME),
    ACTION_ADVENTURE(ACTION_ADVENTURE_NAME),
    ANIMATION(ANIMATION_NAME),
    COMEDY(COMEDY_NAME),
    CRIME(CRIME_NAME),
    DOCUMENTARY(DOCUMENTARY_NAME),
    DRAMA(DRAMA_NAME),
    FAMILY(FAMILY_NAME),
    FANTASY(FANTASY_NAME),
    HISTORY(HISTORY_NAME),
    HORROR(HORROR_NAME),
    KIDS(KIDS_NAME),
    MUSIC(MUSIC_NAME),
    MYSTERY(MYSTERY_NAME),
    NEWS(NEWS_NAME),
    REALITY(REALITY_NAME),
    ROMANCE(ROMANCE_NAME),
    SCIENCE_FICTION(SCIENCE_FICTION_NAME),
    SCIENCE_FICTION_FANTASY(SCIENCE_FICTION_FANTASY_NAME),
    SOAP(SOAP_NAME),
    TALK(TALK_NAME),
    THRILLER(THRILLER_NAME),
    TV_MOVIE(TV_MOVIE_NAME),
    WAR(WAR_NAME),
    WAR_POLITICS(WAR_POLITICS_NAME),
    WESTERN(WESTERN_NAME);

    companion object {
        private val genres = values().associateBy(GenreModel::genreName)
        operator fun get(genre: String) = checkNotNull(genres[genre]) {
            "$INVALID_GENRE_MESSAGE $genre"
        }
    }
}

private const val ACTION_NAME = "action"
private const val ADVENTURE_NAME = "adventure"
private const val ACTION_ADVENTURE_NAME = "action_adventure"
private const val ANIMATION_NAME = "animation"
private const val COMEDY_NAME = "comedy"
private const val CRIME_NAME = "crime"
private const val DOCUMENTARY_NAME = "documentary"
private const val DRAMA_NAME = "drama"
private const val FAMILY_NAME = "family"
private const val FANTASY_NAME = "fantasy"
private const val HISTORY_NAME = "history"
private const val HORROR_NAME = "horror"
private const val KIDS_NAME = "kids"
private const val MUSIC_NAME = "music"
private const val MYSTERY_NAME = "mystery"
private const val NEWS_NAME = "news"
private const val REALITY_NAME = "reality"
private const val ROMANCE_NAME = "romance"
private const val SCIENCE_FICTION_NAME = "science_fiction"
private const val SCIENCE_FICTION_FANTASY_NAME = "science_fiction_fantasy"
private const val SOAP_NAME = "soap"
private const val TALK_NAME = "talk"
private const val THRILLER_NAME = "thriller"
private const val TV_MOVIE_NAME = "tv_movie"
private const val WAR_NAME = "war"
private const val WAR_POLITICS_NAME = "war_politics"
private const val WESTERN_NAME = "western"

private const val INVALID_GENRE_MESSAGE = "Invalid genre."

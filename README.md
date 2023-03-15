# Jetpack Compose Movie App (Compose + Flow + Hilt + Room + MVVM + Clean + Retrofit)


This is an example of an Android App who uses Jetpack Compose to draw the UI, Kotlin Coroutines Flow to retrieve a list of the recent movies from https://www.themoviedb.org.

## How use this app
- Request an api key from themoviedb https://developers.themoviedb.org/3/getting-started/authentication and later put that key in the build.gradle app file.
- Add movie_preview.apikey= ****

  The **Movie Preview** app has been fully modularized and you can find the detailed guidance and
  description of the modularization strategy used in
  [modularization learning journey](docs/ModularizationLearningJourney.md).

![Modularization graph](docs/images/modularization-graph.png)
## V1 ![](https://geps.dev/progress/100)
- [√] Add Modularization
- [√] Add Search
- [√] Add Convention Plugin

## Features

## Tech Stack

- [Kotlin](https://kotlinlang.org/) - Official programming language for Android development.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Android’s modern toolkit for building native UI.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) and [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html#asynchronous-flow) - Official Kotlin's tooling for performing asynchronous work.
- [Android Jetpack](https://developer.android.com/jetpack) - Jetpack is a suite of libraries to help developers build state-of-the-art applications.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - The ViewModel is designed to store and manage UI-related data in a lifecycle conscious way.
    - [Room](https://developer.android.com/topic/libraries/architecture/room) - The Room library provides an abstraction layer over SQLite to allow for more robust database access.
    - [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Hilt is a dependency injection library for Android.
- [Accompanist](https://github.com/google/accompanist) - A collection of extension libraries for Jetpack Compose.
- [Retrofit](https://github.com/square/retrofit) - A library for building REST API clients.
- [Coil](https://github.com/coil-kt/coil) - An image loading library.
- [Detekt](https://github.com/detekt/detekt) - A static code analysis library for Kotlin.
- [Ktlint](https://github.com/pinterest/ktlint) [(Kotlinter)](https://github.com/jeremymailen/kotlinter-gradle) - A library for formatting Kotlin code according to official guidelines.
- [Twitter Jetpack Compose Rules](https://twitter.github.io/compose-rules/)
- [Gradle's Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - Gradle’s Kotlin DSL is an alternative syntax to the Groovy DSL with an enhanced editing experience.

# References

- [Jetpack Compose](https://developer.android.com/jetpack/compose)

- [Design](https://dribbble.com/shots/18839708-Movie-Tickets-Mobile-App)

- [Build custom bottom navigation Bar](https://www.boltuix.com/2022/08/custom-bottom-navigation-bar.html)

- [Background Gradient](https://semicolonspace.com/android-jetpack-compose-gradient/)

- [Library where I got the horizontal viewpager](https://github.com/google/accompanist)

- [CompositionLocal for the light/dark teme](https://developer.android.com/jetpack/compose/compositionlocal)


## Contributors ✨

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tr>
    <td align="center"><a href="https://github.com/hoangchungk53qx1"><img src="https://avatars.githubusercontent.com/hoangchungk53qx1" width="100px;" alt=""/><br /><sub><b>Hoangchung</b></sub></a><br /></td>
  </tr>
</table>

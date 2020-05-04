package dependencies

/**
 * Project test dependencies, makes it easy to include external binaries or
 * other library modules to build.
 */
object TestDependencies {
    const val ARCH_CORE = "androidx.arch.core:core-testing:${BuildDependenciesVersions.ARCH_CORE}"
    const val ASSERTJ = "org.assertj:assertj-core:${BuildDependenciesVersions.ASSERTJ}"
    const val CORE = "androidx.test:core:${BuildDependenciesVersions.TEST}"
    const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${BuildDependenciesVersions.COROUTINES}"
    const val EXT = "androidx.test.ext:junit:${BuildDependenciesVersions.EXT}"
    const val FRAGMENT_TEST = "androidx.fragment:fragment-testing:${BuildDependenciesVersions.FRAGMENT_TEST}"
    const val JUNIT = "junit:junit:${BuildDependenciesVersions.JUNIT}"
    const val MOCKITO = "com.nhaarman.mockitokotlin2:mockito-kotlin:${BuildDependenciesVersions.MOCKITO}"
    const val MOCKK = "io.mockk:mockk:${BuildDependenciesVersions.MOCKK}"
    const val MOCK_WEB_SERVER = "com.squareup.okhttp3:mockwebserver:${BuildDependenciesVersions.MOCK_WEB_SERVER}"
    const val ROBOELECTRIC = "org.robolectric:robolectric:${BuildDependenciesVersions.ROBOELECTRIC}"
    const val ROOM = "androidx.room:room-testing:${BuildDependenciesVersions.ROOM}"
    const val RULES = "androidx.test:rules:${BuildDependenciesVersions.TEST}"
    const val RUNNER = "androidx.test:runner:${BuildDependenciesVersions.TEST}"

    /**
     * Method to obtain all the test dependencies.
     *
     * @return An array with all the test dependencies.
     */
    fun all() = arrayOf(
        ARCH_CORE,
        ASSERTJ,
        CORE,
        COROUTINES_TEST,
        EXT,
        FRAGMENT_TEST,
        JUNIT,
        MOCKITO,
        MOCKK,
        MOCK_WEB_SERVER,
        ROBOELECTRIC,
        ROOM,
        RULES,
        RUNNER
    )
}

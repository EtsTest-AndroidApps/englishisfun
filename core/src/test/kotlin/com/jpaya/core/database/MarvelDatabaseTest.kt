/*
 * Copyright 2020 Jose Maria Payá Castillo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jpaya.core.database

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.whenever
import com.jpaya.core.database.characterfavorite.CharacterFavoriteDao
import com.jpaya.libraries.testutils.robolectric.TestRobolectric
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.instanceOf
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MarvelDatabaseTest : TestRobolectric() {

    @Mock
    lateinit var marvelDatabase: MarvelDatabase

    @Mock
    lateinit var characterFavoriteDao: CharacterFavoriteDao

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun obtainCharacterFavoriteDao() {
        doReturn(characterFavoriteDao).whenever(marvelDatabase).characterFavoriteDao()

        assertThat(marvelDatabase.characterFavoriteDao(), instanceOf(CharacterFavoriteDao::class.java))
    }
}

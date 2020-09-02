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

package com.jpaya.englishisfun.phrasals.data.db

import androidx.room.Room
import com.jpaya.englishisfun.database.EnglishIsFunDatabase
import com.jpaya.englishisfun.phrasals.domain.Phrasal
import com.jpaya.libraries.testutils.robolectric.TestRobolectric
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DatabaseDataSourceTest : TestRobolectric() {

    private lateinit var dataSource: DatabaseDataSource

    private val item1 = Phrasal(
        id = 1,
        verb = "Verb 1",
        definitions = "Definitions 1"
    )

    private val item2 = Phrasal(
        id = 2,
        verb = "Verb 2",
        definitions = "Definitions 2"
    )

    private val item3 = Phrasal(
        id = 3,
        verb = "Verb 3",
        definitions = "Definitions 3"
    )

    @Before
    fun setUp() {
        val database = Room.inMemoryDatabaseBuilder(context, EnglishIsFunDatabase::class.java).build()
        dataSource = DatabaseDataSource(database.phrasals())
    }

    @Test
    fun `Check phrasals works properly`() = runBlocking {
        val filter = "Verb 1"
        assertEquals(0, dataSource.count())
        assertEquals(0, dataSource.search(filter).size)

        dataSource.save(item1)
        assertEquals(1, dataSource.count())
        assertEquals(1, dataSource.search(filter).size)

        dataSource.save(listOf(item2, item3))
        assertEquals(3, dataSource.count())
        assertEquals(1, dataSource.search(filter).size)

        // Save duplicated item
        dataSource.save(item2)
        assertEquals(3, dataSource.count())
        assertEquals(1, dataSource.search(filter).size)

        val list = dataSource.all()
        assertEquals(3, list.size)
        assertEquals(listOf(item1, item2, item3), list)

        // Delete unexisting element
        dataSource.delete(4)
        assertEquals(3, dataSource.count())
        assertEquals(1, dataSource.search(filter).size)

        dataSource.delete(3)
        assertEquals(2, dataSource.count())
        assertEquals(1, dataSource.search(filter).size)

        dataSource.delete()
        assertEquals(0, dataSource.count())
        assertEquals(0, dataSource.search(filter).size)
    }
}

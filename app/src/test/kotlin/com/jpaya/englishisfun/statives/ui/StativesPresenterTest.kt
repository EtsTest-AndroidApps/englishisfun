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

package com.jpaya.englishisfun.statives.ui

import com.jpaya.englishisfun.statives.domain.Stative
import com.jpaya.englishisfun.statives.domain.StativesInteractor
import com.jpaya.englishisfun.statives.ui.model.StativeItem
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class StativesPresenterTest {

    companion object {
        private val MOCK_STATIVES_LIST = listOf(
            Stative(
                id = 1,
                category = "Category 1",
                verbs = mutableListOf("Verb 1")
            ),
            Stative(
                id = 2,
                category = "Category 2",
                verbs = mutableListOf("Verb 2")
            )
        )
    }

    private lateinit var interactor: StativesInteractor
    private lateinit var presenter: StativesPresenter

    @Before
    fun setUp() {
        interactor = mock()
        presenter = StativesPresenter(interactor)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check getStativeItems works properly`() = runBlocking {
        whenever(interactor.getStativeItems()).doReturn(MOCK_STATIVES_LIST)

        val expectedResult = listOf(
            StativeItem(
                id = 1,
                category = "Category 1",
                verbs = mutableListOf("Verb 1")
            ),
            StativeItem(
                id = 2,
                category = "Category 2",
                verbs = mutableListOf("Verb 2")
            )
        )

        assertEquals(expectedResult, presenter.getStativeItems())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `Check searchStative works properly`() = runBlocking {
        val filter = "Category"
        whenever(interactor.searchStative(filter)).doReturn(MOCK_STATIVES_LIST)

        val expectedResult = listOf(
            StativeItem(
                id = 1,
                category = "Category 1",
                verbs = mutableListOf("Verb 1")
            ),
            StativeItem(
                id = 2,
                category = "Category 2",
                verbs = mutableListOf("Verb 2")
            )
        )

        assertEquals(expectedResult, presenter.searchStative(filter))
    }
}

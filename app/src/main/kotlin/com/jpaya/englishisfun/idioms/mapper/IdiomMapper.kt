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

package com.jpaya.englishisfun.idioms.mapper

import com.jpaya.englishisfun.idioms.data.db.IdiomRoomItem
import com.jpaya.englishisfun.idioms.data.network.model.IdiomsContent
import com.jpaya.englishisfun.idioms.domain.Idioms
import com.jpaya.englishisfun.idioms.ui.model.IdiomItem

fun Idioms.toRoomItem() = IdiomRoomItem(
    id = id,
    idiom = idiom,
    description = description
)

fun IdiomRoomItem.toDomain() = Idioms(
    id = id,
    idiom = idiom,
    description = description
)

fun IdiomsContent.toDomain() = Idioms(
    id = id,
    idiom = idiom,
    description = description
)

fun Idioms.toPresentation() = IdiomItem(
    id = id,
    idiom = idiom,
    description = description
)

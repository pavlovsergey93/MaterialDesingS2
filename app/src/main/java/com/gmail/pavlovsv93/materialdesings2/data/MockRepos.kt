package com.gmail.pavlovsv93.materialdesings2.data

import com.gmail.pavlovsv93.materialdesings2.domain.*
import com.gmail.pavlovsv93.materialdesings2.domain.entity.DataItemListEntity
import com.gmail.pavlovsv93.materialdesings2.domain.entity.TYPE_EARTH
import com.gmail.pavlovsv93.materialdesings2.domain.entity.TYPE_HEADER
import com.gmail.pavlovsv93.materialdesings2.domain.entity.TYPE_MARS

class MockRepos : ReposInterface {
	override fun getDataRepos(): List<Pair<DataItemListEntity, Boolean>> = listOf(
		Pair(DataItemListEntity("Earth1", "3 планета в солнечной системе", TYPE_EARTH), false),
		Pair(DataItemListEntity("Earth1", "3 планета в солнечной системе", TYPE_EARTH), false),
		Pair(DataItemListEntity("Earth1", "3 планета в солнечной системе", TYPE_EARTH), false),
		Pair(DataItemListEntity(title = "Mars1", type = TYPE_MARS), false),
		Pair(DataItemListEntity(title = "Mars1", type = TYPE_MARS), false),
		Pair(DataItemListEntity(title = "Mars1", type = TYPE_MARS), false),
		Pair(DataItemListEntity(title = "Header1", type = TYPE_HEADER), false)
	)
}
package com.gmail.pavlovsv93.materialdesings2.data

import com.gmail.pavlovsv93.materialdesings2.domain.*
import com.gmail.pavlovsv93.materialdesings2.domain.entity.DataItemListEntity
import com.gmail.pavlovsv93.materialdesings2.utils.TYPE_EARTH
import com.gmail.pavlovsv93.materialdesings2.utils.TYPE_HEADER
import com.gmail.pavlovsv93.materialdesings2.utils.TYPE_MARS

class MockRepos : ReposInterface {
	override fun getDataRepos(): List<Pair<DataItemListEntity, Boolean>> = listOf(
		Pair(DataItemListEntity(id = 6,title = "Header1", type = TYPE_HEADER), false),
		Pair(DataItemListEntity(id = 0,"Earth1", "3 планета в солнечной системе", TYPE_EARTH), false),
		Pair(DataItemListEntity(id = 1,"Earth1", "3 планета в солнечной системе", TYPE_EARTH), false),
		Pair(DataItemListEntity(id = 2,"Earth1", "3 планета в солнечной системе", TYPE_EARTH), false),
		Pair(DataItemListEntity(id = 3,title = "Mars1", type = TYPE_MARS), false),
		Pair(DataItemListEntity(id = 4,title = "Mars1", type = TYPE_MARS), false),
		Pair(DataItemListEntity(id = 5,title = "Mars1", type = TYPE_MARS), false)

	)

	override fun getOtherDataRepos(): List<Pair<DataItemListEntity, Boolean>> = listOf(
		Pair(DataItemListEntity(id = 0,"Earth1", "3 планета в солнечной системе", TYPE_EARTH), false),
		Pair(DataItemListEntity(id = 1,"Земля", "3 планета", TYPE_EARTH), false),
		Pair(DataItemListEntity(id = 6,title = "Заголовок", type = TYPE_HEADER), false),
		Pair(DataItemListEntity(id = 2,"Юпитер", "5 планета в солнечной системе", TYPE_EARTH), false),
		Pair(DataItemListEntity(id = 3,title = "Mars", type = TYPE_MARS), false),
		Pair(DataItemListEntity(id = 4,title = "Mars", type = TYPE_MARS), false),
		Pair(DataItemListEntity(id = 5,title = "Mars1", type = TYPE_MARS), false)
	)
}
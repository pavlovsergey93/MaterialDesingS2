package com.gmail.pavlovsv93.materialdesings2.data

import com.gmail.pavlovsv93.materialdesings2.domain.*
import com.gmail.pavlovsv93.materialdesings2.domain.entity.DataItemListEntity
import com.gmail.pavlovsv93.materialdesings2.domain.entity.TYPE_EARTH
import com.gmail.pavlovsv93.materialdesings2.domain.entity.TYPE_HEADER
import com.gmail.pavlovsv93.materialdesings2.domain.entity.TYPE_MARS

class MockRepos: ReposInterface {
	override fun getDataRepos(): List<DataItemListEntity> = listOf(
			DataItemListEntity(title = "Earth1", description = "3 планета в солнечной системе", type = TYPE_EARTH),
			DataItemListEntity(title = "Earth2", description = "3 планета в солнечной системе", type = TYPE_EARTH),
			DataItemListEntity(title = "Earth3", description = "3 планета в солнечной системе", type = TYPE_EARTH),
			DataItemListEntity(title = "Earth4", description = "3 планета в солнечной системе", type = TYPE_EARTH),
			DataItemListEntity(title = "Earth5", description = "3 планета в солнечной системе", type = TYPE_EARTH),
			DataItemListEntity(title = "Earth6", description = "3 планета в солнечной системе", type = TYPE_EARTH),
			DataItemListEntity(title = "Earth7", description = "3 планета в солнечной системе", type = TYPE_EARTH),
			DataItemListEntity(title = "Mars1", type = TYPE_MARS),
			DataItemListEntity(title = "Mars2", type = TYPE_MARS),
			DataItemListEntity(title = "Mars3", type = TYPE_MARS),
			DataItemListEntity(title = "Mars4", type = TYPE_MARS),
			DataItemListEntity(title = "Mars5", type = TYPE_MARS),
			DataItemListEntity(title = "Mars6", type = TYPE_MARS),
			DataItemListEntity(title = "Mars7", type = TYPE_MARS),
			DataItemListEntity(title = "Header1", type = TYPE_HEADER),
			DataItemListEntity(title = "Header2", type = TYPE_HEADER),
			DataItemListEntity(title = "Header3", type = TYPE_HEADER),
			DataItemListEntity(title = "Header4", type = TYPE_HEADER),
			DataItemListEntity(title = "Header5", type = TYPE_HEADER)
		)
}
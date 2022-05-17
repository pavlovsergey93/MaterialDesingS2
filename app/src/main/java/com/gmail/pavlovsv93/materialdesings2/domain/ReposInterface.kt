package com.gmail.pavlovsv93.materialdesings2.domain

import com.gmail.pavlovsv93.materialdesings2.domain.entity.DataItemListEntity

interface ReposInterface {
	fun getDataRepos(): List<Pair<DataItemListEntity, Boolean>>
	fun getOtherDataRepos(): List<Pair<DataItemListEntity, Boolean>>
}
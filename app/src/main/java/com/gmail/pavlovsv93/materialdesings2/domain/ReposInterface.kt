package com.gmail.pavlovsv93.materialdesings2.domain

import com.gmail.pavlovsv93.materialdesings2.domain.entity.DataItemListEntity

interface ReposInterface {
	fun getDataRepos(): List<DataItemListEntity>
}
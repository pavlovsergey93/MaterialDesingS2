package com.gmail.pavlovsv93.materialdesings2.domain.entity

// todo константы для type Entity
const val TYPE_EARTH: Int = 1
const val TYPE_MARS: Int = 2
const val TYPE_HEADER: Int = 3

data class DataItemListEntity(
	val title: String,
	var description: String? = null,
	val type: Int
)

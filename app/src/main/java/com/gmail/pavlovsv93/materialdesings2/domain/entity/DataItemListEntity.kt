package com.gmail.pavlovsv93.materialdesings2.domain.entity

data class DataItemListEntity(
	val id: Int,
	val title: String,
	var description: String? = null,
	val type: Int
)

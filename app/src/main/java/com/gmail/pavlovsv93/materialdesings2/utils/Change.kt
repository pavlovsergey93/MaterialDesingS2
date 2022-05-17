package com.gmail.pavlovsv93.materialdesings2.utils

data class Change<out T>(
	val oldData: T,
	val newData: T
)

fun <T> createPayloads(payloads: List<Change<T>>) : Change<T>{
	val old = payloads.first()
	val new = payloads.last()
	return Change(old.oldData, new.newData)
}
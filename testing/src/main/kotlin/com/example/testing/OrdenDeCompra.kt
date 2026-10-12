package com.example.testing

class OrdenDeCompra {
    private val items = mutableListOf<Item>()
    fun agregarItem(item: Item) {
        items.add(item)
    }
    fun calcularTotal(): Int = items.sumOf { it.precio }
}
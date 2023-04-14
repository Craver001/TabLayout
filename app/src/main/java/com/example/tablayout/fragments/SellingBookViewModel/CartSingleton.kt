package com.example.tablayout.fragments.SellingBookViewModel

import com.example.tablayout.fragments.LibraryBookClass

object CartSingleton {
    private val cartList = mutableListOf<LibraryBookClass>()

    fun getCartItems(): List<LibraryBookClass> {
        return cartList
    }

    fun addItemToCart(book: LibraryBookClass) {
        cartList.add(book)
    }

    fun removeItemFromCart(book: LibraryBookClass) {
        cartList.remove(book)
    }

    fun clearCart() {
        cartList.clear()
    }
}

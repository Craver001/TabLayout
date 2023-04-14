package com.example.tablayout.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tablayout.R
import com.example.tablayout.fragments.SellingBookViewModel.CartSingleton
import com.example.tablayout.fragments.SellingBookViewModel.SellingViewModel

class LibraryBook : Fragment() {

    private lateinit var listBooks: BookList
    private lateinit var recyclerView: RecyclerView
    private lateinit var cartList: CartSingleton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_library_book, container, false)
        recyclerView = view.findViewById(R.id.recycleView)

        listBooks = BookList()
        cartList = CartSingleton

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = SellingViewModel(listBooks.bookList, object :
            SellingViewModel.OnBookClickListener {
            override fun onBookClicked(book: LibraryBookClass) {
                CartSingleton.addItemToCart(book)
            }
        })

        return view
    }
}

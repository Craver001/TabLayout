package com.example.tablayout.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tablayout.R
import com.example.tablayout.fragments.SellingBookViewModel.CartListAdapter
import com.example.tablayout.fragments.SellingBookViewModel.CartSingleton

/**
 * A simple [Fragment] subclass.
 * Use the [UserCart.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserCart : Fragment() {

    private lateinit var usercart: CartSingleton
    private lateinit var recyclerView: RecyclerView
    private lateinit var cartItem: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_booklist, container, false)
        recyclerView = view.findViewById(R.id.recycleView)
        cartItem = view.findViewById(R.id.item)

        usercart = CartSingleton
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = CartListAdapter(usercart.getCartItems())

        cartItem.text = usercart.getCartItems().size.toString()

        val numberOfItem = usercart.getCartItems().size.toString()
        cartItem.text ="$numberOfItem Items"

        return view
    }
}
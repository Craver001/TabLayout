package com.example.tablayout.fragments.SellingBookViewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tablayout.R
import com.example.tablayout.fragments.LibraryBookClass

class CartListAdapter(private val cartItems: List<LibraryBookClass>) :
    RecyclerView.Adapter<CartListAdapter.CartItemViewHolder>() {

    inner class CartItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val bookImage = itemView.findViewById<ImageView>(R.id.bookImage)
        private val bookName = itemView.findViewById<TextView>(R.id.bookName)
        private val bookAuthor = itemView.findViewById<TextView>(R.id.bookAuthor)
        private val bookPublication = itemView.findViewById<TextView>(R.id.publicationDate)

        fun bind(cartItem: LibraryBookClass) {
            bookImage.setImageResource(cartItem.bookImage)
            bookName.text = cartItem.bookName
            bookAuthor.text = cartItem.bookAuthor
            bookPublication.text = cartItem.bookPublication


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_design, parent, false)
        return CartItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        val cartItem = cartItems[position]
        holder.bind(cartItem)
    }

    override fun getItemCount() = cartItems.size
}

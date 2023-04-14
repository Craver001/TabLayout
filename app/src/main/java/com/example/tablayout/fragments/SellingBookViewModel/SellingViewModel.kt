package com.example.tablayout.fragments.SellingBookViewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tablayout.R
import com.example.tablayout.fragments.LibraryBookClass

class SellingViewModel(private val books: List<LibraryBookClass>, private val onBookClickListener: OnBookClickListener) :
    RecyclerView.Adapter<SellingViewModel.BookViewHolder>() {

    inner class BookViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val bookImage = itemView.findViewById<ImageView>(R.id.bookImage)
        private val bookName = itemView.findViewById<TextView>(R.id.bookName)
        private val bookAuthor = itemView.findViewById<TextView>(R.id.bookAuthor)
        private val bookPublication = itemView.findViewById<TextView>(R.id.publicationDate)


        fun bind(book: LibraryBookClass) {
            bookImage.setImageResource(book.bookImage)
            bookName.text = book.bookName
            bookAuthor.text = book.bookAuthor
            bookPublication.text = book.bookPublication

            // set onClickListener to add the book to cart
            itemView.findViewById<Button>(R.id.addToCard).setOnClickListener {
                onBookClickListener.onBookClicked(book)

                // show a Toast message to confirm that the book was added to the cart
                val message = "${book.bookName} added to cart"
                Toast.makeText(itemView.context, message, Toast.LENGTH_SHORT).show()
            }

        }
    }

    interface OnBookClickListener {
        fun onBookClicked(book: LibraryBookClass)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.sellingbook_design, parent, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.bind(book)
    }

    override fun getItemCount() = books.size
}


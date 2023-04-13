package com.example.tablayout.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tablayout.R

class LibraryViewModel(private val  books: List<LibraryBookClass>):
    RecyclerView.Adapter<LibraryViewModel.BookViewHolder>() {

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val bookImage = itemView.findViewById<ImageView>(R.id.bookImage)
        private val bookName = itemView.findViewById<TextView>(R.id.bookName)
        private val bookAuthor = itemView.findViewById<TextView>(R.id.bookAuthor)
        private val bookPublication = itemView.findViewById<TextView>(R.id.publicationDate)

        fun bind(book: LibraryBookClass) {
            bookImage.setImageResource(book.bookImage)
            bookName.text = book.bookName
            bookAuthor.text = book.bookAuthor
            bookPublication.text = book.bookPublication
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_design, parent, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.bind(book)
    }

    override fun getItemCount() = books.size
}
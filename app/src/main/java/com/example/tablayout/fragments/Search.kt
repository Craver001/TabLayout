package com.example.tablayout.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tablayout.R

class Search : Fragment() {

    private lateinit var searchView: SearchView
    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: LibraryViewModel
    private lateinit var bookList: BookList
    private lateinit var allBooks: List<LibraryBookClass>
    private lateinit var filteredBooks: List<LibraryBookClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true) // enable options menu in this fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        searchView = view.findViewById(R.id.searchView)
        recyclerView = view.findViewById(R.id.recyclerView)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bookList = BookList()
        allBooks = bookList.bookList
        filteredBooks = allBooks // initialize filteredBooks with all books
        myAdapter = LibraryViewModel(filteredBooks)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = myAdapter
        setupSearchView()
    }

    private fun setupSearchView() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filteredBooks = if (newText.isEmpty()) {
                    // If the search query is empty, show all books
                    allBooks
                } else {
                    // Otherwise, filter the books based on the query
                    allBooks.filter { book -> book.bookName.contains(newText, ignoreCase = true) }
                }
                myAdapter = LibraryViewModel(filteredBooks)
                recyclerView.adapter = myAdapter

                // Show/hide the error message depending on whether any books were found
                if (filteredBooks.isEmpty()) {
                    recyclerView.visibility = View.GONE
                    view?.findViewById<TextView>(R.id.tv_no_books_found)?.visibility = View.VISIBLE
                } else {
                    recyclerView.visibility = View.VISIBLE
                    view?.findViewById<TextView>(R.id.tv_no_books_found)?.visibility = View.GONE
                }
                return true
            }
        })
    }

}

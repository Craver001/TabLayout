package com.example.tablayout.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tablayout.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LibraryBook.newInstance] factory method to
 * create an instance of this fragment.
 */
class LibraryBook : Fragment() {

    private lateinit var listBooks:BookList
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_library_book, container, false)
        recyclerView = view.findViewById(R.id.recycleView)

        listBooks = BookList()
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = LibraryViewModel(listBooks.bookList)

        return view
    }

}
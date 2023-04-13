package com.example.tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tablayout.fragments.BuyBooks
import com.example.tablayout.fragments.LibraryBook
import com.example.tablayout.fragments.Search

class FragmentViewPagerAdapter (fragmentManager: FragmentManager, lifecycle:Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0-> return LibraryBook()
            1-> return Search()
        }
        return BuyBooks()
    }
}
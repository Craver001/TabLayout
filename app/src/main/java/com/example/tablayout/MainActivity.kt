package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    val tabArray= arrayOf("Library Books","Search","Buy Books")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tablayout = findViewById<TabLayout>(R.id.tabLayout)
        val pager = findViewById<ViewPager2>(R.id.viewPager)

        val myAdapter = FragmentViewPagerAdapter(
            supportFragmentManager, lifecycle
        )

        pager.adapter = myAdapter

        //connecting the viewpager to tablayout

        TabLayoutMediator(tablayout,pager){
            tab,position ->tab.text = tabArray[position]
        }.attach()
    }


}
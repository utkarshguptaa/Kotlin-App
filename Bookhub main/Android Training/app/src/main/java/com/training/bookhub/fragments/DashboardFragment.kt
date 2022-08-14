package com.training.bookhub.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.training.bookhub.R
import com.training.bookhub.adapter.DashboardRecyclerAdpater
import com.training.bookhub.models.Book

class DashboardFragment : Fragment() {

    lateinit var recyclerDashboard: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager

    val Book_list = arrayListOf(
        "The Intelligent Investor",
        "One Up on Wall Street",
        "Rich Dad Poor Dad",
        "Beating The Street",
        "The Warren Buffet Way",
        "Thinking , Fast and Slow",
        "Stock Investing for Dummies",
        "Learn to Earn",
        "The Money Game"
    )

    lateinit var recyclerAdapter:DashboardRecyclerAdpater

    val Book_Info = arrayListOf<Book>(
        Book("The Intelligent Investor", "Ravi","Rs.2500","4.6", R.drawable.icon)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        recyclerDashboard = view.findViewById(R.id.reyclerDashboard)

        layoutManager = LinearLayoutManager(activity)

        recyclerAdapter = DashboardRecyclerAdpater(activity as Context, Book_Info)

            recyclerDashboard.addItemDecoration(
                DividerItemDecoration(
                    recyclerDashboard.context,
                    (layoutManager as LinearLayoutManager).orientation
                )
            )

        recyclerDashboard.adapter = recyclerAdapter
        recyclerDashboard.layoutManager = layoutManager


        return view
    }

}
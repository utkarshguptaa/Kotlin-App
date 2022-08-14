package com.training.bookhub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.training.bookhub.R
import com.training.bookhub.models.Book


class DashboardRecyclerAdpater(val context: Context , val itemList:ArrayList<Book>):RecyclerView.Adapter<DashboardRecyclerAdpater.DashBoardViewHolder>(){

    class DashBoardViewHolder(view: View):RecyclerView.ViewHolder(view){

        val BookName :TextView = view.findViewById(R.id.txtBookName)
        val BookAuthor : TextView = view.findViewById(R.id.txtBookAuthor)
        val BookPrice :TextView = view.findViewById(R.id.txtBookPrice)
        val BookRating: TextView = view.findViewById(R.id.txtBookRating)
        val BookImage :ImageView = view.findViewById(R.id.imgBookImage)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashBoardViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_in_a_row , parent,false)



        return DashBoardViewHolder(view)

    }

    override fun onBindViewHolder(holder: DashBoardViewHolder, position: Int) {
        val book = itemList[position]
        holder.BookName.text = book.Book_Name
        holder.BookAuthor.text = book.Book_Author
        holder.BookPrice.text = book.Book_Price
        holder.BookRating.text = book.Book_Rating
        holder.BookImage.setImageResource(book.Book_Image)
    }

    override fun getItemCount(): Int {
            return  itemList.size
    }

}
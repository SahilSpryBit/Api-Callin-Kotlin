package com.example.kotlinfirstproject

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_layout, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        holder.imageView.setImageResource(ItemsViewModel.image)

        holder.textView.text = ItemsViewModel.text

        holder.layout.setOnClickListener{

//            Toast.makeText(itemCount, mList.get(position).toString(), Toast.LENGTH_LONG).show()
                Log.i("sahil","Position : "+position)

            val context = holder.itemView.context

            val intent = Intent(context, MainActivity3::class.java)
            Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
            context.startActivity(intent)

        }

    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val layout: LinearLayout = itemView.findViewById(R.id.linearlayout)
    }
}
package com.route.islamibook.ui.home.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islamibook.R

class HadethNamesAdapter (val items:List<String>):RecyclerView.Adapter<HadethNamesAdapter.ViewHolder>(){


    class ViewHolder (itemView : View):RecyclerView.ViewHolder(itemView){
        val name:TextView=itemView.findViewById(R.id.hadeth_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hadeth_name,parent,false)
        return ViewHolder(view)    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadethName=items.get(position)
        holder.name.setText(hadethName)

        //click in recyclerview
        if (onItemHadethClickListener!=null){
            holder.itemView.setOnClickListener {
                onItemHadethClickListener?.onItemClick(position,hadethName)
            }
        }
        /*
///another way for if statment to make click
        onItemClickListener?.let {
                clickListener->
            holder.itemView.setOnClickListener {
                clickListener?.onItemClick(position,suraName)
            }
        }
*/

    }

    override fun getItemCount(): Int =items.size

/// call back (when click in item in recyclerview )
    var onItemHadethClickListener:OnItemClickListener?=null

    interface OnItemClickListener{
        fun onItemClick(position: Int,name:String)
    }

}
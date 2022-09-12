package com.route.islamibook.ui.hadethDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islamibook.R

class HadethContentAdapter :RecyclerView.Adapter<HadethContentAdapter.ViewHolder>(){

    var items:List<String>?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_hadeth_content,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content :String? =items?.get(position)
        holder.content.setText(content)
    }

    override fun getItemCount(): Int =items?.size ?: 0 ///return size and when be null return 0
 /// for update data in adapter //call this fun in hadethdetails in readfile fun
    fun changeData(contentList:List<String>){
        this.items=contentList
        notifyDataSetChanged() /// inform udapter reload

    }
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val content:TextView=itemView.findViewById(R.id.content)
    }
}
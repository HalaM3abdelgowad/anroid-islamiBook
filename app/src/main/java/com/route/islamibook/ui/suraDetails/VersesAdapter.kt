package com.route.islamibook.ui.suraDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islamibook.R

class VersesAdapter :RecyclerView.Adapter<VersesAdapter.ViewHolder>(){

    var items:List<String>?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_verse,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content :String? =items?.get(position)
        holder.content.setText(content+"{${position+1}}")
    }

    override fun getItemCount(): Int =items?.size ?: 0 ///return size and when be null return 0
 /// for update data in adapter //call this fun in suradetails in readfile fun
    fun changeData(verses:List<String>){
        this.items=verses
        notifyDataSetChanged() /// inform udapter reload

    }
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val content:TextView=itemView.findViewById(R.id.content)
    }
}
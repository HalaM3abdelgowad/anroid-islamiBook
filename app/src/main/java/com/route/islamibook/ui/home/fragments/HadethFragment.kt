package com.route.islamibook.ui.home.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.islamibook.R
import com.route.islamibook.ui.Constants
import com.route.islamibook.ui.hadethDetails.HadethDetailsActivity
import com.route.islamibook.ui.home.fragments.adapter.HadethNamesAdapter
import com.route.islamibook.ui.home.fragments.adapter.SuraNamesAdapter
import com.route.islamibook.ui.suraDetails.SuraDetailsActivity

class HadethFragment:Fragment() {

    val hadethNames = listOf("الحديث الاول","الحديث الثانى","الحديث الثالث"," الحديث الرابع","الحديث الخامس","الحديث السادس","الحديث السابع","الحديث الثامن","الحديث التاسع","الحديث العاشر","الحديث الحادى عشر","الحديث الثانى عشر","الحديث الثالث عشر"
        ,"الحديث الرابع عشر","الحديث الخامس عشر","الحديث السادس عشر","الحديث السابع عشر","الحديث الثامن عشر","الحديث التاسع عشر","الحديث العشرون","الحديث الحادى والعشرون","الحديث الثانى و العشرون","الحديث الثالث و العشرون","الحديث الرابع و العشرون","الحديث الخامس و العشرون"
        ,"الحديث السادس و العشرون","الحديث السابع و العشرون","الحديث الثامن و العشرون","الحديث التاسع و العشرون","الحديث الثلاثون","الحديث الحادى والتلاثون","الحديث الثانى والثلاثون","الحديث الثالث والثلاثون","الحديث الرابع والثلاثون","الحديث الخامس والثلاثون","الحديث السادس والثلاثون"
        ,"الحديث السابع والثلاثون","الحديث الثامن والثلاثون","الحديث التاسع والثلاثون","الحديث الاربعون","الحديث الحادى والاربعون","الحديث الثانى والاربعون","الحديث الثالث والاربعون","الحديث الرابع والاربعون","الحديث الخامس والاربعون","الحديث السادس والاربعون","الحديث السابع والاربعون","الحديث الثامن والاربعون"
        ,"الحديث التاسع والاربعون","الحديث الخمسون")
    lateinit var hadethRecyclerView: RecyclerView
    lateinit var adapter: HadethNamesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeth,container,false)
        
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initHadethRecyclerView()
    }

    fun initHadethRecyclerView(){
        hadethRecyclerView=requireView().findViewById(R.id.hadeth_recycler_view)
        adapter= HadethNamesAdapter(hadethNames)

        ///for click in recycler of hadeth names
        adapter.onItemHadethClickListener=object :HadethNamesAdapter.OnItemClickListener{
            override fun onItemClick(position: Int, name: String) {
                showHadethDetails(position,name)
            }

        }

        hadethRecyclerView.adapter=adapter

    }

    fun showHadethDetails(pos: Int,name:String){
        //for go from activity to another activity
        val intent=Intent(requireContext(), HadethDetailsActivity::class.java)
        // for sent data to another activity
        intent.putExtra(Constants.EXTRA_HADETH_NAME,name)
        intent.putExtra(Constants.EXTRA_HADETH_POSITION,pos)
        //
        startActivity(intent)

    }
}
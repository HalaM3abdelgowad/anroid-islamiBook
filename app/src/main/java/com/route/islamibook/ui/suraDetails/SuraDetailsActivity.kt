package com.route.islamibook.ui.suraDetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.route.islamibook.R
import com.route.islamibook.ui.Constants


class SuraDetailsActivity : AppCompatActivity() {

    lateinit var titleTextView: TextView
     lateinit var recyclerView: RecyclerView
    lateinit var adapter: VersesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)

        ///for appear back button

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //

        titleTextView=findViewById(R.id.title_text_view)

        initRecyclerView()

        ///to use data that come from another activity with intent
        ///use constants class for sent and receive static parameter

        val suraName:String=intent.getStringExtra(Constants.EXTRA_SURA_NAME)!!
       val suraPos:Int= intent.getIntExtra(Constants.EXTRA_SURA_POSITION,-1)
        titleTextView.setText(suraName)
/////////////////
        readSuraFile(suraPos)


    }
////recyeler for content of sura (Ayat)
    private fun initRecyclerView() {
        recyclerView=findViewById(R.id.recycler_view)
    adapter= VersesAdapter()
    recyclerView.adapter=adapter
    }

    /// read content of sura
    private fun readSuraFile(pos: Int) {
        //pos+1.text=number of file suraname
    val fileName="${pos+1}.txt" //int+string
        val fileContant=(assets.open(fileName)
            .bufferedReader().use { it.readText() }) //read file as one string
    /// convert string to lines
    //El Ayat >>> verses
    val verses:List<String> =fileContant.split("\n")  //split by backslash n
        adapter.changeData(verses)
    }


}
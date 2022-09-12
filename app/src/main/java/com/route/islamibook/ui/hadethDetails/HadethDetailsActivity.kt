package com.route.islamibook.ui.hadethDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islamibook.R
import com.route.islamibook.ui.Constants
import com.route.islamibook.ui.suraDetails.VersesAdapter

class HadethDetailsActivity : AppCompatActivity() {

     var titleTextView:TextView?=null
    lateinit var hadethRecyclerview :RecyclerView
    lateinit var adapter: HadethContentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_details)
        ///for appear back button

       setSupportActionBar(findViewById(R.id.hadeth_toolbar))
      supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //

        titleTextView=findViewById(R.id.title_text_view)
        titleTextView?.text

        initRecyclerView()

        ///to use data that come from another activity with intent
        ///use constants class for sent and receive static parameter

        val hadethName:String=intent.getStringExtra(Constants.EXTRA_HADETH_NAME)!!
        val hadethPos:Int= intent.getIntExtra(Constants.EXTRA_HADETH_POSITION,-1)
/////////////////
        readSuraFile(hadethPos)
    }
    private fun initRecyclerView() {
        hadethRecyclerview=findViewById(R.id.hadeth_content_recycler_view)
        adapter= HadethContentAdapter()
        hadethRecyclerview.adapter=adapter
    }

    private fun readSuraFile(hadethPos: Int) {
        val fileName="h${hadethPos+1}.txt" //int+string
        val fileContant=assets.open(fileName)
            .bufferedReader().use { it.readText() }
       // textContentView.setText(fileContant)
        val contentList:List<String> =fileContant.split("\n")//split by backslash n
        adapter.changeData(contentList)

    }
}
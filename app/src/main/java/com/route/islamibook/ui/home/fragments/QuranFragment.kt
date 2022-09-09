package com.route.islamibook.ui.home.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.islamibook.R
import com.route.islamibook.ui.Constants
import com.route.islamibook.ui.home.fragments.adapter.SuraNamesAdapter
import com.route.islamibook.ui.suraDetails.SuraDetailsActivity
import java.text.FieldPosition

class QuranFragment:Fragment() {

    val chaptersNames = listOf("الفاتحه","البقرة","آل عمران","النساء","المائدة","الأنعام","الأعراف","الأنفال","التوبة","يونس","هود"
        ,"يوسف","الرعد","إبراهيم","الحجر","النحل","الإسراء","الكهف","مريم","طه","الأنبياء","الحج","المؤمنون"
        ,"النّور","الفرقان","الشعراء","النّمل","القصص","العنكبوت","الرّوم","لقمان","السجدة","الأحزاب","سبأ"
        ,"فاطر","يس","الصافات","ص","الزمر","غافر","فصّلت","الشورى","الزخرف","الدّخان","الجاثية","الأحقاف"
        ,"محمد","الفتح","الحجرات","ق","الذاريات","الطور","النجم","القمر","الرحمن","الواقعة","الحديد","المجادلة"
        ,"الحشر","الممتحنة","الصف","الجمعة","المنافقون","التغابن","الطلاق","التحريم","الملك","القلم","الحاقة","المعارج"
        ,"نوح","الجن","المزّمّل","المدّثر","القيامة","الإنسان","المرسلات","النبأ","النازعات","عبس","التكوير","الإنفطار"
        ,"المطفّفين","الإنشقاق","البروج","الطارق","الأعلى","الغاشية","الفجر","البلد","الشمس","الليل","الضحى","الشرح"
        ,"التين","العلق","القدر","البينة","الزلزلة","العاديات","القارعة","التكاثر","العصر",
        "الهمزة","الفيل","قريش","الماعون","الكوثر","الكافرون","النصر","المسد","الإخلاص","الفلق","الناس")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quran,container,false)

    }

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: SuraNamesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //for acting with recyceler vew make method initrecyclerview
        initRecyclerView()
        /*
        recyclerView = view.findViewById(R.id.recycler_view)
        adapter= SuraNamesAdapter(chaptersNames)
        /// for make click in quran recyclerview
        adapter.onItemClickListener=object :SuraNamesAdapter.OnItemClickListener{
            override fun onItemClick(position: Int, name: String) {
                ///// action when user click
            }
        }
        recyclerView.adapter=adapter
         */

    }

    fun initRecyclerView(){
        recyclerView = requireView().findViewById(R.id.recycler_view)
        adapter= SuraNamesAdapter(chaptersNames)
        /// for make click in quran recyclerview
        adapter.onItemClickListener=object :SuraNamesAdapter.OnItemClickListener{
            override fun onItemClick(position: Int, name: String) {
                //action when user click
                //Toast.makeText(requireActivity(),name,Toast.LENGTH_LONG).show()
                showSouraDetails(position,name)
               // val intent=Intent(requireContext(),SuraDetailsActivity::class.java)
               // startActivity(intent)
            }
        }
        recyclerView.adapter=adapter
    }

    /// for show details of sura
   fun showSouraDetails(pos: Int,name:String){
        //for go from activity to another activity
        val intent=Intent(requireContext(),SuraDetailsActivity::class.java)
        // for sent data to another activity
        intent.putExtra(Constants.EXTRA_SURA_NAME,name)
        intent.putExtra(Constants.EXTRA_SURA_POSITION,pos)
        //
        startActivity(intent)

    }
}
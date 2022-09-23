package com.route.islamibook.ui.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.route.islamibook.R

class TasbehFragment:Fragment() {

    lateinit var counter:Button
    lateinit var zekr:Button
    var count=0
    var generalCounter=0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasbeh,container,false)
        
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        counter=view.findViewById(R.id.counter)
        zekr=view.findViewById(R.id.zekr)
        counter.setOnClickListener {
            if (generalCounter <=10) {
                    count++
                    generalCounter++

                    if (generalCounter == 3) {
                        count = 0
                        zekr.setText("الحمد لله")
                    } else if (generalCounter == 6) {
                        count = 0
                        zekr.setText("لا اله الا الله ")
                    } else if (generalCounter == 9) {
                        count = 0
                        zekr.setText("الله اكبر ")

                    }
               // count++
                    counter.setText(count.toString())


                }else{
                    count=0
                    generalCounter=0
                    counter.setText(count.toString())
                    zekr.setText("سبحان الله")
                }
        }
    }
}
package com.diyorbek.expandblelistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListView
import com.diyorbek.expandblelistview.adapter.ExpandbleAdapter
import com.diyorbek.expandblelistview.adapter.OnItemClickListener
import com.diyorbek.expandblelistview.util.Constant

class MainActivity : AppCompatActivity() {
    private lateinit var expandbleListView: ExpandableListView
    private lateinit var expandbleAdapter: ExpandbleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Constant.title.add("Football clubs")
        Constant.title.add("Programing languages")
        Constant.subTitle.add(Constant.footballClubs())
        Constant.subTitle.add(Constant.languages())
        expandbleListView = findViewById(R.id.listView)
        expandbleAdapter =
            ExpandbleAdapter(this, Constant.title, Constant.subTitle, onItemClickListener)
        expandbleListView.setAdapter(expandbleAdapter)
    }

    private val onItemClickListener = object : OnItemClickListener {
        override fun onClick(subTitle: String) {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("subTitle", subTitle)
            startActivity(intent)
        }
    }
}
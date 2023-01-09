package com.diyorbek.expandblelistview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.diyorbek.expandblelistview.R

class ExpandbleAdapter(
    private val context: Context,
    private val title: MutableList<String>,
    private val subTitle: MutableList<MutableList<String>>,
    private val onItemClickListener: OnItemClickListener
) : BaseExpandableListAdapter() {
    private val inflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getGroupCount(): Int {
        return title.size
    }

    override fun getChildrenCount(p0: Int): Int {
        return subTitle[p0].size
    }

    override fun getGroup(p0: Int): Any {
        return title[p0]
    }

    override fun getChild(p0: Int, p1: Int): Any {
        return subTitle[p0][p1]
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean = false

    override fun getGroupView(
        groupPostition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var myConverterView = convertView
        if (myConverterView == null) {
            myConverterView = inflater.inflate(R.layout.title_layout, null)
        }
        val textView: TextView = myConverterView?.findViewById(R.id.textView)!!
        textView.text = title[groupPostition]
        return myConverterView
    }

    override fun getChildView(
        groupPostition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var myConverterView = convertView
        if (myConverterView == null) {
            myConverterView = inflater.inflate(R.layout.sub_title, null)
        }
        val textView: TextView = myConverterView?.findViewById(R.id.textView)!!
        textView.text = subTitle[groupPostition][childPosition]
        myConverterView.setOnClickListener {
            onItemClickListener.onClick(subTitle[groupPostition][childPosition])
        }
        return myConverterView
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean = true
}
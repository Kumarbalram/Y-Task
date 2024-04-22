package com.soptcode.yilassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soptcode.yilassignment.databinding.NameItemLayoutBinding
import com.soptcode.yilassignment.model.NameResponse
import kotlin.math.sign

class ContactListAdapter(
    val context: Context,
    val nameList: ArrayList<NameResponse.NameResponseItem>,
    val click: ClickName
) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    class ViewHolder(var binding: NameItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding =
            NameItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var list = nameList[position]
        holder.binding.name.text = list.name
        holder.itemView.setOnClickListener {
            click.clickOnNameList(position)
        }

    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    interface ClickName {
        fun clickOnNameList(position: Int)
    }
}
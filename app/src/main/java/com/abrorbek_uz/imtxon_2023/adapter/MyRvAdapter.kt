package com.abrorbek_uz.imtxon_2023.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abrorbek_uz.imtxon_2023.databinding.RvItemBinding
import com.abrorbek_uz.imtxon_2023.models.APIDataItem



class MyRvAdapter(var list: List<APIDataItem>) : RecyclerView.Adapter<MyRvAdapter.Vh>() {

    inner class Vh(var rvItemBinding: RvItemBinding):RecyclerView.ViewHolder(rvItemBinding.root){
        @SuppressLint("SetTextI18n")
        fun onBind(user: APIDataItem, position: Int ){
            rvItemBinding.tv1.text = user.id.toString()
            rvItemBinding.tv2.text = user.title
            rvItemBinding.diff.text = user.body
            rvItemBinding.diff2.text = user.userId.toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(RvItemBinding.inflate(LayoutInflater.from(parent.context) , parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

}
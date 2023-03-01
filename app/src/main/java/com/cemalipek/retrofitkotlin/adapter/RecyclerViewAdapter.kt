package com.cemalipek.retrofitkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cemalipek.retrofitkotlin.R
import com.cemalipek.retrofitkotlin.databinding.ActivityMainBinding
import com.cemalipek.retrofitkotlin.databinding.RecyclerRowBinding
import com.cemalipek.retrofitkotlin.model.CryptoModel

class RecyclerViewAdapter(private val cryptoList: ArrayList<CryptoModel>, private val listener: Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

        interface Listener {
            fun onItemClick(cryptoModel: CryptoModel)
        }



    class RowHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){


        fun bind(cryptoModel: CryptoModel, position: Int, listener: Listener){

            itemView.setOnClickListener {
                listener.onItemClick(cryptoModel)
            }
            binding.textName.text = cryptoModel.currency
            binding.textPrice.text = cryptoModel.price
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RowHolder(binding)

    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position],position,listener)
    }

    override fun getItemCount(): Int {
        return cryptoList.count()
    }
}
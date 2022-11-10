package com.example.cryptodemo.ui.fragment.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptodemo.databinding.RvRowLayoutBinding
import com.example.cryptodemo.model.successfulResponse.Data

/**
 * @author : Mingaleev D
 * @data : 10/11/2022
 */

class HomeAdapter(private val listener: ItemClickListener) :
   RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

   private var coins = emptyList<Data>()

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val inflater = LayoutInflater.from(parent.context)
      val binding = RvRowLayoutBinding.inflate(inflater, parent, false)
      return MyViewHolder(binding)
   }

   override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.bind(listener, coins[position])
   }

   override fun getItemCount(): Int {
      return coins.size
   }

   class MyViewHolder(private val binding: RvRowLayoutBinding) :
      RecyclerView.ViewHolder(binding.root) {

      fun bind(listener: ItemClickListener, coin: Data) {
         binding.onItemCLickListener = listener
         binding.coin = coin
         binding.executePendingBindings()
      }
   }

   @SuppressLint("NotifyDataSetChanged")
   fun setList(newList:List<Data>){
      coins = newList
      notifyDataSetChanged()
   }
}
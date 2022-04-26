package com.example.academynotesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.academynotesapp.appdata.User
import kotlinx.android.synthetic.main.fragment_item_adapter.view.*

class ItemAdapterFragment: RecyclerView.Adapter<ItemAdapterFragment.MyViewHolder>() {
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {}
    private var userList = emptyList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_adapter, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.name.text = currentItem.name
        holder.itemView.birthday.text = currentItem.birthday.toString()
    }
    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }
}


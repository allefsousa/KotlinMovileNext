package com.example.allef.next.kotlinmovilenext.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.allef.next.kotlinmovilenext.R
import com.example.allef.next.kotlinmovilenext.api.Repository
import kotlinx.android.synthetic.main.repository_item.view.*

/**
 * criando adapater em kotlin
 */

class repositoryAdapter (
        private val items:List<Repository>,
        private val context: Context,
        private val listner:(Repository)->Unit
) : Adapter<repositoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  =LayoutInflater.from(context).inflate(
                R.layout.repository_item,
                parent,
                false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item,listner)

    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        fun bindView(items:Repository,
                     listner: (Repository) -> Unit) = with(itemView){
            Glide.with(context).load(items.owner.avatar_url).into(ivMain)

                    tvTitle.text = items.name
                   tvowner.text = items.owner.login
                    tvDescription.text = items.description

                    setOnClickListener{
                        listner(items)
                    }
        }


    }
}
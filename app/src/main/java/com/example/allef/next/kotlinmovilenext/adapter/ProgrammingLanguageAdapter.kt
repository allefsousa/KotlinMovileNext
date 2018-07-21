package com.example.allef.next.kotlinmovilenext.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.allef.next.kotlinmovilenext.R
import com.example.allef.next.kotlinmovilenext.model.ProgrammingLanguage
import kotlinx.android.synthetic.main.programming_language_item.view.*

/**
 * criando adapater em kotlin
 */

class ProgrammingLanguageAdapter (
        private val items:List<ProgrammingLanguage>,
        private val context: Context,
        private val listner:(ProgrammingLanguage)->Unit
) : Adapter<ProgrammingLanguageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  =LayoutInflater.from(context).inflate(
                R.layout.programming_language_item,
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

        fun bindView(items:ProgrammingLanguage,
                     listner: (ProgrammingLanguage) -> Unit) = with(itemView){ ivMain.setImageResource(items.imageResourceId)

                    tvTitle.text = items.title
                    tvLaunchYear.text = items.year.toString()
                    tvDescription.text = items.description

                    setOnClickListener{
                        listner(items)
                    }
        }


    }
}
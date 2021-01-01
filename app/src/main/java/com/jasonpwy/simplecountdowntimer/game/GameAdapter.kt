package com.jasonpwy.simplecountdowntimer.game

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jasonpwy.simplecountdowntimer.R
import kotlinx.android.synthetic.main.recyclerview_row.view.*
import org.w3c.dom.Text

class TextItemViewHolder(view: View): RecyclerView.ViewHolder(view){
    var content: TextView? = view.stored_message
}

class GameAdapter() : RecyclerView.Adapter<TextItemViewHolder>() {
    var data = listOf<String>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder?.content?.text = item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)
        return TextItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
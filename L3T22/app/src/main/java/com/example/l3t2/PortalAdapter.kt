package com.example.l3t2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.portallayout.view.*


class PortalAdapter(private val portals: List<Portals>,val clickListener: (Portals) -> Unit) : RecyclerView.Adapter<PortalAdapter.ViewHolder>() {



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {




        fun bind(portals: Portals,clickListener: (Portals) -> Unit) {
            itemView.text_portalName.text = portals.portalName
            itemView.text_portalUrl.text = portals.PortalURL

            itemView.setOnClickListener {
                clickListener(portals)
            }
        }
    }


    /**
     * Creates and returns a ViewHolder object, inflating the layout called item_reminder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.portallayout, parent, false)
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return portals.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(portals[position],clickListener)
    }

}
package app.babachan.l4soriginal

import android.content.Context
import android.graphics.Color
import android.net.sip.SipSession
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    private val context: Context
//    private val listener: ColorListener
//    private val listener: AdapterView.OnItemClickListener
) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
//    lateinit var listener: OnItemClickListener
    val items: MutableList<ColorData> = mutableListOf()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val selectColor: TextView = view.findViewById(R.id.accentColorCell)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.accent_color_cell, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.selectColor.setBackgroundColor(Color.rgb(item.accentColorR, item.accentColorG, item.accentColorB))
//        holder.selectColor.text = item.description
//        holder.selectColor.setBackgroundColor(item.index)
//        holder.setOnClickListener {
//            listener.onItemClickListener(it, position, items[position])
//        }
    }


//    fun setOnItemClickListener(listener: AdapterView.OnItemClickListener) {}

    fun addAll(items: List<ColorData>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }


//    interface OnItemClickListener {
//        fun onItemClickListener(view: View, position: Int)
//    }

//    fun setOnItemClickListener(listener: OnItemClickListener) {
//        this.listener = listener
//    }
}
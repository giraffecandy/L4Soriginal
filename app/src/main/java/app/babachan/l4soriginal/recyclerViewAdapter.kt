package app.babachan.l4soriginal

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.accent_color_cell.view.*

class RecyclerViewAdapter(
    private val context: Context,
    private val listener: OnItemClickListener
//    private val listener: AdapterView.OnItemClickListener
) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    //    lateinit var listener: OnItemClickListener
    private val items: MutableList<ColorData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.accent_color_cell, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val colorData: ColorData = items?.get(position) ?: return
        holder.bind(colorData, listener)
//        holder.selectColor.text = item.description
//        holder.selectColor.setBackgroundColor(item.index)
//        holder.setOnClickListener {
//            listener.onItemClickListener(it, position, items[position])
//        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val accentColorCell: TextView = view.findViewById(R.id.accentColorCell)
        private val container: ConstraintLayout? = view.container

        fun bind(colorData: ColorData, listener: OnItemClickListener) {
            accentColorCell.setBackgroundColor(
                Color.rgb(
                    colorData.accentColorR,
                    colorData.accentColorG,
                    colorData.accentColorB
                )
            )

            container?.setOnClickListener {
                listener.onItemClick(colorData)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: ColorData)
    }


//    fun setOnItemClickListener(listener: AdapterView.OnItemClickListener) {}

    fun addAll(items: List<ColorData>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }


}
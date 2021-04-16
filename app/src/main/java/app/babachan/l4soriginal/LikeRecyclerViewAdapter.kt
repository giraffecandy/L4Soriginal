package app.babachan.l4soriginal

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import io.realm.OrderedRealmCollection
import kotlinx.android.synthetic.main.accent_color_cell.view.*

class LikeRecyclerViewAdapter(
    private val context: Context,
    private var likeList: OrderedRealmCollection<LikeData>?,
    private var listener: OnItemClickListener
) :
    RecyclerView.Adapter<LikeRecyclerViewAdapter.ViewHolder>() {
    //    lateinit var listener: OnItemClickListener
    private val items: MutableList<LikeData> = mutableListOf()

    override fun getItemCount(): Int = likeList?.size ?:0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.like_palette_cell, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val likeData: LikeData = likeList?.get(position) ?: return
        holder.likePaletteName.text = likeData.name
//        holder.selectColor.text = item.description
//        holder.selectColor.setBackgroundColor(item.index)

//        holder.setOnClickListener {
//            listener.onItemClickListener(it, position, items[position])
//        }
        holder.bind(likeData)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val likePaletteName: TextView = view.findViewById(R.id.likePaletteName)
        private val likePrimaryTextView: TextView = view.findViewById(R.id.likePrimaryTextView)
        private val likePrimaryDarkTextView: TextView = view.findViewById(R.id.likePrimaryDarkTextView)
        private val likeAccentTextView: TextView = view.findViewById(R.id.likeAccentTextView)
        private val container: ConstraintLayout? = view.container

        fun bind(likeData: LikeData) {
            val primaryClr = likeData.primary
            val primaryClrs = "#" + Integer.toHexString(primaryClr).substring(2)
            val primaryColor = "$primaryClrs"
            likePrimaryTextView.setBackgroundColor(Color.parseColor(primaryColor))

            val darkClr = likeData.dark
            val darkClrs = "#" + Integer.toHexString(darkClr).substring(2)
            val darkColor = "$darkClrs"
            likePrimaryDarkTextView.setBackgroundColor(Color.parseColor(darkColor))

            val accentClr = likeData.accent
            val accentClrs = "#" + Integer.toHexString(accentClr).substring(2)
            val accentColor = "$accentClrs"
            likeAccentTextView.setBackgroundColor(Color.parseColor(accentColor))

//            container.setOnClickListener {
//                listener.onItemClick(likeData)
//            }
        }
    }


    interface OnItemClickListener{
        fun onItemClick(item: LikeData)
    }

}

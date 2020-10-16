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

class likeRecyclerViewAdapter(
    private val context: Context,
    private var likeList: OrderedRealmCollection<LikeData>?
//    private val listener: AdapterView.OnItemClickListener
) :
    RecyclerView.Adapter<likeRecyclerViewAdapter.ViewHolder>() {
    //    lateinit var listener: OnItemClickListener
    private val items: MutableList<LikeData> = mutableListOf()

    override fun getItemCount(): Int = likeList?.size ?:0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.like_palette_cell, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val likeData: LikeData = likeList?.get(position) ?: return
//        holder.
//        holder.selectColor.text = item.description
//        holder.selectColor.setBackgroundColor(item.index)
//        holder.setOnClickListener {
//            listener.onItemClickListener(it, position, items[position])
//        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val likePrimaryTextView: TextView = view.findViewById(R.id.likePrimaryTextView)
        private val likePrimaryDarkTextView: TextView =
            view.findViewById(R.id.likePrimaryDarkTextView)
        private val likeAccentTextView: TextView = view.findViewById(R.id.likeAccentTextView)
        private val container: ConstraintLayout? = view.container

        fun bind(likeData: LikeData) {
            likePrimaryTextView.setBackgroundColor(
                Color.rgb(
                    likeData.primaryR, likeData.primaryG, likeData.primaryB
                )
            )
        }
    }


//    fun setOnItemClickListener(listener: AdapterView.OnItemClickListener) {}

    fun addAll(items: List<LikeData>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}

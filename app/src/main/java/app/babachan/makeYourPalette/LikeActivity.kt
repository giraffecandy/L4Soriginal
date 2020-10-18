package app.babachan.makeYourPalette

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.isEmpty
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_like.*


class LikeActivity : AppCompatActivity() {

    val realm = Realm.getDefaultInstance()

    private lateinit var mContext: Context;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_like)


        val empty = realm.where(LikeData::class.java).findFirst()
        message.isVisible = empty == null

    }

    override fun onResume() {
        super.onResume()

//        if (likeRecyclerView.isEmpty()) {
//            message.text = "お気に入りのパレットを登録しよう"
//        }

        mContext = this
        val likeList: RealmResults<LikeData> = readAll()
//        val items: RealmResults<LikeData> = realm.where(LikeData::class.java).findAll()
//        val likeData: List<LikeData> = listOf()
        val adapter = LikeRecyclerViewAdapter(
            this, likeList
//            , object : LikeRecyclerViewAdapter.OnItemClickListener {
//                override fun onItemClick(item: LikeData) {
//
//                }
//            }
        )
        likeRecyclerView.setHasFixedSize(true)
        likeRecyclerView.layoutManager = LinearLayoutManager(this)
        likeRecyclerView.adapter = adapter

//        val swipeToDismissTouchHelper by lazy {
//            getSwipeToDismissTouchHelper(adapter)
//        }
//
//        swipeToDismissTouchHelper.attachToRecyclerView(likeRecyclerView)
    }


    private fun readAll(): RealmResults<LikeData> {
        return realm.where(LikeData::class.java).findAll()
    }

//    private fun getSwipeToDismissTouchHelper(adapter: LikeRecyclerViewAdapter) =
//        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
//            ItemTouchHelper.ACTION_STATE_IDLE,
//            ItemTouchHelper.LEFT
//        ) {
//            override fun onMove(
//                recyclerView: RecyclerView,
//                viewHolder: RecyclerView.ViewHolder,
//                target: RecyclerView.ViewHolder
//            ): Boolean {
//                return false
//            }
//
//            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                val timeTasks = adapter.getItems()
//                mainViewModel.delete(timeTasks[viewHolder.adapterPosition])
//            }
//
//            override fun onChildDraw(
//                c: Canvas,
//                recyclerView: RecyclerView,
//                viewHolder: RecyclerView.ViewHolder,
//                dX: Float,
//                dY: Float,
//                actionState: Int,
//                isCurrentlyActive: Boolean
//            ) {
//                super.onChildDraw(
//                    c,
//                    recyclerView,
//                    viewHolder,
//                    dX,
//                    dY,
//                    actionState,
//                    isCurrentlyActive
//                )
//                val itemView = viewHolder.itemView
//                val background = ColorDrawable(Color.RED)
//                val deleteIcon = AppCompatResources.getDrawable(
//                    applicationContext,
//                    R.drawable.ic_baseline_delete_24
//                )
//                val iconMarginVertical =
//                    (viewHolder.itemView.height - deleteIcon!!.intrinsicHeight) / 2
//
//                deleteIcon.setBounds(
//                    itemView.left + iconMarginVertical,
//                    itemView.top + iconMarginVertical,
//                    itemView.left + iconMarginVertical + deleteIcon.intrinsicWidth,
//                    itemView.bottom - iconMarginVertical
//                )
//                background.setBounds(
//                    itemView.left,
//                    itemView.top,
//                    itemView.right + dX.toInt(),
//                    itemView.bottom
//                )
//                background.draw(c)
//                deleteIcon.draw(c)
//            }
//        })
}
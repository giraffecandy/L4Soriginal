package app.babachan.makeYourPalette

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isEmpty
import androidx.recyclerview.widget.LinearLayoutManager
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

//        val empty = realm.where(LikeData::class.java).findFirst()
//        message.isVisible = empty == null

    }

    override fun onResume() {
        super.onResume()

        if (likeRecyclerView.isEmpty()) {
            message.text = "お気に入りのパレットを登録しよう"
        }

        mContext = this
        val likeList: RealmResults<LikeData> = readAll()
//        val items: RealmResults<LikeData> = realm.where(LikeData::class.java).findAll()
//        val likeData: List<LikeData> = listOf()
        val adapter = LikeRecyclerViewAdapter(
            this, likeList
        )
        likeRecyclerView.setHasFixedSize(true)
        likeRecyclerView.layoutManager = LinearLayoutManager(this)
        likeRecyclerView.adapter = adapter
    }


    private fun readAll(): RealmResults<LikeData> {
        return realm.where(LikeData::class.java).findAll()
    }
}
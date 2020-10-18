package app.babachan.makeYourPalette

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_detail.*
import java.util.*


class DetailActivity : AppCompatActivity() {

    val colorData: List<ColorData> = listOf(


        //red
        ColorData(100, 255, 138, 128, "#ffebee"),
        ColorData(200, 255, 82, 82),
        ColorData(400, 255, 23, 68),
        ColorData(700, 213, 0, 0),

        //pink
        ColorData(100, 255, 128, 171),
        ColorData(200, 255, 64, 129),
        ColorData(400, 245, 0, 87),
        ColorData(700, 197, 17, 98),

        //purple
        ColorData(100, 234, 128, 252),
        ColorData(200, 224, 64, 251),
        ColorData(400, 213, 0, 249),
        ColorData(700, 170, 0, 255),

        //deepPurple
        ColorData(100, 179, 136, 255),
        ColorData(200, 124, 77, 255),
        ColorData(400, 101, 31, 255),
        ColorData(700, 98, 0, 234),

        //indigo
        ColorData(100, 140, 158, 255),
        ColorData(200, 83, 109, 254),
        ColorData(400, 61, 90, 254),
        ColorData(700, 48, 79, 254),

        //blue
        ColorData(100, 130, 177, 255),
        ColorData(200, 68, 138, 255),
        ColorData(400, 41, 121, 255),
        ColorData(700, 41, 98, 255),

        //lightblue
        ColorData(100, 128, 216, 255),
        ColorData(200, 64, 196, 255),
        ColorData(400, 0, 176, 255),
        ColorData(700, 0, 145, 234),

        //cyan
        ColorData(100, 132, 255, 255),
        ColorData(200, 24, 255, 255),
        ColorData(400, 0, 229, 255),
        ColorData(700, 0, 184, 212),

        //teal
        ColorData(100, 167, 255, 235),
        ColorData(200, 100, 255, 218),
        ColorData(400, 29, 233, 182),
        ColorData(700, 0, 191, 165),

        //green
        ColorData(100, 185, 246, 202),
        ColorData(200, 105, 240, 174),
        ColorData(400, 0, 230, 118),
        ColorData(700, 0, 200, 83),

        //lightGreen
        ColorData(100, 204, 255, 144),
        ColorData(200, 178, 255, 89),
        ColorData(400, 118, 255, 3),
        ColorData(700, 100, 221, 23),

        //lime
        ColorData(100, 244, 255, 129),
        ColorData(200, 238, 255, 65),
        ColorData(400, 198, 255, 0),
        ColorData(700, 174, 234, 0),

        //yellow
        ColorData(100, 255, 255, 141),
        ColorData(200, 255, 255, 0),
        ColorData(400, 255, 234, 0),
        ColorData(700, 255, 214, 0),

        //amber
        ColorData(100, 255, 229, 127),
        ColorData(200, 255, 215, 64),
        ColorData(400, 255, 196, 0),
        ColorData(700, 255, 171, 0),

        //orange
        ColorData(100, 255, 209, 128),
        ColorData(200, 255, 171, 64),
        ColorData(400, 255, 145, 0),
        ColorData(700, 255, 109, 0),

        //deepOrange
        ColorData(100, 255, 158, 128),
        ColorData(200, 255, 110, 64),
        ColorData(400, 255, 61, 0),
        ColorData(700, 221, 44, 0)

    )

    val paletteDate: List<PrimaryDarkPrimaryData> = listOf(
        //red
        PrimaryDarkPrimaryData(50, 255, 235, 238),
        PrimaryDarkPrimaryData(100, 255, 205, 210),
        PrimaryDarkPrimaryData(200, 239, 154, 154),
        PrimaryDarkPrimaryData(300, 229, 115, 115),
        PrimaryDarkPrimaryData(400, 239, 83, 80),
        PrimaryDarkPrimaryData(500, 244, 67, 54),
        PrimaryDarkPrimaryData(600, 229, 57, 53),
        PrimaryDarkPrimaryData(700, 211, 47, 47),
        PrimaryDarkPrimaryData(800, 198, 40, 40),
        PrimaryDarkPrimaryData(900, 183, 28, 28),
//pink
        PrimaryDarkPrimaryData(50, 252, 228, 236),
        PrimaryDarkPrimaryData(100, 248, 187, 208),
        PrimaryDarkPrimaryData(200, 244, 143, 177),
        PrimaryDarkPrimaryData(300, 240, 98, 146),
        PrimaryDarkPrimaryData(400, 236, 64, 122),
        PrimaryDarkPrimaryData(500, 233, 30, 99),
        PrimaryDarkPrimaryData(600, 216, 27, 96),
        PrimaryDarkPrimaryData(700, 194, 24, 91),
        PrimaryDarkPrimaryData(800, 173, 20, 87),
        PrimaryDarkPrimaryData(900, 136, 14, 79),

        //purple
        PrimaryDarkPrimaryData(50, 243, 229, 245),
        PrimaryDarkPrimaryData(100, 225, 190, 231),
        PrimaryDarkPrimaryData(200, 206, 147, 216),
        PrimaryDarkPrimaryData(300, 186, 104, 200),
        PrimaryDarkPrimaryData(400, 171, 71, 188),
        PrimaryDarkPrimaryData(500, 156, 39, 176),
        PrimaryDarkPrimaryData(600, 142, 36, 170),
        PrimaryDarkPrimaryData(700, 123, 31, 162),
        PrimaryDarkPrimaryData(800, 106, 27, 154),
        PrimaryDarkPrimaryData(900, 74, 20, 140),

        //deepPurple
        PrimaryDarkPrimaryData(50, 237, 231, 246),
        PrimaryDarkPrimaryData(100, 209, 196, 233),
        PrimaryDarkPrimaryData(200, 179, 157, 219),
        PrimaryDarkPrimaryData(300, 149, 117, 205),
        PrimaryDarkPrimaryData(400, 126, 87, 194),
        PrimaryDarkPrimaryData(500, 103, 58, 183),
        PrimaryDarkPrimaryData(600, 94, 53, 177),
        PrimaryDarkPrimaryData(700, 81, 45, 168),
        PrimaryDarkPrimaryData(800, 69, 39, 160),
        PrimaryDarkPrimaryData(900, 49, 27, 146),

        //indigo
        PrimaryDarkPrimaryData(50, 232, 234, 246),
        PrimaryDarkPrimaryData(100, 197, 202, 233),
        PrimaryDarkPrimaryData(200, 159, 168, 218),
        PrimaryDarkPrimaryData(300, 121, 134, 203),
        PrimaryDarkPrimaryData(400, 92, 107, 192),
        PrimaryDarkPrimaryData(500, 63, 81, 181),
        PrimaryDarkPrimaryData(600, 57, 73, 171),
        PrimaryDarkPrimaryData(700, 48, 63, 159),
        PrimaryDarkPrimaryData(800, 40, 53, 147),
        PrimaryDarkPrimaryData(900, 26, 35, 126),

        //blue
        PrimaryDarkPrimaryData(50, 227, 242, 253),
        PrimaryDarkPrimaryData(100, 187, 222, 251),
        PrimaryDarkPrimaryData(200, 144, 202, 249),
        PrimaryDarkPrimaryData(300, 100, 181, 246),
        PrimaryDarkPrimaryData(400, 66, 165, 245),
        PrimaryDarkPrimaryData(500, 33, 150, 243),
        PrimaryDarkPrimaryData(600, 30, 136, 229),
        PrimaryDarkPrimaryData(700, 25, 118, 210),
        PrimaryDarkPrimaryData(800, 21, 101, 192),
        PrimaryDarkPrimaryData(900, 13, 71, 161),

        //lightBlue
        PrimaryDarkPrimaryData(50, 225, 245, 254),
        PrimaryDarkPrimaryData(100, 179, 229, 252),
        PrimaryDarkPrimaryData(200, 129, 212, 250),
        PrimaryDarkPrimaryData(300, 79, 195, 247),
        PrimaryDarkPrimaryData(400, 41, 182, 246),
        PrimaryDarkPrimaryData(500, 3, 169, 244),
        PrimaryDarkPrimaryData(600, 3, 155, 229),
        PrimaryDarkPrimaryData(700, 2, 136, 209),
        PrimaryDarkPrimaryData(800, 2, 119, 189),
        PrimaryDarkPrimaryData(900, 1, 87, 155),

        //cyan
        PrimaryDarkPrimaryData(50, 224, 247, 250),
        PrimaryDarkPrimaryData(100, 178, 235, 242),
        PrimaryDarkPrimaryData(200, 128, 222, 234),
        PrimaryDarkPrimaryData(300, 77, 208, 225),
        PrimaryDarkPrimaryData(400, 38, 198, 218),
        PrimaryDarkPrimaryData(500, 0, 188, 212),
        PrimaryDarkPrimaryData(600, 0, 172, 193),
        PrimaryDarkPrimaryData(700, 0, 151, 167),
        PrimaryDarkPrimaryData(800, 0, 131, 143),
        PrimaryDarkPrimaryData(900, 0, 96, 100),

        //teal
        PrimaryDarkPrimaryData(50, 224, 242, 241),
        PrimaryDarkPrimaryData(100, 178, 223, 219),
        PrimaryDarkPrimaryData(200, 128, 203, 196),
        PrimaryDarkPrimaryData(300, 77, 182, 172),
        PrimaryDarkPrimaryData(400, 38, 166, 154),
        PrimaryDarkPrimaryData(500, 0, 150, 136),
        PrimaryDarkPrimaryData(600, 0, 137, 123),
        PrimaryDarkPrimaryData(700, 0, 121, 107),
        PrimaryDarkPrimaryData(800, 0, 105, 92),
        PrimaryDarkPrimaryData(900, 0, 77, 64),

        //green
        PrimaryDarkPrimaryData(50, 232, 245, 233),
        PrimaryDarkPrimaryData(100, 200, 230, 201),
        PrimaryDarkPrimaryData(200, 200, 230, 201),
        PrimaryDarkPrimaryData(300, 129, 199, 132),
        PrimaryDarkPrimaryData(400, 102, 187, 106),
        PrimaryDarkPrimaryData(500, 76, 175, 80),
        PrimaryDarkPrimaryData(600, 67, 160, 71),
        PrimaryDarkPrimaryData(700, 56, 142, 60),
        PrimaryDarkPrimaryData(800, 46, 125, 50),
        PrimaryDarkPrimaryData(900, 27, 94, 32),

        //lightGreen
        PrimaryDarkPrimaryData(50, 241, 248, 233),
        PrimaryDarkPrimaryData(100, 220, 237, 200),
        PrimaryDarkPrimaryData(200, 197, 225, 165),
        PrimaryDarkPrimaryData(300, 174, 213, 129),
        PrimaryDarkPrimaryData(400, 156, 204, 101),
        PrimaryDarkPrimaryData(500, 139, 195, 74),
        PrimaryDarkPrimaryData(600, 124, 179, 66),
        PrimaryDarkPrimaryData(700, 104, 159, 56),
        PrimaryDarkPrimaryData(800, 85, 139, 47),
        PrimaryDarkPrimaryData(900, 51, 105, 30),

        //lime
        PrimaryDarkPrimaryData(50, 249, 251, 231),
        PrimaryDarkPrimaryData(100, 240, 244, 195),
        PrimaryDarkPrimaryData(200, 230, 238, 156),
        PrimaryDarkPrimaryData(300, 220, 231, 117),
        PrimaryDarkPrimaryData(400, 212, 225, 87),
        PrimaryDarkPrimaryData(500, 205, 220, 57),
        PrimaryDarkPrimaryData(600, 192, 202, 51),
        PrimaryDarkPrimaryData(700, 175, 180, 43),
        PrimaryDarkPrimaryData(800, 158, 157, 36),
        PrimaryDarkPrimaryData(900, 130, 119, 23),

        //yellow
        PrimaryDarkPrimaryData(50, 255, 253, 231),
        PrimaryDarkPrimaryData(100, 255, 249, 196),
        PrimaryDarkPrimaryData(200, 255, 245, 157),
        PrimaryDarkPrimaryData(300, 255, 241, 118),
        PrimaryDarkPrimaryData(400, 255, 238, 88),
        PrimaryDarkPrimaryData(500, 255, 235, 59),
        PrimaryDarkPrimaryData(600, 253, 216, 53),
        PrimaryDarkPrimaryData(700, 251, 192, 45),
        PrimaryDarkPrimaryData(800, 249, 168, 37),
        PrimaryDarkPrimaryData(900, 245, 127, 23),

        //amber
        PrimaryDarkPrimaryData(50, 255, 248, 225),
        PrimaryDarkPrimaryData(100, 255, 236, 179),
        PrimaryDarkPrimaryData(200, 255, 224, 130),
        PrimaryDarkPrimaryData(300, 255, 213, 79),
        PrimaryDarkPrimaryData(400, 255, 202, 40),
        PrimaryDarkPrimaryData(500, 255, 193, 7),
        PrimaryDarkPrimaryData(600, 255, 179, 0),
        PrimaryDarkPrimaryData(700, 255, 160, 0),
        PrimaryDarkPrimaryData(800, 255, 243, 0),
        PrimaryDarkPrimaryData(900, 255, 111, 0),

        //orange
        PrimaryDarkPrimaryData(50, 255, 243, 224),
        PrimaryDarkPrimaryData(100, 255, 224, 178),
        PrimaryDarkPrimaryData(200, 255, 204, 128),
        PrimaryDarkPrimaryData(300, 255, 283, 77),
        PrimaryDarkPrimaryData(400, 255, 167, 38),
        PrimaryDarkPrimaryData(500, 255, 152, 0),
        PrimaryDarkPrimaryData(600, 251, 140, 0),
        PrimaryDarkPrimaryData(700, 245, 124, 0),
        PrimaryDarkPrimaryData(800, 239, 108, 0),
        PrimaryDarkPrimaryData(900, 230, 81, 0),

        //deepOrange
        PrimaryDarkPrimaryData(50, 251, 233, 231),
        PrimaryDarkPrimaryData(100, 255, 204, 188),
        PrimaryDarkPrimaryData(200, 255, 171, 145),
        PrimaryDarkPrimaryData(300, 255, 138, 101),
        PrimaryDarkPrimaryData(400, 255, 112, 67),
        PrimaryDarkPrimaryData(500, 255, 87, 34),
        PrimaryDarkPrimaryData(600, 244, 81, 30),
        PrimaryDarkPrimaryData(700, 230, 74, 25),
        PrimaryDarkPrimaryData(800, 216, 67, 21),
        PrimaryDarkPrimaryData(900, 191, 54, 12),

        //brown
        PrimaryDarkPrimaryData(50, 239, 235, 233),
        PrimaryDarkPrimaryData(100, 215, 204, 200),
        PrimaryDarkPrimaryData(200, 188, 170, 164),
        PrimaryDarkPrimaryData(300, 161, 136, 127),
        PrimaryDarkPrimaryData(400, 141, 110, 99),
        PrimaryDarkPrimaryData(500, 121, 85, 72),
        PrimaryDarkPrimaryData(600, 109, 76, 65),
        PrimaryDarkPrimaryData(700, 93, 64, 55),
        PrimaryDarkPrimaryData(800, 78, 52, 46),
        PrimaryDarkPrimaryData(900, 62, 39, 35),

        //grey
        PrimaryDarkPrimaryData(50, 250, 250, 250),
        PrimaryDarkPrimaryData(100, 245, 245, 245),
        PrimaryDarkPrimaryData(200, 238, 238, 238),
        PrimaryDarkPrimaryData(300, 224, 224, 224),
        PrimaryDarkPrimaryData(400, 189, 189, 189),
        PrimaryDarkPrimaryData(500, 158, 158, 158),
        PrimaryDarkPrimaryData(600, 117, 117, 117),
        PrimaryDarkPrimaryData(700, 97, 97, 97),
        PrimaryDarkPrimaryData(800, 66, 66, 66),
        PrimaryDarkPrimaryData(900, 33, 33, 33),

        //blueGrey
        PrimaryDarkPrimaryData(50, 236, 239, 241),
        PrimaryDarkPrimaryData(100, 207, 216, 220),
        PrimaryDarkPrimaryData(200, 176, 190, 197),
        PrimaryDarkPrimaryData(300, 144, 164, 174),
        PrimaryDarkPrimaryData(400, 120, 144, 156),
        PrimaryDarkPrimaryData(500, 96, 125, 139),
        PrimaryDarkPrimaryData(600, 84, 110, 122),
        PrimaryDarkPrimaryData(700, 69, 90, 100),
        PrimaryDarkPrimaryData(800, 55, 71, 79),
        PrimaryDarkPrimaryData(900, 38, 50, 56)
    )

    val realm: Realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

//        val colorPalette = read()

        val numberOfIndex = paletteDate.lastIndex

        val cccd = intent.getIntExtra("cdc", 443)
        primaryTextView.setBackgroundColor(cccd)
        val primaryRed = cccd.red
        val primaryGreen = cccd.green
        val primaryBlue = cccd.blue

        val colorCode = intent.getStringExtra("colorCode")
        primaryTextView.text = "$colorCode"

//        paletteDate.forEach { i ->
//            val first =
//                (primaryRed - i.primaryColorR) * (primaryRed - i.primaryColorR) + (primaryGreen - i.primaryColorG) * (primaryGreen - i.primaryColorG) + (primaryBlue - i.primaryColorB) * (primaryBlue - i.primaryColorB)
////            i++ ->
////            val array = intArrayOf(first)
//            val intMin = calcMin(intArrayOf(first))
//
//            fun calcMin(array: IntArray): Int {
//                var intMin = array[0]
//                for (i in 1 until array.size) {
//                    if (intMin > array[i]) {
//                        intMin = array[i]
//                    }
//                }
//                return intMin
//            }
//
//        }
        //        for (i++ in paletteDate)
        var indexR = 0
        var indexG = 0
        var indexB = 0
        var indexDR = 0
        var indexDG = 0
        var indexDB = 0
        var min = 999999
        paletteDate.forEach{ i ->
            val first = (primaryRed - i.primaryColorR) * (primaryRed - i.primaryColorR) + (primaryGreen - i.primaryColorG) * (primaryGreen - i.primaryColorG) + (primaryBlue - i.primaryColorB) * (primaryBlue - i.primaryColorB)

            if(first < min) {
                min = first
                indexR = i.primaryColorR
                indexG = i.primaryColorG
                indexB = i.primaryColorB

                indexDR = i.primaryDakColorR
                indexDG = i.primaryDakColorG
                indexDB = i.primaryDakColorB

darkTextView.setBackgroundColor(Color.rgb(indexDR, indexDG, indexDB))
            }
//            paletteDate[i.toString().toInt()]
//            Log.d("tttg", i.toString())
        }

//        fun main(args: Array<String>) {
//        paletteDate.forEach { i ->
//            val first =
//                (primaryRed - i.primaryColorR) * (primaryRed - i.primaryColorR) + (primaryGreen - i.primaryColorG) * (primaryGreen - i.primaryColorG) + (primaryBlue - i.primaryColorB) * (primaryBlue - i.primaryColorB)
//
//            val array = intArrayOf(first)
//            val tty = array.min()
//            Log.d("jjkf", tty.toString())
//            val intMin = calcMin(array)
//            Log.d("jjd", intMin.toString())
////                darkTextView.setBackgroundColor(Color.rgb(intMin.primary))
//        }
//        }

//primaryDark
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//        window.statusBarColor = Color.parseColor("カラーコード")
        //primary
        supportActionBar?.setBackgroundDrawable(
            ColorDrawable(
                Color.rgb(
                    primaryRed,
                    primaryGreen,
                    primaryBlue
                )
            )
        )

        val adapter = RecyclerViewAdapter(this, object : RecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(item: ColorData) {
//                val code: Int = item.colorCode.toInt()
                floatingActionButton.backgroundTintList =
                    ColorStateList.valueOf(
                        Color.rgb(
                            item.accentColorR,
                            item.accentColorG,
                            item.accentColorB
                        )
                    )
                accentTextView.setBackgroundColor(
                    Color.rgb(
                        item.accentColorR,
                        item.accentColorG,
                        item.accentColorB
                    )
                )

                val rgbColor = Color.rgb(
                    item.accentColorR,
                    item.accentColorG,
                    item.accentColorB
                )
                val hexVibColors = "#" + Integer.toHexString(rgbColor).substring(2)
                val hexVibColor = "$hexVibColors"
                accentTextView.text = hexVibColor
            }
        })
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter

        adapter.addAll(colorData)

        val likeData: LikeData? = read()
        floatingActionButton.setOnClickListener {
            AlertDialog.Builder(this)
//                    .setTitle("title")
                .setMessage("このパレットをお気に入りに追加しますか")
                .setPositiveButton("はい",
                    DialogInterface.OnClickListener { dialog, which ->
                        // OK button pressed
                        if (textView.background is ColorDrawable) {
                            val cd = textView.background as ColorDrawable
                            val colorCode = cd.color
                            Log.d("ssd", colorCode.toString())
                        } else {
                            Log.d("ssd", "null")
                        }
                        val editText = EditText(this)
                        editText.hint = "Enter your palette name"
                        AlertDialog.Builder(this)
//                .setTitle("タイトル")
                            .setMessage("パレットの名前を入れてね")
                            .setView(editText)
                            .setPositiveButton(
                                "OK"
                            ) { dialog, which ->
                                // お好きな処理をどうぞ
                                val name = editText.text.toString()
                                val primaryTextView = findViewById<TextView>(R.id.primaryTextView)
                                val primaryBack: Int =
                                    (primaryTextView.background as ColorDrawable).color
                                Log.d("bb", primaryBack.toString())
                                val darkTextView = findViewById<TextView>(R.id.darkTextView)
                                val darkBack: Int =
                                    (darkTextView.background as ColorDrawable).color
                                val accentTextView = findViewById<TextView>(R.id.accentTextView)
                                val accentBack: Int =
                                    (accentTextView.background as ColorDrawable).color
                                Log.d("bbb", accentBack.toString())
                                save(name, primaryBack, darkBack, accentBack)
                                val intent = Intent(applicationContext, LikeActivity::class.java)
                                startActivity(intent)
                            }
                            .show()
                    })
                .setNegativeButton("いいえ", null)
                .show()

        }

        hideButton.setOnClickListener {
            if (recyclerView.isVisible) {
                recyclerView.isVisible = false
                linearLayout.isVisible = false
                hideButton.setImageResource(R.drawable.ic_baseline_expand_less_24)
            } else {
                recyclerView.isVisible = true
                linearLayout.isVisible = true
                hideButton.setImageResource(R.drawable.ic_baseline_expand_more_24)
            }
        }
    }

//    class main() {
//        fun main(args: Array<String>) {
//            paletteDate.forEach { i ->
//                val first =
//                    (primaryRed - i.primaryColorR) * (primaryRed - i.primaryColorR) + (primaryGreen - i.primaryColorG) * (primaryGreen - i.primaryColorG) + (primaryBlue - i.primaryColorB) * (primaryBlue - i.primaryColorB)
//
//                val array = intArrayOf(first)
//                val intMin = calcMin(array)
//                println("最小値は$intMin")
//            }
//        }

    private fun calcMin(array: IntArray): Int {
        var intMin = array[0]
        for (i in 1 until array.size) {
            if (intMin > array[i]) {
                intMin = array[i]
            }
        }
        return intMin
    }
//    }

    private fun save(name: String, primaryBack: Int, darkBack: Int, accentBack: Int) {
        realm.executeTransaction {
            val likeData = it.createObject(LikeData::class.java, UUID.randomUUID().toString())
            likeData.name = name
            likeData.primary = primaryBack
            likeData.dark = darkBack
            likeData.accent = accentBack
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    private fun read(): LikeData? {
        return realm.where(LikeData::class.java).findFirst()
    }

//    fun setBackgroundColor(){
//        colorData.forEach {i->
//            accentColorCell.setBackgroundColor(Color.rgb())
//        }
}

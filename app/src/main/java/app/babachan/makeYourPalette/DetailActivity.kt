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
        PrimaryDarkPrimaryData(50, 255, 235, 238, 204, 185, 220),
        PrimaryDarkPrimaryData(100, 255, 205, 210, 203, 156, 161),
        PrimaryDarkPrimaryData(200, 239, 154, 154, 186, 109, 108),
        PrimaryDarkPrimaryData(300, 229, 115, 115,175, 68, 72),
        PrimaryDarkPrimaryData(400, 239, 83, 80, 182, 24, 39),
        PrimaryDarkPrimaryData(500, 244, 67, 54,186, 0, 13),
        PrimaryDarkPrimaryData(600, 229, 57, 53,171, 0, 13),
        PrimaryDarkPrimaryData(700, 211, 47, 47, 154,0,7),
        PrimaryDarkPrimaryData(800, 198, 40, 40,142,0,0 ),
        PrimaryDarkPrimaryData(900, 183, 28, 28127, 0,0),
//pink
        PrimaryDarkPrimaryData(50, 252, 228, 236, 201, 178, 186),
        PrimaryDarkPrimaryData(100, 248, 187, 208, 196, 139, 159),
        PrimaryDarkPrimaryData(200, 244, 143, 177,191, 95, 130),
        PrimaryDarkPrimaryData(300, 240, 98, 146, 186, 45, 101),
        PrimaryDarkPrimaryData(400, 236, 64, 122, 180, 0, 78),
        PrimaryDarkPrimaryData(500, 233, 30, 99, 176, 0, 58),
        PrimaryDarkPrimaryData(600, 216, 27, 96, 160, 0,55),
        PrimaryDarkPrimaryData(700, 194, 24, 91, 140, 0, 50),
        PrimaryDarkPrimaryData(800, 173, 20, 87, 120, 0, 46),
        PrimaryDarkPrimaryData(900, 136, 14, 79, 86, 0,39),

        //purple
        PrimaryDarkPrimaryData(50, 243, 229, 245, 192, 179, 194),
        PrimaryDarkPrimaryData(100, 225, 190, 231, 175, 142, 181),
        PrimaryDarkPrimaryData(200, 206, 147, 216, 156, 100, 166),
        PrimaryDarkPrimaryData(300, 186, 104, 200, 136, 57, 151),
        PrimaryDarkPrimaryData(400, 171, 71, 188, 121,14, 139),
        PrimaryDarkPrimaryData(500, 156, 39, 176, 106, 0, 128),
        PrimaryDarkPrimaryData(600, 142, 36, 170, 92, 0, 122),
        PrimaryDarkPrimaryData(700, 123, 31, 162, 74, 0,114),
        PrimaryDarkPrimaryData(800, 106, 27, 154, 56, 0, 107),
        PrimaryDarkPrimaryData(900, 74, 20, 140,18, 0, 94),

        //deepPurple
        PrimaryDarkPrimaryData(50, 237, 231, 246, 187, 181, 195),
        PrimaryDarkPrimaryData(100, 209, 196, 233, 160, 148, 183),
        PrimaryDarkPrimaryData(200, 179, 157, 219, 131, 111, 169),
        PrimaryDarkPrimaryData(300, 149, 117, 205, 101, 73,156),
        PrimaryDarkPrimaryData(400, 126, 87, 194, 77, 44,145),
        PrimaryDarkPrimaryData(500, 103, 58, 183, 50 ,11, 134),
        PrimaryDarkPrimaryData(600, 94, 53, 177, 40, 6, 128),
        PrimaryDarkPrimaryData(700, 81, 45, 168, 20, 0,120),
        PrimaryDarkPrimaryData(800, 69, 39, 160, 0,0,112),
        PrimaryDarkPrimaryData(900, 49, 27, 146,0,0,99),

        //indigo
        PrimaryDarkPrimaryData(50, 232, 234, 246, 182, 184, 195),
        PrimaryDarkPrimaryData(100, 197, 202, 233, 148, 153, 183),
        PrimaryDarkPrimaryData(200, 159, 168, 218, 111,121,168),
        PrimaryDarkPrimaryData(300, 121, 134, 203, 73, 89, 154),
        PrimaryDarkPrimaryData(400, 92, 107, 192, 38, 65, 143),
        PrimaryDarkPrimaryData(500, 63, 81, 181, 0,41, 132),
        PrimaryDarkPrimaryData(600, 57, 73, 1710, 34,123),
        PrimaryDarkPrimaryData(700, 48, 63, 159,0, 25,112),
        PrimaryDarkPrimaryData(800, 40, 53, 147, 0,16, 100),
        PrimaryDarkPrimaryData(900, 26, 35, 126,0,0,81),

        //blue
        PrimaryDarkPrimaryData(50, 227, 242, 253, 177, 191, 202),
        PrimaryDarkPrimaryData(100, 187, 222, 251, 138, 172, 200),
        PrimaryDarkPrimaryData(200, 144, 202, 249, 93, 153, 198),
        PrimaryDarkPrimaryData(300, 100, 181, 246, 34, 134, 195),
        PrimaryDarkPrimaryData(400, 66, 165, 2450, 119, 194),
        PrimaryDarkPrimaryData(500, 33, 150, 243,0, 105,192),
        PrimaryDarkPrimaryData(600, 30, 136, 229,0,92, 178),
        PrimaryDarkPrimaryData(700, 25, 118, 210,0,75,160),
        PrimaryDarkPrimaryData(800, 21, 101, 192, 0,60, 143),
        PrimaryDarkPrimaryData(900, 13, 71, 161, 0, 33,113),

        //lightBlue
        PrimaryDarkPrimaryData(50, 225, 245, 254, 175, 194, 203),
        PrimaryDarkPrimaryData(100, 179, 229, 252, 130, 179, 201),
        PrimaryDarkPrimaryData(200, 129, 212, 250, 75, 163, 199),
        PrimaryDarkPrimaryData(300, 79, 195, 247, 0,147,196),
        PrimaryDarkPrimaryData(400, 41, 182, 246, 0,134,195),
        PrimaryDarkPrimaryData(500, 3, 169, 244, 0,122,193),
        PrimaryDarkPrimaryData(600, 3, 155, 229, 0,109,179),
        PrimaryDarkPrimaryData(700, 2, 136, 209, 0,91,159),
        PrimaryDarkPrimaryData(800, 2, 119, 189, 0,76, 140),
        PrimaryDarkPrimaryData(900, 1, 87, 155, 0, 47, 108),

        //cyan
        PrimaryDarkPrimaryData(50, 224, 247, 250, 174, 196, 199),
        PrimaryDarkPrimaryData(100, 178, 235, 242, 129, 185, 191),
        PrimaryDarkPrimaryData(200, 128, 222, 234, 75, 172, 184),
        PrimaryDarkPrimaryData(300, 77, 208, 225, 0,159,175),
        PrimaryDarkPrimaryData(400, 38, 198, 218, 0,149, 168),
        PrimaryDarkPrimaryData(500, 0, 188, 212, 0,139,163),
        PrimaryDarkPrimaryData(600, 0, 172, 193, 0,124, 145),
        PrimaryDarkPrimaryData(700, 0, 151, 167, 0,105,120),
        PrimaryDarkPrimaryData(800, 0, 131, 143, 0, 86,98),
        PrimaryDarkPrimaryData(900, 0, 96, 100, 0,54,58),

        //teal
        PrimaryDarkPrimaryData(50, 224, 242, 241, 174, 191, 190),
        PrimaryDarkPrimaryData(100, 178, 223, 219, 130, 173, 169),
        PrimaryDarkPrimaryData(200, 128, 203, 196, 79, 154, 148),
        PrimaryDarkPrimaryData(300, 77, 182, 172, 0,134,125),
        PrimaryDarkPrimaryData(400, 38, 166, 154, 0,118,108),
        PrimaryDarkPrimaryData(500, 0, 150, 136, 0,103,91),
        PrimaryDarkPrimaryData(600, 0, 137, 123, 0,91, 79),
        PrimaryDarkPrimaryData(700, 0, 121, 107, 0,76, 64),
        PrimaryDarkPrimaryData(800, 0, 105, 92, 0,61,51),
        PrimaryDarkPrimaryData(900, 0, 77, 64,0, 37, 26),

        //green
        PrimaryDarkPrimaryData(50, 232, 245, 233, 182, 194, 183),
        PrimaryDarkPrimaryData(100, 200, 230, 201, 151,180,152),
        PrimaryDarkPrimaryData(200, 200, 230, 201, 117, 164,120),
        PrimaryDarkPrimaryData(300, 129, 199, 132, 81, 150, 87),
        PrimaryDarkPrimaryData(400, 102, 187, 106, 51, 138, 62),
        PrimaryDarkPrimaryData(500, 76, 175, 80, 8, 127, 35),
        PrimaryDarkPrimaryData(600, 67, 160, 71, 0,112,26),
        PrimaryDarkPrimaryData(700, 56, 142, 60, 0,96,15),
        PrimaryDarkPrimaryData(800, 46, 125, 50, 0,80,5),
        PrimaryDarkPrimaryData(900, 27, 94, 32, 0,51,0),

        //lightGreen
        PrimaryDarkPrimaryData(50, 241, 248, 233, 190, 197, 183),
        PrimaryDarkPrimaryData(100, 220, 237, 200, 170, 187, 151),
        PrimaryDarkPrimaryData(200, 197, 225, 165, 148, 175,118),
        PrimaryDarkPrimaryData(300, 174, 213, 129, 125, 164, 83),
        PrimaryDarkPrimaryData(400, 156, 204, 101, 107, 155, 55),
        PrimaryDarkPrimaryData(500, 139, 195, 74, 90, 146, 22),
        PrimaryDarkPrimaryData(600, 124, 179, 66, 75, 131, 13),
        PrimaryDarkPrimaryData(700, 104, 159, 56, 56, 112,2),
        PrimaryDarkPrimaryData(800, 85, 139, 47, 37, 93, 0),
        PrimaryDarkPrimaryData(900, 51, 105, 30, 0,61,0),

        //lime
        PrimaryDarkPrimaryData(50, 249, 251, 231, 198, 200, 181),
        PrimaryDarkPrimaryData(100, 240, 244, 195,189, 193, 146 ),
        PrimaryDarkPrimaryData(200, 230, 238, 156, 179, 188,109),
        PrimaryDarkPrimaryData(300, 220, 231, 117, 168, 181,69),
        PrimaryDarkPrimaryData(400, 212, 225, 87, 160, 175, 34),
        PrimaryDarkPrimaryData(500, 205, 220, 57, 153, 170,0),
        PrimaryDarkPrimaryData(600, 192, 202, 51, 140, 153, 0),
        PrimaryDarkPrimaryData(700, 175, 180, 43,124, 133, 0),
        PrimaryDarkPrimaryData(800, 158, 157, 36, 108, 111,0),
        PrimaryDarkPrimaryData(900, 130, 119, 23, 82, 76,0),

        //yellow
        PrimaryDarkPrimaryData(50, 255, 253, 231, 204, 202, 181),
        PrimaryDarkPrimaryData(100, 255, 249, 196, 203, 198, 147),
        PrimaryDarkPrimaryData(200, 255, 245, 157, 203, 194, 109),
        PrimaryDarkPrimaryData(300, 255, 241, 118, 202, 191, 69),
        PrimaryDarkPrimaryData(400, 255, 238, 88, 201, 188, 31),
        PrimaryDarkPrimaryData(500, 255, 235, 59, 200, 185,0),
        PrimaryDarkPrimaryData(600, 253, 216, 53, 198,167,0),
        PrimaryDarkPrimaryData(700, 251, 192, 45, 196, 144,0),
        PrimaryDarkPrimaryData(800, 249, 168, 37, 193, 121,0),
        PrimaryDarkPrimaryData(900, 245, 127, 23, 188,81,0),

        //amber
        PrimaryDarkPrimaryData(50, 255, 248, 225, 204, 197, 175),
        PrimaryDarkPrimaryData(100, 255, 236, 179, 203, 186, 131),
        PrimaryDarkPrimaryData(200, 255, 224, 130, 202, 174, 83),
        PrimaryDarkPrimaryData(300, 255, 213, 79, 200, 164, 21),
        PrimaryDarkPrimaryData(400, 255, 202, 40, 199,154,0),
        PrimaryDarkPrimaryData(500, 255, 193, 7, 199,145,0),
        PrimaryDarkPrimaryData(600, 255, 179, 0, 198, 132,0),
        PrimaryDarkPrimaryData(700, 255, 160, 0, 98,113,0),
        PrimaryDarkPrimaryData(800, 255, 243, 0, 197, 96,0),
        PrimaryDarkPrimaryData(900, 255, 111, 0, 196,62,0),

        //orange
        PrimaryDarkPrimaryData(50, 255, 243, 224, 204,192, 174),
        PrimaryDarkPrimaryData(100, 255, 224, 178, 203, 174, 130),
        PrimaryDarkPrimaryData(200, 255, 204, 128, 202,155,82),
        PrimaryDarkPrimaryData(300, 255, 283, 77, 200, 135,25),
        PrimaryDarkPrimaryData(400, 255, 167, 38, 199,120,0),
        PrimaryDarkPrimaryData(500, 255, 152, 0, 198, 105,0),
        PrimaryDarkPrimaryData(600, 251, 140, 0, 194,94,0),
        PrimaryDarkPrimaryData(700, 245, 124, 0, 187, 77,0),
        PrimaryDarkPrimaryData(800, 239, 108, 0, 181,61,0),
        PrimaryDarkPrimaryData(900, 230, 81, 0, 172,25,0),

        //deepOrange
        PrimaryDarkPrimaryData(50, 251, 233, 231, 200,183,181),
        PrimaryDarkPrimaryData(100, 255, 204, 188, 203, 155,140),
        PrimaryDarkPrimaryData(200, 255, 171, 145, 201,123, 99),
        PrimaryDarkPrimaryData(300, 255, 138, 101,199,91,57),
        PrimaryDarkPrimaryData(400, 255, 112, 67, 198,63,23),
        PrimaryDarkPrimaryData(500, 255, 87, 34, 196, 28,0),
        PrimaryDarkPrimaryData(600, 244, 81, 30, 185, 20,0),
        PrimaryDarkPrimaryData(700, 230, 74, 25, 172, 8,0),
        PrimaryDarkPrimaryData(800, 216, 67, 21, 159,0,0),
        PrimaryDarkPrimaryData(900, 191, 54, 12, 135,0,0),

        //brown
        PrimaryDarkPrimaryData(50, 239, 235, 233, 189,185,183),
        PrimaryDarkPrimaryData(100, 215, 204, 200, 166,155,151),
        PrimaryDarkPrimaryData(200, 188, 170, 164, 140, 123,117),
        PrimaryDarkPrimaryData(300, 161, 136, 127, 114,91,83),
        PrimaryDarkPrimaryData(400, 141, 110, 99,95,67,57),
        PrimaryDarkPrimaryData(500, 121, 85, 72, 75,44,32),
        PrimaryDarkPrimaryData(600, 109, 76, 65, 64,36,26),
        PrimaryDarkPrimaryData(700, 93, 64, 55, 50,25,17),
        PrimaryDarkPrimaryData(800, 78, 52, 46, 38,14,4),
        PrimaryDarkPrimaryData(900, 62, 39, 35, 27,0,0),

        //grey
        PrimaryDarkPrimaryData(50, 250, 250, 250, 199,199,199),
        PrimaryDarkPrimaryData(100, 245, 245, 245, 194, 194,194),
        PrimaryDarkPrimaryData(200, 238, 238, 238, 188,188,188),
        PrimaryDarkPrimaryData(300, 224, 224, 224, 174,174,174),
        PrimaryDarkPrimaryData(400, 189, 189, 189, 141,141,141),
        PrimaryDarkPrimaryData(500, 158, 158, 158, 112,112,112),
        PrimaryDarkPrimaryData(600, 117, 117, 117,73,73,73),
        PrimaryDarkPrimaryData(700, 97, 97, 97, 55,55,55),
        PrimaryDarkPrimaryData(800, 66, 66, 66, 27,27,27),
        PrimaryDarkPrimaryData(900, 33, 33, 33,0,0,0),

        //blueGrey
        PrimaryDarkPrimaryData(50, 236, 239, 241, 186,189,190),
        PrimaryDarkPrimaryData(100, 207, 216, 220, 158, 167,170),
        PrimaryDarkPrimaryData(200, 176, 190, 197, 128, 142,149),
        PrimaryDarkPrimaryData(300, 144, 164, 174, 98, 117, 127),
        PrimaryDarkPrimaryData(400, 120, 144, 156, 75,99,110),
        PrimaryDarkPrimaryData(500, 96, 125, 139, 52,81,94),
        PrimaryDarkPrimaryData(600, 84, 110, 122, 41,67,78),
        PrimaryDarkPrimaryData(700, 69, 90, 100, 28,49,58),
        PrimaryDarkPrimaryData(800, 55, 71, 79, 16,132,39),
        PrimaryDarkPrimaryData(900, 38, 50, 56,0,10,1)
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
                        window.statusBarColor = Color.rgb(indexDR, indexDG, indexDB)
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
            val editText = EditText(this)
            editText.hint = "Enter your palette name"
            AlertDialog.Builder(this)
                .setTitle("このパレットをお気に入りに追加しますか")
                .setMessage("パレットの名前を入れてね")
                .setView(editText)
                .setPositiveButton("OK",
                    DialogInterface.OnClickListener { dialog, which ->
                        // OK button pressed
                        if (textView.background is ColorDrawable) {
                            val cd = textView.background as ColorDrawable
                            val colorCode = cd.color
                            Log.d("ssd", colorCode.toString())
                        } else {
                            Log.d("ssd", "null")
                        }
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

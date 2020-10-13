package app.babachan.l4soriginal

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    val colorData: List<ColorData> = listOf(
        //red
//            ColorData(50, 255, 235, 238),
//            ColorData(100, 255, 205, 210),
//            ColorData(200, 239, 154, 154),
//            ColorData(300, 229, 115, 115),
//            ColorData(400, 239, 83, 80),
//            ColorData(500, 244, 67, 54),
//            ColorData(600, 229, 57, 53),
//            ColorData(700, 211, 47, 47),
//            ColorData(800, 198, 40, 40),
//            ColorData(900, 183, 28, 28),
//
////pink
//            ColorData(50, 252, 228, 236),
//            ColorData(100, 248, 187, 208),
//            ColorData(200, 244, 143, 177),
//            ColorData(300, 240, 98, 146),
//            ColorData(400, 236, 64, 122),
//            ColorData(500, 233, 30, 99),
//            ColorData(600, 216, 27, 96),
//            ColorData(700, 194, 24, 91),
//            ColorData(800, 173, 20, 87),
//            ColorData(900, 136, 14, 79),
//
//            //purple
//            ColorData(50, 243, 229, 245),
//            ColorData(100, 225, 190, 231),
//            ColorData(200, 206, 147, 216),
//            ColorData(300, 186, 104, 200),
//            ColorData(400, 171, 71, 188),
//            ColorData(500, 156, 39, 176),
//            ColorData(600, 142, 36, 170),
//            ColorData(700, 123, 31, 162),
//            ColorData(800, 106, 27, 154),
//            ColorData(900, 74, 20, 140),
//
//            //deepPurple
//            ColorData(50, 237, 231, 246),
//            ColorData(100, 209, 196, 233),
//            ColorData(200, 179, 157, 219),
//            ColorData(300, 149, 117, 205),
//            ColorData(400, 126, 87, 194),
//            ColorData(500, 103, 58, 183),
//            ColorData(600, 94, 53, 177),
//            ColorData(700, 81, 45, 168),
//            ColorData(800, 69, 39, 160),
//            ColorData(900, 49, 27, 146),
//
//            //indigo
//            ColorData(50, 232, 234, 246),
//            ColorData(100, 197, 202, 233),
//            ColorData(200, 159, 168, 218),
//            ColorData(300, 121, 134, 203),
//            ColorData(400, 92, 107, 192),
//            ColorData(500, 63, 81, 181),
//            ColorData(600, 57, 73, 171),
//            ColorData(700, 48, 63, 159),
//            ColorData(800, 40, 53, 147),
//            ColorData(900, 26, 35, 126),
//
//            //blue
//            ColorData(50, 227, 242, 253),
//            ColorData(100, 187, 222, 251),
//            ColorData(200, 144, 202, 249),
//            ColorData(300, 100, 181, 246),
//            ColorData(400, 66, 165, 245),
//            ColorData(500, 33, 150, 243),
//            ColorData(600, 30, 136, 229),
//            ColorData(700, 25, 118, 210),
//            ColorData(800, 21, 101, 192),
//            ColorData(900, 13, 71, 161),
//
//            //lightBlue
//            ColorData(50, 225, 245, 254),
//            ColorData(100, 179, 229, 252),
//            ColorData(200, 129, 212, 250),
//            ColorData(300, 79, 195, 247),
//            ColorData(400, 41, 182, 246),
//            ColorData(500, 3, 169, 244),
//            ColorData(600, 3, 155, 229),
//            ColorData(700, 2, 136, 209),
//            ColorData(800, 2, 119, 189),
//            ColorData(900, 1, 87, 155),
//
//            //cyan
//            ColorData(50, 224, 247, 250),
//            ColorData(100, 178, 235, 242),
//            ColorData(200, 128, 222, 234),
//            ColorData(300, 77, 208, 225),
//            ColorData(400, 38, 198, 218),
//            ColorData(500, 0, 188, 212),
//            ColorData(600, 0, 172, 193),
//            ColorData(700, 0, 151, 167),
//            ColorData(800, 0, 131, 143),
//            ColorData(900, 0, 96, 100),
//
//            //teal
//            ColorData(50, 224, 242, 241),
//            ColorData(100, 178, 223, 219),
//            ColorData(200, 128, 203, 196),
//            ColorData(300, 77, 182, 172),
//            ColorData(400, 38, 166, 154),
//            ColorData(500, 0, 150, 136),
//            ColorData(600, 0, 137, 123),
//            ColorData(700, 0, 121, 107),
//            ColorData(800, 0, 105, 92),
//            ColorData(900, 0, 77, 64),
//
//            //green
//            ColorData(50, 232, 245, 233),
//            ColorData(100, 200, 230, 201),
//            ColorData(200, 200, 230, 201),
//            ColorData(300, 129, 199, 132),
//            ColorData(400, 102, 187, 106),
//            ColorData(500, 76, 175, 80),
//            ColorData(600, 67, 160, 71),
//            ColorData(700, 56, 142, 60),
//            ColorData(800, 46, 125, 50),
//            ColorData(900, 27, 94, 32),
//
//            //lightGreen
//            ColorData(50, 241, 248, 233),
//            ColorData(100, 220, 237, 200),
//            ColorData(200, 197, 225, 165),
//            ColorData(300, 174, 213, 129),
//            ColorData(400, 156, 204, 101),
//            ColorData(500, 139, 195, 74),
//            ColorData(600, 124, 179, 66),
//            ColorData(700, 104, 159, 56),
//            ColorData(800, 85, 139, 47),
//            ColorData(900, 51, 105, 30),
//
//            //lime
//            ColorData(50, 249, 251, 231),
//            ColorData(100, 240, 244, 195),
//            ColorData(200, 230, 238, 156),
//            ColorData(300, 220, 231, 117),
//            ColorData(400, 212, 225, 87),
//            ColorData(500, 205, 220, 57),
//            ColorData(600, 192, 202, 51),
//            ColorData(700, 175, 180, 43),
//            ColorData(800, 158, 157, 36),
//            ColorData(900, 130, 119, 23),
//
//            //yellow
//            ColorData(50, 255, 253, 231),
//            ColorData(100, 255, 249, 196),
//            ColorData(200, 255, 245, 157),
//            ColorData(300, 255, 241, 118),
//            ColorData(400, 255, 238, 88),
//            ColorData(500, 255, 235, 59),
//            ColorData(600, 253, 216, 53),
//            ColorData(700, 251, 192, 45),
//            ColorData(800, 249, 168, 37),
//            ColorData(900, 245, 127, 23),
//
//            //amber
//            ColorData(50, 255, 248, 225),
//            ColorData(100, 255, 236, 179),
//            ColorData(200, 255, 224, 130),
//            ColorData(300, 255, 213, 79),
//            ColorData(400),
//            ColorData(500),
//            ColorData(600),
//            ColorData(700),
//            ColorData(800),
//            ColorData(900),
//
//            //orange
//            ColorData(50),
//            ColorData(100),
//            ColorData(200),
//            ColorData(300),
//            ColorData(400),
//            ColorData(500),
//            ColorData(600),
//            ColorData(700),
//            ColorData(800),
//            ColorData(900),
//
//            //deepOrange
//            ColorData(50),
//            ColorData(100),
//            ColorData(200),
//            ColorData(300),
//            ColorData(400),
//            ColorData(500),
//            ColorData(600),
//            ColorData(700),
//            ColorData(800),
//            ColorData(900),
//
//            //brown
//            ColorData(50),
//            ColorData(100),
//            ColorData(200),
//            ColorData(300),
//            ColorData(400),
//            ColorData(500),
//            ColorData(600),
//            ColorData(700),
//            ColorData(800),
//            ColorData(900),
//
//            //grey
//            ColorData(50),
//            ColorData(100),
//            ColorData(200),
//            ColorData(300),
//            ColorData(400),
//            ColorData(500),
//            ColorData(600),
//            ColorData(700),
//            ColorData(800),
//            ColorData(900),
//
//            //blueGrey
//            ColorData(50),
//            ColorData(100),
//            ColorData(200),
//            ColorData(300),
//            ColorData(400),
//            ColorData(500),
//            ColorData(600),
//            ColorData(700),
//            ColorData(800),
//            ColorData(900),

        //            //orange
//            ColorData(50),
//            ColorData(100),
//            ColorData(200),
//            ColorData(300),
//            ColorData(400),
//            ColorData(500),
//            ColorData(600),
//            ColorData(700),
//            ColorData(800),
//            ColorData(900),
//
//            //deepOrange
//            ColorData(50),
//            ColorData(100),
//            ColorData(200),
//            ColorData(300),
//            ColorData(400),
//            ColorData(500),
//            ColorData(600),
//            ColorData(700),
//            ColorData(800),
//            ColorData(900),
//
//            //brown
//            ColorData(50),
//            ColorData(100),
//            ColorData(200),
//            ColorData(300),
//            ColorData(400),
//            ColorData(500),
//            ColorData(600),
//            ColorData(700),
//            ColorData(800),
//            ColorData(900),
//
//            //grey
//            ColorData(50),
//            ColorData(100),
//            ColorData(200),
//            ColorData(300),
//            ColorData(400),
//            ColorData(500),
//            ColorData(600),
//            ColorData(700),
//            ColorData(800),
//            ColorData(900),
//
//            //blueGrey
//            ColorData(50),
//            ColorData(100),
//            ColorData(200),
//            ColorData(300),
//            ColorData(400),
//            ColorData(500),
//            ColorData(600),
//            ColorData(700),
//            ColorData(800),
//            ColorData(900),


        //red
        ColorData(100, 255, 138, 128),
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
        ColorData(200),
        ColorData(400),
        ColorData(700),

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val vibDetail = intent.getStringExtra("VIB") ?: "555"
        val vibDetailInt = vibDetail.toInt()
        primaryTextView.setText("#" + vibDetail)
//            primaryTextView.setBackgroundColor()
//
//            val v: View = target //    対象のビューです。
//
//            val colorInt = v.getBackground().color
//            val colort = resources.getColor(R.color.primaryCo)
        val color: Int = vibDetail.toInt(16)

//            val color = ContextCompat.getColor(applicationContext, vibDetailInt)
        val red = color shr 16 and 0xFF.toFloat().toInt()
        val green = color shr 8 and 0xFF.toFloat().toInt()
        val blue = color shr 0 and 0xFF.toFloat().toInt()
        val alpha = (color shr 24 and 0xFF.toFloat().toInt()).toFloat()

        primaryTextView.setBackgroundColor(Color.rgb(red, green, blue))

//            fun getRgbFromHex(): IntArray {
//                val initColor = Color.parseColor(vibDetail)
//                val r = Color.red(initColor)
//                val g = Color.green(initColor)
//                val b = Color.blue(initColor)
//                return intArrayOf(r, g, b)
//            }

//            val primaryR = getRgbFromHex()[0]
//            val primaryG = getRgbFromHex()[1]
//            val primaryB = getRgbFromHex()[2]

//            primaryTextView.setBackgroundColor(Color.rgb(primaryR, primaryG, primaryB))

//            val c = Color(vibDetail)
//            val color: Color = Color.decode(vibDetail)
//            val red: Int = color.getRed()
//            val blue: Int = color.getBlue()
//            val green: Int = color.getGreen()


        val adapter = RecyclerViewAdapter(this, object : RecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(item: ColorData) {
                accentTextView.setBackgroundColor(Color.rgb(item.accentColorR, item.accentColorG, item.accentColorB))
//                floatingActionButton.setBackgroundColor(Color.rgb(item.accentColorR, item.accentColorG, item.accentColorB))
                floatingActionButton.setBackgroundDrawable(ColorDrawable(Color.rgb(item.accentColorR, item.accentColorG, item.accentColorB)))
            }
        })
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter

        adapter.addAll(colorData)

//            adapter.setOnItemClickListener(object: CustomAdapter.OnItemClickListener{
//                override fun onItemClickListener(view: View, position: Int) {
//
//                }
//            })

//            floatingActionButton.setOnClickListener { }
    }

}
package app.babachan.l4soriginal

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import androidx.palette.graphics.Palette
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.String


class MainActivity : AppCompatActivity() {

    val readRequestCode: Int = 42

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val getImageView = findViewById<ImageView>(R.id.imageView)
        val bmp = (getImageView.drawable as BitmapDrawable).bitmap

        Palette.generateAsync(bmp, object : Palette.PaletteAsyncListener {
            override fun onGenerated(palette: Palette?) {
                if (palette != null) {
                    // VibrantSwatch
                    val vibrantSwatch = findViewById<TextView>(R.id.vibrantSwatchTextView)
                    if (vibrantSwatch != null) {
                        vibrantSwatch.setBackgroundColor(palette.vibrantSwatch!!.rgb)
                        val bbb =

                            Log.d("dd", palette.vibrantSwatch!!.rgb.red.toString())
                        Log.d("rafa", palette.vibrantSwatch!!.rgb.green.toString())
                        Log.d("rarer", palette.vibrantSwatch!!.rgb.blue.toString())
//                        Log.d("jj", palette.vibrantSwatch.toString())
//                        Log.d("kk", palette.vibrantSwatch!!.rgb.green.toString())

                        vibrantSwatch.setTextColor(palette.getVibrantSwatch()!!.getTitleTextColor())
//                        val hex = String.format("#", palette.vibrantSwatch)
//                        vibrantSwatch.setText(hex)
                        val darkVibrantSwatch = findViewById<TextView>(R.id.darkVibrantSwatch)
                        darkVibrantSwatch.setBackgroundColor(
                            palette.getDarkVibrantSwatch()!!.getRgb()
                        )
                        vibrantSwatch.setTextColor(
                            palette.getDarkVibrantSwatch()!!.getTitleTextColor()
                        )
                        val lightVibrantSwatch = findViewById<TextView>(R.id.lightVibrantSwatch)
                        lightVibrantSwatch.setBackgroundColor(
                            palette.getLightVibrantSwatch()!!.getRgb()
                        )
                        lightVibrantSwatch.setTextColor(
                            palette.getLightVibrantSwatch()!!.getTitleTextColor()
                        )

//                        //MutedSwatch
//                        val mutedSwatch = findViewById<TextView>(R.id.mutedSwatch)
//                        mutedSwatch.setBackgroundColor(palette.mutedSwatch!!.rgb)
//                        mutedSwatch.setTextColor(palette.getMutedSwatch()!!.getTitleTextColor())
//                        val darkMutedSwatch = findViewById<TextView>(R.id.dark_muted_swatch)
//                        darkMutedSwatch.setBackgroundColor(palette.getDarkMutedSwatch()!!.getRgb())
//                        darkMutedSwatch.setTextColor(
//                            palette.getDarkMutedSwatch()!!.getTitleTextColor()
//                        )
//                        val lightMutedSwatch = findViewById<TextView>(R.id.lightMutedSwatch)
//                        lightMutedSwatch.setBackgroundColor(
//                            if (palette.lightMutedSwatch != null) {
//                                palette.getLightMutedSwatch()!!.getRgb()
//                            } else {
//                                5
//                            }
//                        )
//                        if (palette.lightMutedSwatch != null) {
//                            lightMutedSwatch.setTextColor(
//                                palette.getLightMutedSwatch()!!.getTitleTextColor()
//
//                        )}
                    }

                    vibrantSwatchTextView.setOnClickListener {
                        val clr = Color.rgb(
                            palette.vibrantSwatch!!.rgb.red,
                            palette.vibrantSwatch!!.rgb.green,
                            palette.vibrantSwatch!!.rgb.blue
                        )
                        val intent = Intent(applicationContext, DetailActivity::class.java)
                        intent.putExtra("cdc", clr)
                        startActivity(intent)
                    }

                    darkVibrantSwatch.setOnClickListener {
                        val clr = Color.rgb(
                            palette.vibrantSwatch!!.rgb.red,
                            palette.vibrantSwatch!!.rgb.green,
                            palette.vibrantSwatch!!.rgb.blue
                        )
                        val intent = Intent(applicationContext, DetailActivity::class.java)
                        intent.putExtra("cdc", clr)
                        startActivity(intent)
                    }

                    lightVibrantSwatch.setOnClickListener {
                        val clr = Color.rgb(
                            palette.vibrantSwatch!!.rgb.red,
                            palette.vibrantSwatch!!.rgb.green,
                            palette.vibrantSwatch!!.rgb.blue
                        )
                        val intent = Intent(applicationContext, DetailActivity::class.java)
                        intent.putExtra("cdc", clr)
                        startActivity(intent)

                    }

//                    mutedSwatch.setOnClickListener {
//                            val intent = Intent(applicationContext, DetailActivity::class.java)
//                            val backColor = palette.mutedSwatch?.rgb
//                            intent.putExtra("VIB", backColor)
//                        Log.d("bbb", backColor.toString())
//                            startActivity(intent)
//                        }
//
//                    mutedSwatch.setOnClickListener {
//                            val intent = Intent(applicationContext, DetailActivity::class.java)
//                            val backColor = palette.darkMutedSwatch?.rgb
//                            intent.putExtra("VIB", backColor)
//                            startActivity(intent)
//                        }
//
//                    mutedSwatch.setOnClickListener {
//                            val intent = Intent(applicationContext, DetailActivity::class.java)
//                            val backColor = palette.lightMutedSwatch?.rgb
//                            intent.putExtra("VIB", backColor)
//                            startActivity(intent)
//                        }

                }


            }
        })
//        object PixelColorTest {
//            @JvmStatic
//            fun main(args: Array<kotlin.String>) {
//                try {
//                    val filePath = "c:\\test\\test.jpeg"
//
//                    //画像ファイルを読み込む
//                    val clr = R.id.primaryTextView
//
//                    //座標(10,20)の色を取得
//                    val color = Color(clr.getRGB(10, 20))
//
//                    //取得した色を標準出力
//                    System.out.println("R:" + color.getRed())
//                    System.out.println("G:" + color.getGreen())
//                    System.out.println("B:" + color.getBlue())
//                    System.out.println("A:" + color.getAlpha())
//                } catch (e: IOException) {
//                    e.printStackTrace()
//                }
//            }
//        }


        getImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            startActivityForResult(intent, readRequestCode)
        }


//        vibrantSwatchTextView.setOnClickListener {
//            val vibColor = vibrantSwatchTextView.getBackground()
////            val vibColor = vibrantSwatchTextView.text.toString()
//            val vibrantIntent = Intent(this, DetailActivity::class.java)
//            intent.putExtra("VIB", vibColor)
//            Log.d("gg", vibColor)
////            if (VIB == null) {
////                Toast.makeText(applicationContext, "色がありません", Toast.LENGTH_SHORT).show()
////
////            }
//            startActivity(vibrantIntent)
//        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, resultData: Intent?) {
        super.onActivityResult(requestCode, resultCode, resultData)

        if (requestCode == readRequestCode && resultCode == Activity.RESULT_OK)
            resultData?.data?.also { uri ->
//                image
                imageView.setImageURI(uri)
            }


        val getImageView = findViewById<ImageView>(R.id.imageView)
        val bmp = (getImageView.drawable as BitmapDrawable).bitmap

//        val image = imageView
//        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.sky)

        Palette.generateAsync(bmp, object : Palette.PaletteAsyncListener {
            override fun onGenerated(palette: Palette?) {
                if (palette != null) {
                    // VibrantSwatch
                    val vibrantSwatch = findViewById<TextView>(R.id.vibrantSwatchTextView)
                    if (vibrantSwatch != null) {
                        palette.vibrantSwatch?.rgb?.let { vibrantSwatch.setBackgroundColor(it) }
                        palette.getVibrantSwatch()?.getTitleTextColor()?.let {
                            vibrantSwatch.setTextColor(
                                it
                            )
                        }
                        val darkVibrantSwatch = findViewById<TextView>(R.id.darkVibrantSwatch)
                        palette.getDarkVibrantSwatch()?.getRgb()?.let {
                            darkVibrantSwatch.setBackgroundColor(
                                it
                            )
                        }
                        palette.getDarkVibrantSwatch()?.getTitleTextColor()?.let {
                            vibrantSwatch.setTextColor(
                                it
                            )
                        }
                        val lightVibrantSwatch = findViewById<TextView>(R.id.lightVibrantSwatch)
                        palette.getLightVibrantSwatch()?.getRgb()?.let {
                            lightVibrantSwatch.setBackgroundColor(
                                it
                            )
                        }
                        palette.getLightVibrantSwatch()?.getTitleTextColor()?.let {
                            lightVibrantSwatch.setTextColor(
                                it
                            )
                        }

//                        //MutedSwatch
//                        val mutedSwatch = findViewById<TextView>(R.id.mutedSwatch)
//                        palette.getMutedSwatch()?.getRgb()?.let { mutedSwatch.setBackgroundColor(it) }
//                        palette.getMutedSwatch()?.getTitleTextColor()?.let {
//                            mutedSwatch.setTextColor(
//                                it
//                            )
//                        }
//                        val darkMutedSwatch = findViewById<TextView>(R.id.dark_muted_swatch)
//                        palette.getDarkMutedSwatch()?.getRgb()?.let {
//                            darkMutedSwatch.setBackgroundColor(
//                                it
//                            )
//                        }
//                        palette.getDarkMutedSwatch()?.getTitleTextColor()?.let {
//                            darkMutedSwatch.setTextColor(
//                                it
//                            )
//                        }
//                        val lightMutedSwatch = findViewById<TextView>(R.id.lightMutedSwatch)
//                        palette.getLightMutedSwatch()?.getRgb()?.let {
//                            lightMutedSwatch.setBackgroundColor(
//                                it
//                            )
//                        }
//                        palette.getLightMutedSwatch()?.getTitleTextColor()?.let {
//                            lightMutedSwatch.setTextColor(
//                                it
//                            )
//                        }
                    }

                    vibrantSwatchTextView.setOnClickListener {
                        val clr = Color.rgb(
                            palette.vibrantSwatch!!.rgb.red,
                            palette.vibrantSwatch!!.rgb.green,
                            palette.vibrantSwatch!!.rgb.blue
                        )
                        val intent = Intent(applicationContext, DetailActivity::class.java)
                        intent.putExtra("cdc", clr)
                        startActivity(intent)
                    }

                    darkVibrantSwatch.setOnClickListener {
                        val clr = Color.rgb(
                            palette.vibrantSwatch!!.rgb.red,
                            palette.vibrantSwatch!!.rgb.green,
                            palette.vibrantSwatch!!.rgb.blue
                        )
                        val intent = Intent(applicationContext, DetailActivity::class.java)
                        intent.putExtra("cdc", clr)
                        startActivity(intent)
                    }

                    lightVibrantSwatch.setOnClickListener {
                        val clr = Color.rgb(
                            palette.vibrantSwatch!!.rgb.red,
                            palette.vibrantSwatch!!.rgb.green,
                            palette.vibrantSwatch!!.rgb.blue
                        )
                        val intent = Intent(applicationContext, DetailActivity::class.java)
                        intent.putExtra("cdc", clr)
                        startActivity(intent)

                    }


//                    mutedSwatch.setOnClickListener {
//                            val intent = Intent(applicationContext, DetailActivity::class.java)
//                            val backColor = palette.mutedSwatch?.rgb
//                            intent.putExtra("VIB", backColor)
//                            startActivity(intent)
//                        }
//
//                    mutedSwatch.setOnClickListener {
//                            val intent = Intent(applicationContext, DetailActivity::class.java)
//                            val backColor = palette.darkMutedSwatch?.rgb
//                            intent.putExtra("VIB", backColor)
//                            startActivity(intent)
//                        }
//
//                    mutedSwatch.setOnClickListener {
//                            val intent = Intent(applicationContext, DetailActivity::class.java)
//                            val backColor = palette.lightMutedSwatch?.rgb
//                            intent.putExtra("VIB", backColor)
//                            startActivity(intent)
//                    }

                }

            }
        })
    }
}
package app.babachan.l4soriginal

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import androidx.palette.graphics.Palette
import kotlinx.android.synthetic.main.activity_main.*


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
                        val intVibColor = palette.vibrantSwatch!!.rgb
                        val hexVibColors = "#" + Integer.toHexString(intVibColor).substring(2)
                        val hexVibColor = "$hexVibColors"
                        val vibrantSwatchTextView =
                            findViewById<TextView>(R.id.vibrantSwatchTextView)
                        vibrantSwatchTextView.text = hexVibColor
//                        vibrantSwatch.setTextColor(palette.vibrantSwatch!!.titleTextColor)

                        val darkVibrantSwatch =
                            findViewById<TextView>(R.id.darkVibrantSwatchTextView)
                        darkVibrantSwatch.setBackgroundColor(palette.darkVibrantSwatch!!.rgb)
                        val intDarkColor = palette.darkVibrantSwatch!!.rgb
                        val hexDarkColors = "#" + Integer.toHexString(intDarkColor).substring(2)
                        val hexDarkColor = "$hexDarkColors"
                        val darkVibrantSwatchTextView =
                            findViewById<TextView>(R.id.darkVibrantSwatchTextView)
                        darkVibrantSwatchTextView.text = hexDarkColor
//                        vibrantSwatch.setTextColor(palette.darkVibrantSwatch!!.titleTextColor)

                        val lightVibrantSwatch =
                            findViewById<TextView>(R.id.lightVibrantSwatchTextView)
                        lightVibrantSwatch.setBackgroundColor(palette.lightVibrantSwatch!!.rgb)
                        val intLightColor = palette.lightVibrantSwatch!!.rgb
                        val hexLightColors = "#" + Integer.toHexString(intLightColor).substring(2)
                        val hexLightColor = "$hexLightColors"
                        val lightVibrantSwatchTextView =
                            findViewById<TextView>(R.id.lightVibrantSwatchTextView)
                        lightVibrantSwatchTextView.text = hexLightColor
//                        lightVibrantSwatch.setTextColor(palette.lightVibrantSwatch!!.titleTextColor)

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

                    darkVibrantSwatchTextView.setOnClickListener {
                        val clr = Color.rgb(
                            palette.vibrantSwatch!!.rgb.red,
                            palette.vibrantSwatch!!.rgb.green,
                            palette.vibrantSwatch!!.rgb.blue
                        )
                        val intent = Intent(applicationContext, DetailActivity::class.java)
                        intent.putExtra("cdc", clr)
                        startActivity(intent)
                    }

                    lightVibrantSwatchTextView.setOnClickListener {
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

                    val vibrantSwatch = findViewById<TextView>(R.id.vibrantSwatchTextView)
                    if (vibrantSwatch != null) {

                        vibrantSwatch.setBackgroundColor(palette.vibrantSwatch!!.rgb)
                        val intVibColor = palette.vibrantSwatch!!.rgb
                        val hexVibColors = "#" + Integer.toHexString(intVibColor).substring(2)
                        val hexVibColor = "$hexVibColors"
                        val vibrantSwatchTextView =
                            findViewById<TextView>(R.id.vibrantSwatchTextView)
                        vibrantSwatchTextView.text = hexVibColor
//                        vibrantSwatch.setTextColor(palette.vibrantSwatch!!.titleTextColor)

                        val darkVibrantSwatch =
                            findViewById<TextView>(R.id.darkVibrantSwatchTextView)
                        darkVibrantSwatch.setBackgroundColor(palette.darkVibrantSwatch!!.rgb)
                        val intDarkColor = palette.darkVibrantSwatch!!.rgb
                        val hexDarkColors = "#" + Integer.toHexString(intDarkColor).substring(2)
                        val hexDarkColor = "$hexDarkColors"
                        val darkVibrantSwatchTextView =
                            findViewById<TextView>(R.id.darkVibrantSwatchTextView)
                        darkVibrantSwatchTextView.text = hexDarkColor
//                        vibrantSwatch.setTextColor(palette.darkVibrantSwatch!!.titleTextColor)

                        val lightVibrantSwatch =
                            findViewById<TextView>(R.id.lightVibrantSwatchTextView)
                        lightVibrantSwatch.setBackgroundColor(palette.lightVibrantSwatch!!.rgb)
                        val intLightColor = palette.lightVibrantSwatch!!.rgb
                        val hexLightColors = "#" + Integer.toHexString(intLightColor).substring(2)
                        val hexLightColor = "$hexLightColors"
                        val lightVibrantSwatchTextView =
                            findViewById<TextView>(R.id.lightVibrantSwatchTextView)
                        lightVibrantSwatchTextView.text = hexLightColor
//                        lightVibrantSwatch.setTextColor(palette.lightVibrantSwatch!!.titleTextColor)

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

                    darkVibrantSwatchTextView.setOnClickListener {
                        val clr = Color.rgb(
                            palette.vibrantSwatch!!.rgb.red,
                            palette.vibrantSwatch!!.rgb.green,
                            palette.vibrantSwatch!!.rgb.blue
                        )
                        val intent = Intent(applicationContext, DetailActivity::class.java)
                        intent.putExtra("cdc", clr)
                        startActivity(intent)
                    }

                    lightVibrantSwatchTextView.setOnClickListener {
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
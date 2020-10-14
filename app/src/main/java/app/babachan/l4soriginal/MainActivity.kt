package app.babachan.l4soriginal

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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
                        Log.d("jj", palette.vibrantSwatch.toString())
                        Log.d("kk", palette.vibrantSwatch!!.rgb.toString())

                        vibrantSwatch.setTextColor(palette.getVibrantSwatch()!!.getTitleTextColor())
                        val hex = String.format("#", palette.vibrantSwatch)
                        vibrantSwatch.setText(hex)
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
//                        val mutedSwatch = findViewById<TextView>(R.id.muted_swatch)
//                        mutedSwatch.setBackgroundColor(palette.getMutedSwatch()!!.getRgb())
//                        mutedSwatch.setTextColor(palette.getMutedSwatch()!!.getTitleTextColor())
//                        val darkMutedSwatch = findViewById<TextView>(R.id.dark_muted_swatch)
//                        darkMutedSwatch.setBackgroundColor(palette.getDarkMutedSwatch()!!.getRgb())
//                        darkMutedSwatch.setTextColor(
//                            palette.getDarkMutedSwatch()!!.getTitleTextColor()
//                        )
//                        val lightMutedSwatch = findViewById<TextView>(R.id.light_muted_swatch)
//                        lightMutedSwatch.setBackgroundColor(
//                            palette.getLightMutedSwatch()!!.getRgb()
//                        )
//                        lightMutedSwatch.setTextColor(
//                            palette.getLightMutedSwatch()!!.getTitleTextColor()
//                        )
                    }
                }

                vibrantSwatchTextView.setOnClickListener {
                    if (palette != null) {
                        val color = (vibrantSwatchTextView.background as ColorDrawable).color

                        val intent = Intent(applicationContext, DetailActivity::class.java)
//                    intent.putExtra("VIB", vibBackColor)
                        Log.d("gg", color.toString())
                        startActivity(intent)
                    }
                }

                darkVibrantSwatch.setOnClickListener {
                    val intent = Intent(applicationContext, DetailActivity::class.java)
                    startActivity(intent)
                }

                lightVibrantSwatch.setOnClickListener {
                    val intent = Intent(applicationContext, DetailActivity::class.java)
                    startActivity(intent)
                }

            }
        })


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
//                        val mutedSwatch = findViewById<TextView>(R.id.muted_swatch)
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
//                        val lightMutedSwatch = findViewById<TextView>(R.id.light_muted_swatch)
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
                }

                vibrantSwatchTextView.setOnClickListener {
                    val intent = Intent(applicationContext, DetailActivity::class.java)
                    startActivity(intent)
                }
                darkVibrantSwatch.setOnClickListener {
                    val intent = Intent(applicationContext, DetailActivity::class.java)
                    startActivity(intent)
                }

                lightVibrantSwatch.setOnClickListener {
                    val intent = Intent(applicationContext, DetailActivity::class.java)
                    startActivity(intent)
                }

            }
        })
    }
}
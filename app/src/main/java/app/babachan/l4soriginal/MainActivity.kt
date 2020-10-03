package app.babachan.l4soriginal

import android.R.attr
import android.R.attr.bitmap
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import androidx.palette.graphics.Palette.PaletteAsyncListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val readRequestCode: Int = 42

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Palette.generateAsync(bitmap,
            PaletteAsyncListener { palette ->
                if (palette != null) {
                    val vibrantSwatch = palette.vibrantSwatch
                    if (vibrantSwatch != null) {
                        mVibrantContaienr.setBackgroundColor(vibrantSwatch.rgb)
                        mVibrantTitleView.setTextColor(vibrantSwatch.titleTextColor)
                        mVibrantText.setTextColor(vibrantSwatch.bodyTextColor)
                    }
                }
            })

        getImage.setOnClickListener {

            val galleryIntetnt = Intent(Intent.ACTION_OPEN_DOCUMENT)
            galleryIntetnt.addCategory(Intent.CATEGORY_OPENABLE)
            galleryIntetnt.type = "image/*"
            startActivityForResult(galleryIntetnt, readRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, resultData: Intent?) {
        super.onActivityResult(requestCode, resultCode, resultData)

        if (requestCode == readRequestCode && resultCode == Activity.RESULT_OK) {
            resultData?.data?.also { uri ->
                imageView.setImageURI(uri)

            }
        }

//        fun createPaletteSync(bitmap: Bitmap): Palette = Palette.from(bitmap).generate()

        fun createPaletteAsync(bitmap: Bitmap) {

            val vibrant = myPalette.vibrantSwatch
            val titleColor = vibrant?.titltTextColor

            Palette.from(bitmap).generate {


                fun setToolbarColor(bitmap: Bitmap) {
                    val vibrantSwitch = createPaletteSync(bitmap).vibrantSwatch

                    with(findViewById<Toolbar>(R.id.toolbar)) {
                        setBackgroundColor(
                            vibrantSwitch?.rab ?: ContextCompat.getColor(
                                context,
                                R.color.colorPrimary
                            )
                        )
                        setTitleTextColor(
                            vibrantSwitch?.titleTextColor ?: ContextCompat.getColor(
                                context,
                                R.color.colorAccent
                            )
                        )
                    }
                }

            }
        }

    }
}
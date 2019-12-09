package com.example.mvvmsampleapp.util

import android.content.Context
import android.graphics.drawable.PictureDrawable
import android.net.ConnectivityManager
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.StreamEncoder
import com.bumptech.glide.load.resource.file.FileToStreamDecoder
import com.caverock.androidsvg.SVG
import com.example.georgeissac.mvp.R
import com.example.georgeissac.mvp.userinterface.svg.SvgDecoder
import com.example.georgeissac.mvp.userinterface.svg.SvgDrawableTranscoder
import com.example.georgeissac.mvp.userinterface.svg.SvgSoftwareLayerSetter
import java.io.InputStream

class Utilities(var context: Context) {

    fun isNetAvailable(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    fun setImage(url: String?, imageView: ImageView) {
        val requestBuilder = Glide.with(context)
            .using(Glide.buildStreamModelLoader(Uri::class.java, context), InputStream::class.java)
            .from(Uri::class.java)
            .`as`(SVG::class.java)
            .transcode(SvgDrawableTranscoder(), PictureDrawable::class.java)
            .sourceEncoder(StreamEncoder())
            .cacheDecoder(FileToStreamDecoder<SVG>(SvgDecoder()))
            .decoder(SvgDecoder())
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .animate(android.R.anim.fade_in)
            .listener(SvgSoftwareLayerSetter<Uri>())

        val uri = Uri.parse(url)
        requestBuilder
            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
            .load(uri)
            .override(100, 200)
            .into(imageView)

        testSealed(SealedTest.ChildThree(5))
    }

    fun testSealed(sealedTest: SealedTest){
        val int = when(sealedTest){
            is SealedTest.ChildOne -> {
                println("one")
                1
            }
            is SealedTest.ChildTwo -> {
                println("two")
                2
            }
            is SealedTest.ChildTwo.ChildTwoTwo -> {
                println("two")
                22
            }
            is SealedTest.ChildThree -> {
                println("two" + sealedTest.int)
                3
            }
             SealedTest.ObjectFour -> {
                println("two")
                4
            }
        }
    }

    //q1) why no is for object
    //q2) difference between ChildThree(int: Int) and ChildThree(var int: Int)

}
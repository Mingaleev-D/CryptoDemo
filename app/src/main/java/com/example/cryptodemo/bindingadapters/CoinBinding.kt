package com.example.cryptodemo.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.cryptodemo.utils.loadImage

/**
 * @author : Mingaleev D
 * @data : 10/11/2022
 */

class CoinBinding {

   companion object {
      //https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png

      @BindingAdapter("load_image")
      @JvmStatic
      fun loadImage(imageView: ImageView, coinImage: String) {
         val imageUrl = "https://s2.coinmarketcap.com/static/img/coins/64x64/$coinImage.png"
         imageView.loadImage(imageUrl)
      }
   }
}
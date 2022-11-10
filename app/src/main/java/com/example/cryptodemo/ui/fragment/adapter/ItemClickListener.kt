package com.example.cryptodemo.ui.fragment.adapter

import com.example.cryptodemo.model.successfulResponse.Data

/**
 * @author : Mingaleev D
 * @data : 9/11/2022
 */

interface ItemClickListener {
   fun onItemClick(coin: Data)
}
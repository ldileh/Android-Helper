package com.ldileh.androidhelper

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

open class ActivityUtil(val context: Context?) {

    var useAnimation = false
    var animationIn = -1
    var animationOut = -1
    var optionClose = FINISH_CURRENT
    var sendData: Bundle? = null

    companion object{
        const val FINISH_CURRENT = 1
        const val FINISH_ALL = 2
    }

    fun setAnimation(animIn: Int, animOut: Int): ActivityUtil = this.apply {
        useAnimation = true
        animationIn = animIn
        animationOut = animOut
    }

    fun defaultAnimation(): ActivityUtil = this.apply {
        useAnimation = true
        animationIn = -1
        animationOut = -1
    }

    fun closeCurrentPage(): ActivityUtil = this.apply {
        optionClose = FINISH_CURRENT
    }

    fun closeAllPage(): ActivityUtil = this.apply {
        optionClose = FINISH_ALL
    }

    fun sendData(data: Bundle): ActivityUtil = this.apply {
        sendData = data
    }

    fun showPage(classTarget: Class<*>) = context?.let {
        it.startActivity(Intent(it, classTarget))

        if(useAnimation && it is Activity){
            it.apply {
                overridePendingTransition(animationIn, animationOut)

                when(optionClose){
                    FINISH_CURRENT -> finish()
                    FINISH_ALL -> finishAffinity()
                }
            }
        }
    }
}
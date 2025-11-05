package com.glacierpower.tennisapp.core.design_system.util

import android.content.Context
import android.content.res.Resources
import androidx.annotation.StringRes
import timber.log.Timber

internal fun lokaliseKeyFromRes(context: Context, @StringRes resId: Int): String {
    return try {
        val resName = context.resources.getResourceEntryName(resId)
        resName
    } catch (e: Resources.NotFoundException) {
        Timber.tag("LokaliseText").e(e, "Resource not found: $resId")
        "Unknown.Key"
    }
}

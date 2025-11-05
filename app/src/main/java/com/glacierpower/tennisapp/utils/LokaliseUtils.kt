package com.glacierpower.tennisapp.utils

import android.app.LocaleManager
import android.content.Context
import android.os.Build
import com.lokalise.sdk.LokaliseResources
import java.util.Locale

fun LokaliseResources.getStringByResId(context: Context, resId: Int): String {
    val key = context.getString(resId)
    return getString(key).orEmpty()
}

fun getCurrentLocale(context: Context): Locale {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        val localeManager = context.getSystemService(Context.LOCALE_SERVICE) as LocaleManager
        localeManager.applicationLocales[0] ?: Locale.getDefault()
    } else
        context.resources.configuration.locales[0]
}

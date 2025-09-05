package com.glacierpower.tennisapp.core.design_system.params_checker

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import timber.log.Timber

@Composable
internal fun ParamChecker(
    component: (@Composable () -> Unit)?,
    possibleParams: List<TennisAppDesignSystemComponentId>
) {
    possibleParams.forEach { paramId ->
        ParamChecker(
            component = component,
            param = paramId
        )
    }
}

@Composable
internal fun ParamChecker(
    component: (@Composable () -> Unit)?,
    param: TennisAppDesignSystemComponentId
) {
    component ?: return
    Layout(component) { measures, _ ->
        measures.find { measure ->
            measure.layoutId == param
        } ?: {
            Timber.e("DarbDesignSystemException: requireId = $param")
            throw TennisAppDesignSystemException()
        }
        layout(0, 0) { }
    }
}

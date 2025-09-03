package com.glacierpower.tennisapp.core.design_system.params_checker

private const val ERROR_MESSAGE = "Component incorrect Parameter"

class TennisAppDesignSystemException(override val message: String = ERROR_MESSAGE) : Exception()

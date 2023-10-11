package com.ipsmeet.calculator

import com.ipsmeet.calculator.sealedclass.OperationClass

data class StateDataClass(
    val firstNum: String = "",
    val operation: OperationClass? = null,
    val secondNum: String = ""
)

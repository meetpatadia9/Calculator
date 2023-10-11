package com.ipsmeet.calculator.sealedclass

sealed class OperationClass(val operation: String) {
    object Addition: OperationClass("+")
    object Subtract: OperationClass("-")
    object Multiplication: OperationClass("*")
    object Division: OperationClass("/")
    object Modulo: OperationClass("%")
}

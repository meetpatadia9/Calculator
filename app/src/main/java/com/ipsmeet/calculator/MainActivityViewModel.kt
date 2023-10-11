package com.ipsmeet.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ipsmeet.calculator.sealedclass.ActionClass
import com.ipsmeet.calculator.sealedclass.OperationClass

class MainActivityViewModel : ViewModel() {

    var state by mutableStateOf(StateDataClass())
        private set // we can't change state from the outside but we can access and read it

    fun onAction(action: ActionClass) {
        when (action) {
            is ActionClass.Digit -> enterNum(action.num)
            is ActionClass.Decimal -> enterDecimal()
            is ActionClass.Operation -> enterOperation(action.operation)
            is ActionClass.Erase -> eraseDigit()
            is ActionClass.ClearAll -> state = StateDataClass()
            is ActionClass.Calculate -> performCalculation()
        }
    }

    private fun enterNum(num: Int) {
        if (state.operation == null) {
            if (state.firstNum.length >= 5) {
                return
            }
            state = state.copy(
                firstNum = state.firstNum + num
            )
            return
        }

        if (state.secondNum.length >= 5) {
            return
        }
        state = state.copy(
            secondNum = state.secondNum + num
        )
    }

    private fun eraseDigit() {
        when {
            state.secondNum.isNotBlank() -> state = state.copy(
                secondNum = state.secondNum.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )

            state.firstNum.isNotBlank() -> state = state.copy(
                firstNum = state.firstNum.dropLast(1)
            )
        }
    }

    private fun enterOperation(operation: OperationClass) {
        if (state.firstNum.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if (state.operation == null
            && !state.firstNum.contains(".")
            && state.firstNum.isNotBlank()
        ) {
            state = state.copy(
                firstNum = state.firstNum + "."
            )
            return
        }

        if (!state.secondNum.contains(".")
            && state.secondNum.isNotBlank()
        ) {
            state = state.copy(
                secondNum = state.secondNum + "."
            )
        }
    }

    private fun performCalculation() {
        val num1 = state.firstNum.toDoubleOrNull()
        val num2 = state.secondNum.toDoubleOrNull()
        if (num1 != null && num2 != null) {
            val ans = when (state.operation) {
                is OperationClass.Addition -> num1 + num2
                is OperationClass.Subtract -> num1 - num2
                is OperationClass.Multiplication -> num1 * num2
                is OperationClass.Division -> num1 / num2
                is OperationClass.Modulo -> num1 % num2
                null -> return
            }

            val result: String = if ((ans * 10.0).toInt() % 10 == 0) {
                ans.toInt().toString().take(12)
            } else {
                ans.toString().take(12)
            }

            state = state.copy(
                firstNum = result,
                secondNum = "",
                operation = null
            )
        }
    }

}
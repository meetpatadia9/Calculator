package com.ipsmeet.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ipsmeet.calculator.ui.theme.CalculatorTheme
import com.ipsmeet.calculator.ui.theme.MainBG

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                val viewModel = viewModel<MainActivityViewModel>()
                val state = viewModel.state
                val gapBetweenBtn = 10.dp
                val displayTxt =state.firstNum + (state.operation?.operation ?: "") + state.secondNum

                Calculator(
                    gapBetweenBtn = gapBetweenBtn,
                    onAction = viewModel::onAction,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            MainBG
                        )
                        .padding(10.dp),
                    displayTxt = displayTxt
                )
            }
        }
    }
}
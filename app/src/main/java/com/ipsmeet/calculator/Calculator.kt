package com.ipsmeet.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ipsmeet.calculator.sealedclass.ActionClass
import com.ipsmeet.calculator.sealedclass.OperationClass
import com.ipsmeet.calculator.ui.theme.OrangeBTN
import com.ipsmeet.calculator.ui.theme.SpecialBTN

@Composable
fun Calculator(
    state: StateDataClass,
    gapBetweenBtn: Dp,
    modifier: Modifier = Modifier,
    onAction: (ActionClass) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(gapBetweenBtn)
        ) {
            Text(
                text = state.firstNum + (state.operation?.operation ?: "") + state.secondNum,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 72.sp,
                color = Color.Black
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(gapBetweenBtn)
            ) {
                ButtonUI(str = "AC",
                    modifier = Modifier
                        .background(SpecialBTN)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.ClearAll)
                    })
                ButtonUI(str = "%",
                    modifier = Modifier
                        .background(SpecialBTN)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.Operation(OperationClass.Modulo))
                    })
                ButtonUI(str = "C",
                    modifier = Modifier
                        .background(SpecialBTN)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.Erase)
                    })
                ButtonUI(str = "/",
                    modifier = Modifier
                        .background(SpecialBTN)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.Operation(OperationClass.Division))
                    })
            }   // row - 1
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(gapBetweenBtn)
            ) {
                ButtonUI(str = "7",
                    modifier = Modifier
                        .background(Color.White)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.Digit(7))
                    })
                ButtonUI(str = "8",
                    modifier = Modifier
                        .background(Color.White)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.Digit(8))
                    })
                ButtonUI(str = "9",
                    modifier = Modifier
                        .background(Color.White)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.Digit(9))
                    })
                ButtonUI(str = "*",
                    modifier = Modifier
                        .background(SpecialBTN)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.Operation(OperationClass.Multiplication))
                    })
            }   // row - 2
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(gapBetweenBtn)
            ) {
                ButtonUI(str = "4",
                    modifier = Modifier
                        .background(Color.White)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.Digit(4))
                    })
                ButtonUI(str = "5",
                    modifier = Modifier
                        .background(Color.White)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.Digit(5))
                    })
                ButtonUI(str = "6",
                    modifier = Modifier
                        .background(Color.White)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.Digit(6))
                    })
                ButtonUI(str = "-",
                    modifier = Modifier
                        .background(SpecialBTN)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.Operation(OperationClass.Subtract))
                    })
            }   // row - 3
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(gapBetweenBtn)
            ) {
                ButtonUI(str = "1",
                    modifier = Modifier
                        .background(Color.White)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.Digit(1))
                    })
                ButtonUI(str = "2",
                    modifier = Modifier
                        .background(Color.White)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.Digit(2))
                    })
                ButtonUI(str = "3",
                    modifier = Modifier
                        .background(Color.White)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.Digit(3))
                    })
                ButtonUI(str = "+",
                    modifier = Modifier
                        .background(SpecialBTN)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.Operation(OperationClass.Addition))
                    })
            }   // row - 4
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(gapBetweenBtn)
            ) {
                ButtonUI(str = "00",
                    modifier = Modifier
                        .background(Color.White)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.Digit(0))
                    })
                ButtonUI(str = "0",
                    modifier = Modifier
                        .background(Color.White)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.Digit(0))
                    })
                ButtonUI(str = ".",
                    modifier = Modifier
                        .background(Color.White)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.Decimal)
                    })
                ButtonUI(str = "=",
                    modifier = Modifier
                        .background(OrangeBTN)
                        .weight(1f),
                    onClick = {
                        onAction(ActionClass.Calculate)
                    })
            }   // row - 5
        }   // column
    }   // box
}
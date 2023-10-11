package com.ipsmeet.calculator.sealedclass

/**
 * A sealed class is a special type of class that can only be subclassed within the same file as the sealed class.
 * This makes it easy to define a fixed set of possible states, as all of the subclasses must be declared in the
 * same file as the sealed class. Sealed classes are often used to represent a finite set of states, such as in
 * a state machine.
 *
 * for more info refer link - https://cazimirroman.medium.com/sealed-classes-vs-data-classes-669446e8ed3b
* */

sealed class ActionClass {
    data class Digit(val num: Int): ActionClass()
    data class Operation(val operation: OperationClass): ActionClass()
    object Erase: ActionClass()
    object ClearAll: ActionClass()
    object Decimal: ActionClass()
    object Calculate: ActionClass()
}

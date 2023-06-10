package com.anushka.uilayerdemo1

sealed class UIEvent{
    data class ShowMessage(val message:String):UIEvent()
}

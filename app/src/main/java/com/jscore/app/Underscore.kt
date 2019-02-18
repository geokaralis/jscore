package com.jscore.app

import jscore.android.JSObject

class Underscore(private val src: String): JSObject() {

    /**
     * Checks if a value is present in a list
     *
     * @param list   ArrayList holding integer values
     * @param index  Value to check in the list
     *
     * @return       true if the value is present in the list, otherwise false
     */
    fun contains(list: ArrayList<Int>, index: Int): Boolean {
        return JSObject().bind(src).function("contains", arrayListOf(list, index))
    }
}
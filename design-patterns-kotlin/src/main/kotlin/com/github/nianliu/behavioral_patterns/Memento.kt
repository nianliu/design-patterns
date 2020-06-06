package com.github.nianliu.behavioral_patterns

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

data class TextBoxState(val text: String)

class TextBox {
    private val builder = StringBuilder()

    fun addText(text: String) {
        builder.append(text)
    }

    fun getText() = builder.toString()

    fun save(): TextBoxState = TextBoxState(builder.toString())

    fun restore(state: TextBoxState) {
        builder.setLength(0)
        builder.append(state.text)
    }
}

class TextEditor {
    val textBox = TextBox()
    private var savedState: TextBoxState = TextBoxState("")

    fun write(text: String) {
        textBox.addText(text)
    }

    fun hitSave() {
        savedState = textBox.save()
    }

    fun hitRestore() {
        textBox.restore(savedState)
    }
}

class Memento {
    @Test
    fun demo() {
        val editor = TextEditor()
        editor.write("hello")
        editor.hitSave()

        editor.write(" world")
        assertEquals("hello world", editor.textBox.getText())

        editor.hitRestore()
        assertEquals("hello", editor.textBox.getText())
    }
}

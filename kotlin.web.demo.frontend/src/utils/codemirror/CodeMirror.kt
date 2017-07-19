/*
 * Copyright 2000-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package utils.codemirror

import org.w3c.dom.HTMLCollection
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLTextAreaElement
import kotlin.js.Json

@JsModule("codemirror")
external class CodeMirror(element: HTMLElement, parameters: Json) {
    companion object {
        val hint: dynamic
        val commands: dynamic
        fun runMode(text: String, mode: String, outputElement: HTMLElement)
        fun fromTextArea(textArea: HTMLTextAreaElement, json: Json): CodeMirror
        fun registerHelper(type: String, name: String, value: Any)
        fun on(obj: Any, action: String, callback: () -> Unit)
        fun colorize(elements: HTMLCollection)
    }

    class Doc(text: String, mode: String = definedExternally, firstLineNumber: Int = definedExternally) {
        fun markText(start: Position, end: Position, json: Json): Any
        fun getEditor(): CodeMirror
        fun addLineWidget(lineNo: Int, help: HTMLElement?, options: Json): LineWidget
        fun setSelection(anchor: Position, head: Position)
    }

    class LineWidget {
        val node: HTMLElement
        val line: Line
        fun clear()
        fun changed()
    }

    class Line {
        val widgets: Array<LineWidget>?
        fun lineNo(): Int
    }

    class TextMarker {
        val className: String?
        fun find(): Range
        fun clear()
    }

    fun getCursor(): Position
    fun getDoc(): Doc
    fun getTokenAt(pos: Position): Token
    fun replaceRange(replacement: String, from: Position, to: Position = definedExternally, origin: String? = definedExternally)
    fun execCommand(s: String)
    fun on(action: String, callback: (utils.codemirror.CodeMirror) -> Unit)
    fun <T> on(action: String, callback: (utils.codemirror.CodeMirror, additionalInfo: T) -> Unit)
    fun getValue(): String
    fun setOption(name: String, value: Any)
    fun refresh()
    fun setCursor(lineNo: Int, charNo: Int)
    fun focus()
    fun setValue(text: String)
    fun setHistory(history: dynamic)
    fun getHistory(): dynamic
    fun clearHistory()
    fun cursorCoords(): dynamic
    fun clearGutter(gutter: String)
    fun markText(start: Position, end: Position, json: Json): Any
    fun setGutterMarker(line: Int, gutter: String, element: HTMLElement): Unit
    fun lineInfo(line: Int): dynamic
    fun lineCount(): Int
    fun indentLine(lineNo: Int)
    fun operation(function: () -> Unit)
    fun swapDoc(document: Doc)
    fun openDialog(template: HTMLElement, callback: () -> Unit, options: dynamic): () -> Unit
    fun addLineWidget(lineNo: Int, help: HTMLElement?, options: Json): Unit
    fun setSelection(anchor: Position, head: Position): Unit
    fun getLineHandle(i: Int): Line
    fun coordsChar(cursorCoordinates: Coordinates): Position
    fun findMarksAt(position: Position): Array<TextMarker>
    fun listSelections(): Array<Selection>
}

class Position(val line: Int, val ch: Int)

class Range(val from: Position, val to: Position)

class Selection(val anchor: Position, val head: Position)

class Coordinates(val left: Double, val top: Double)

external interface Token {
    val start: Int
    val end: Int
    val string: String
    val type: String?
    val state: dynamic
}

class Hint(val from: Position, val to: Position, var list: Array<CompletionView>)


external interface CompletionView {
    val text: String
    val displayText: String
    fun render(element: HTMLElement, self: dynamic, data: dynamic);
    fun hint(cm: CodeMirror, self: dynamic, data: dynamic)
}
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

package utils.jquery

import jquery.MouseClickEvent
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event
import org.w3c.dom.events.KeyboardEvent
import kotlin.js.Json


@JsName("$")
external class JQuery {
    companion object {
        fun ajax(parameters: Json): Promise
        fun parseHTML(html: String): Array<HTMLElement>?
    }

    class Promise {
        fun then(callback: Function<Unit>)
        fun done(callback: Function<Unit>)
        fun fail()
        fun always()
        fun pipe()
        fun progress()
        fun state()
        fun promise()
    }

    fun html(s: String)
    fun removeClass(className: String)
    fun addClass(className: String)
    fun height(): Number
    fun height(value: Int)
    fun width(): Number
    fun width(value: Int)
    fun hasClass(className: String): Boolean
    fun text(text: String)
    fun click()
    fun click(handler: (MouseClickEvent) -> Unit): JQuery
    fun slideUp()
    fun parent(): JQuery
    fun attr(name: String, value: String)
    fun append(any: String)

    fun slideDown()
    fun children(selector: String = definedExternally): JQuery
    fun outerHeight(includeMargin: Boolean = definedExternally): Int
    fun outerWidth(includeMargin: Boolean = definedExternally): Int
    fun toArray(): Array<HTMLElement>
    @JsName("is")
    fun isCheck(s: String): Boolean

    fun hide()
    fun show()

    fun unbind(s: String)
    fun on(s: String, onClose: (Event) -> Unit)
    fun css(key: String, value: dynamic)
    @JsName("val")
    fun value(): String
    @JsName("val")
    fun value(s: String)

    fun circleProgress(options: Json)

    fun on(action: String, selector: String, callback: (event: Event) -> Unit)

    fun keydown(callback: (KeyboardEvent) -> Unit)

    fun find(selector: String): JQuery

    fun trigger(action: String)

    fun focus()

    operator fun get(index: Int): Element


    fun dialog(command: String) : JQuery

    fun dialog(parameters: Json) : JQuery

    fun dialog(mode: String, param: String, value: Any?)

    fun toggle()

    fun resizable(parameters: Json)

    fun resizable(mode : String, param : String, value : Any?)

    fun selectmenu(parameters: Json)

    fun selectmenu(command: String)

    fun tabs()

    fun button(command: String): JQuery

    fun button(parameters: Json): JQuery

    fun accordion(params: Json): JQuery

    fun accordion(command: String): JQuery

    fun accordion(command: String, name: String, value: Any): JQuery

    fun button(mode : String, param : String, value : Any?) : JQuery

    fun tabs(mode : String, param : String, value : Any?) : JQuery
}

@JsName("$")
external fun jq(document: Document): JQuery

@JsName("$")
external fun jq(selector: String): JQuery

@JsName("$")
external fun jq(element: Element): JQuery

@JsName("$")
external fun jq(jq: JQuery): JQuery

import kotlinx.browser.document
import kotlinx.css.minHeight
import kotlinx.css.vh
import kotlinx.html.dom.append
import kotlinx.html.js.div
import moe.nea89.website.KConsole
import moe.nea89.website.Styles
import moe.nea89.website.defaultLsCommand
import moe.nea89.website.fileSystem
import styled.injectGlobal


val defaultFileSystem = fileSystem {
    "etc" {
        "passwd" text "hunter2"
    }
    "home/nea" {
        "todo" text """
                | - git gud
                | - finish this website
                | - convince the general public that comic sans is a viable font
            """.trimMargin()
    }
    "flag" text "CTF{12345abcdefghijklmonp3.1.4.1.5.9.2.8}"
}

fun main() {
    injectGlobal {
        ".${Styles.consoleClass}" {
            minHeight = 100.vh
        }
    }

    val root = document.body!!.append.div()
    val console = KConsole.createFor(root, fileSystem = defaultFileSystem)
    console.addLine("Starting stfff")
    console.PS1 = { "echowebsite > " }
    console.rerender()
    console.registerCommand(defaultLsCommand("ls"))

}
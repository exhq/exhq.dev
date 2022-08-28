import kotlinx.browser.document
import kotlinx.css.*
import kotlinx.html.dom.append
import kotlinx.html.js.div
import moe.nea89.website.*
import styled.injectGlobal
import kotlin.time.Duration.Companion.milliseconds


val defaultFileSystem = fileSystem {
    "etc" {
        "passwd" text "hunter2"
    }
    "home/exhq" {
        "todo" text """
                | - git gud
                | - finish this website
                | - convince the general public that comic sans is a viable font
            """.trimMargin()
    }
    "flag" text "CTF{12345abcdefghijklmonp3.1.4.1.5.9.2.8}"
}

fun main() {

    val root = document.body!!.append.div()
    val console = KConsole.createFor(root, fileSystem = defaultFileSystem)
    injectGlobal {
        ".${Styles.consoleClass}" {
            minHeight = 100.vh
            backgroundColor = Color("#282a39C6")
        }
        body {
            backgroundImage = Image("url(weebshit1.jpg)")
            backgroundSize = "cover"
        }

    }
    console.addLine("Starting stfff")
    console.PS1 = { "${console.fileAccessor!!.currentDir.joinToString("/", "/")} > " }
    console.fileAccessor!!.cd("/home/exhq")
    console.rerender()
    console.registerCommand(defaultLsCommand("ls", delayBetweenLines = 0.milliseconds))
    console.registerCommand(defaultCdCommand("cd"))
    console.registerCommand(defaultCatCommand("cat"))
    console.registerCommand(defaultCwdCommand("cwd", "pwd"))
    console.registerCommand(command("help", "?"){
        console.addMultilineText("""
            ls - lists stuff in current directory
            cd - move to another directory
            cat - open files
            pwd - shows current directory
        """.trimIndent())

    })
    console.registerCommand(command("blahaj", "shark"){
        console.addMultilineText("""
                                          ,(((/                                 
                                        /(((((                                  
                                       ((((#((                              (// 
                                      (((((((.                           *(((/  
                                    /(######/                          *((((/   
                                 *//%#####((/                         ((#((/    
               ,*/********/////////////////(//*           (%*      ,((##((      
      ,*/((///(//////////((/(///////(/////(////*,(*#((/(/((//////###(###(/(     
   /(((((((//((///((////((((((/(((((((((((((((((/(((##((#%(##(/((///*(&#(##/    
  /#((%(#(((((//#((((((((((((((((((((((((#(((((((((((/##(((((//((//*    ####(/  
   (((###(###(#(#####(###############((#((((((((/((//(((#/(/////            ,,  
     ,(###%####%&%#############(#(#(####(((((((/(((/////*//,                    
         . .....*#(#######(((###(#(##(##(((/(/(/////,                           
          .. ....,..........,..*#%#######/(                                     
               ..  .............,*%%%%#%((((/                                   
                       **,,,****//*(##((###(#(((                                
                                        &#(#/#((((((((#                         
        """.trimIndent())
    })
    console.registerCommand(command("sudo"){
        var str = ""
       for (e in args){
           str += "$e "
       }
       if(str == "rm -rf /* " || str == "rm -rf / "){
           console.addLine("haha funny xd im laughing so hard rn lmfao xddddddddddddd HAHAHAHAHAHAH")
       }
        else{
            console.addLine("bro you don have the password smh")
       }
    })

}
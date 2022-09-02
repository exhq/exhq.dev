import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.css.*
import kotlinx.html.dom.append
import kotlinx.html.js.div
import moe.nea89.website.*
import styled.injectGlobal
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds

var isnickrude = true
val defaultFileSystem = fileSystem {
    "run"{
        "question" text "what is this folder anyways? is it like stuff that runs before everything?"
    }
    "tmp"{
        "tentacle-hentai" image "https://cdn.discordapp.com/attachments/832652653292027904/1014832179911610408/Screenshot_20220423_113521.png"
    }
    "boot"{
        "grub"{
            "bruh" text " mf you expect me to recreate the entire filesystem? go fuck yourself"
        }
    }
    "home"{
        "exhq"{
            "gamering" download "https://cdn.discordapp.com/attachments/985989849813237810/1003346125186674859/2022-07-31-notimezoneforyouraid.mp4"
        }
        "nea"{
            "note" text "lmfao shes gone"
        }
    }
    /*  "home/exhq" {
       "etc" {
            "passwd" text "hunter2"
        }
        "todo" text """
                | - git gud
                | - finish this website
                | - convince the general public that comic sans is a viable font
            """.trimMargin()
    }
    "flag" text "CTF{12345abcdefghijklmonp3.1.4.1.5.9.2.8}"*/
}

val funny = arrayOf(
    "398964",
    "244327",
    "265725",
    "260629",
    "407384",
    "356093",
    "140870",
    "359126",
)
fun redirect(arg: String){
    if(arg.matches("(https://|http://).*")){
        window.location.href = arg
    }
    else{
        window.location.href = "https://$arg"
    }
}
fun isNumericToX(toCheck: String): Boolean {
    return toCheck.toDoubleOrNull() != null
}
fun main() {
    var startupmsg = "type help to get a list of commands"
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
    console.PS1 = { "${console.fileAccessor!!.currentDir.joinToString("/", "/")} > " }
    if (window.location.hash == "#mobile" || (window.location.hash != "#desktop" && js("'ontouchstart' in document.documentElement") as Boolean)) {
        console.openMobileKeyboardOnTap()
        startupmsg = "nea added phone support, kindaaa. phone is shit anyways \ntype help for a list of commands"
    }
    console.addMultilineText(startupmsg)
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
            
             there are also a lot of hidden commands ;)
        """.trimIndent())

    })
    console.registerCommand(command("blahaj", "shark"){
        if (isnickrude){
            console.addLine("nick was rude ;-;")
        }
        else{
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
        }

    })
    console.registerCommand(command("sudo"){
        val funny = console.fileAccessor!!.currentDir.joinToString("/", "/")
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
    console.registerCommand(command("vscode", "vsc", "code"){
        console.addLine("ew microsoft")
        redirect("https://www.youtube.com/watch?v=lpiB2wMc49g")
    })
    console.registerCommand(command("testredirect"){
    redirect(args[0])
    })
    console.registerCommand(command("sauce"){
        console.addLine(args[0])
        if (isNumericToX(args[0])){
            console.addLine("redirecting you to funny")
            redirect("https://nhentai.net/g/${args[0]}")        }
        else{
            console.addLine("here bro i got some good shit")
            redirect(funny[Random.nextInt(funny.size)])
        }


    })

}
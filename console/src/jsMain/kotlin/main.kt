import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.css.*
import kotlinx.html.dom.append
import kotlinx.html.js.div
import kotlinx.html.dom.create
import kotlinx.html.js.a
import kotlinx.html.img
import kotlinx.html.js.p
import moe.nea89.website.*
import styled.injectGlobal
import kotlinx.html.js.onLoadFunction


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
            "kill" image "https://cdn.discordapp.com/attachments/917977729322872853/1015922996126425108/ummkrplmos861.jpg"
            "gamering" download "https://cdn.discordapp.com/attachments/985989849813237810/1003346125186674859/2022-07-31-notimezoneforyouraid.mp4"
        }
        "nea"{
            "note" text "lmfao shes gone"
        }
    }
}
fun redirect(arg: String){
    if("(https://|http://).*".toRegex().matches(arg)){
        window.location.href = arg
    }
    else{
        window.location.href = "https://$arg"
    }
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
            backgroundAttachment = BackgroundAttachment.fixed
        }
        a{
            color = Color("#AEC6CF")
        }


    }
    console.PS1 = { "${console.fileAccessor!!.currentDir.joinToString("/", "/")} > " }
    if (window.location.hash == "#mobile" || (window.location.hash != "#desktop" && js("'ontouchstart' in document.documentElement") as Boolean)) {
        console.openMobileKeyboardOnTap()
        startupmsg = "nea added phone support, kindaaa. phone is shit anyways\n$startupmsg"

    }
    console.addMultilineText(startupmsg)
    console.fileAccessor!!.cd("/home/exhq")
    console.rerender()
    console.registerCommand(command("ls"){
        val fa = requireFileAccessor()
        val path = when(args.size){
            0 -> "."
            1 -> args[0]
            else -> {
                console.addLine("Usage: ls [directory or file]")
                return@command
            }
        }
        val file = fa.resolve(path)
        if (file == null){
            console.addLine("ls : Could not find file or directory")
            return@command
        }
        when(file){
            is KFile.Directory ->{
                val longestName = file.files.keys.maxOf { it.length }
                file.files.forEach { (name, file) ->
                    console.addLine(
                        name + " ".repeat(longestName + 1 - name.length) + "(${file.fileType})"
                    )
                    console.rerender()
                }
            }

            else -> console.addLine("ls: is a ${file.fileType}")
        }
    })
    console.registerCommand(defaultCdCommand("cd"))
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
    console.registerCommand(command("blahaj", "shark")
{
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

    console.registerCommand(command("cat"){
        if (args[0] =="*"){
            console.addLine("everything")
            return@command
        }
        val fa = requireFileAccessor()
        val path = when (args.size){
            1 -> args[0]
            else -> {
                console.addLine("usage: cat [text file]")
                return@command
            }
        }
        val file = fa.resolve(path)
        if (file == null){
            console.addLine("cat: could not find file")
        }

        when (file) {
            is KFile.Directory -> console.addLine("cat: Is a directory")
            is KFile.Text -> console.addMultilineText(file.text)
            is KFile.Image -> console.addLine("cat: wrong file type")
            is KFile.Download -> console.addLine("cat: wrong file type")
            else -> {console.addLine("lmao wtf did you do this is an error, show it to echo or something")}
        }

    })

    console.registerCommand(command("wget"){
        val fa = requireFileAccessor()
        val path = when (args.size){
            1 -> args[0]
            else -> {
                console.addLine("usage: wget [download file]")
                return@command
            }
        }
        val file = fa.resolve(path)
        if (file == null){
            console.addLine("wget: could not find file")
        }

        when (file) {
            is KFile.Directory -> console.addLine("wget: Is a directory")
            is KFile.Text -> console.addLine("wget: wrong file type")
            is KFile.Image -> console.addLine("wget: wrong file type")
            is KFile.Download -> {
                val link = document.create.a(file.url)
                link.download = file.name.last()
                document.body!!.append(link)
                link.click()
                link.remove()
                console.addLine("Download started")
            }
            else -> {console.addLine("lmao wtf did you do this is an error, show it to echo or something")}
        }

    })
    console.registerCommand(command("view", "show"){
        val fa = requireFileAccessor()
        val path = when (args.size){
            1 -> args[0]
            else -> {
                console.addLine("usage: view [image]")
                return@command
            }
        }
        val file = fa.resolve(path)
        if (file == null){
            console.addLine("view: could not find file")
        }

        when (file) {
            is KFile.Directory -> console.addLine("view: Is a directory")
            is KFile.Text -> console.addLine("view: wrong file type")
            is KFile.Image ->  console.addLine(document.create.p {
                img(src = file.url) {
                    this.onLoadFunction = { console.scrollDown() }
                }
            })
            is KFile.Download -> console.addLine("view: wrong file type")
            else -> {console.addLine("lmao wtf did you do this is an error, show it to echo or something")}
        }

    })
    console.registerCommand(command("sudo"){
        //testing
        //val funny = console.fileAccessor!!.currentDir.joinToString("/", "/")
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
        redirect("https://www.poketube.fun/watch?v=lpiB2wMc49g")
    })
    console.registerCommand(command("testredirect"){
    redirect(args[0])
    })
    console.registerCommand(command("clear"){
        console.addLine("im too lazy to implement it correctly")
        window.location.reload()
    })
    console.registerCommand(command("poketube"){
        if (args.isEmpty()){
            console.addLine("turns your nasty youtube link into a good untracked poketube link :) \nusage: poketube <youtube link>")
        }
        else{
            if("(https://|http://)?((www\\.)?youtube.com/watch\\?)v=[a-zA-Z1-9]+.+".toRegex().matches(args[0])){
                val arg = args[0]
                val funny = "https://poketube.fun/watch?"+args[0].subSequence(arg.indexOf("watch?")+6,arg.length)
                console.addLine(document.create.a(funny) { this.text("https://poketube.fun/watch?"+args[0].subSequence(arg.indexOf("watch?")+6,arg.length)) })

            }
        }
    })

}
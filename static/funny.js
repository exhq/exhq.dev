bool = false
var audio 
if (new Date().getMonth() === 9){
    console.log("boo")
    audio = new Audio('boo.mp3')
} else {
    audio = new Audio('for-maeve.mp3')
}
function no() {
    bool = !bool
    if(bool){
        audio.play()
    } else {
        audio.pause()
    }
  }

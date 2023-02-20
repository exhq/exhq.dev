function moveImage() {
    var img = document.getElementById("poofed");
    var imgWidth = img.offsetWidth;
    var imgHeight = img.offsetHeight;
    var containerWidth = window.innerWidth - imgWidth - 400;
    var containerHeight = window.innerHeight - imgHeight - 400;
    var randomX = Math.floor(Math.random() * containerWidth);
    var randomY = Math.floor(Math.random() * containerHeight);
    
    if (randomX < 0) {
      randomX = 0;
    } else if (randomX > containerWidth) {
      randomX = containerWidth;
    }
    
    if (randomY < 0) {
      randomY = 0;
    } else if (randomY > containerHeight) {
      randomY = containerHeight;
    }
    
    
    img.style.left = randomX + "px";
    img.style.top = randomY + "px";
  }
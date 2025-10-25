let isTurn = false;
let sound = document.getElementById("sound");
let icon = document.getElementById("icon");
let music = document.getElementById("Music");
window.addEventListener("load", () => {
    if (music) {
        music.muted = false;
        music.volume=0.5;
        music.play()
    }
});
if (sound) {
    sound.onclick = function() {
        isTurn = !isTurn;
        if (isTurn) {
            music.muted = true;
            icon.classList.remove("fa-volume-up");
            icon.classList.add("fa-volume-mute");
        } else {
            music.muted = false;
            music.play();
            icon.classList.remove("fa-volume-mute");
            icon.classList.add("fa-volume-up");
        }
    }
}

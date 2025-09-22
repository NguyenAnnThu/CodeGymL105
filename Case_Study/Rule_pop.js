let modal = document.getElementById("rule_pop");
let btn = document.getElementById("rule");
let close = document.getElementById("close");
let play = document.getElementById("play");
if (btn) {
    btn.onclick = function() {
        modal.style.display = "block";
    }
}
if (close) {
    close.onclick = function() {
        modal.style.display = "none";
    }
}
if (play) {
    play.onclick = function() {
        window.location.href = "Play_Card.html";
    }
}

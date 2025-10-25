let totalTime = 40;
let timerDisplay = document.getElementById("timer");
let musicout=document.getElementById("timeout");
let musicOutPlayed = false;
function updateTimer(seconds) {
    let min = Math.floor(seconds / 60);
    let sec = seconds % 60;
    timerDisplay.textContent = `${min.toString().padStart(2,'0')}:${sec.toString().padStart(2,'0')}`;
}
updateTimer(totalTime);

let countdown = setInterval(() => {

    if(totalTime <= 0){
        musicout.pause();
        clearInterval(countdown);
        if(score < 8){
            alert("Hết thời gian! Bạn đã thua!");
            location.reload();
        }
        return;
    }

    updateTimer(totalTime);

    if(totalTime === 5 && !musicOutPlayed){
        musicout.play();
        musicOutPlayed = true;
        music.pause()

    }
    totalTime--;
}, 1000);

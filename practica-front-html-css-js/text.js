let timeRef = Date.now();
let timeAcum = 0;
let chronon = false;

var sound = new Audio();
sound.src = "sonido3.mp3";


function startChronon() {;
    chronon = true;
    setTimeout(() => {
        sound.play();
    }, 1000);

    sound.loop = true;
    console.log("Inicio de cronometro");
}

function pauseChronon() {
    chronon = false;
    sound.pause();
    console.log("Pausa de cronometro");
}

function stopChronon() {

    sound.pause();
    chronon = false;
    timeRef = 0;
    timeAcum = 0;

}

function resetChronon() {
    timeAcum = 0;
}

setInterval(() => {
    let time = document.getElementById("tiempo")
    if (chronon) {
        timeAcum += Date.now() - timeRef;
    }
    timeRef = Date.now();
    time.innerHTML = format(timeAcum)
}, 1000 / 60);

// obtenemos el tiempo en milisegundos y formateamos para que sea legible
function format(ms) {
    let MS = ms % 1000;
    let St = Math.floor(((ms - MS) / 1000))
    let seconds = St % 60;
    let minutes = Math.floor((St / 60) % 60);
    let hours = Math.floor(St / 60 / 60);

    Number.prototype.ceros = function(n) {
        return (this + "").padStart(n, 0);
    }

    return `${hours.ceros(2)}:${minutes.ceros(2)}:${seconds.ceros(2)}:${MS.ceros(3)}`;

}
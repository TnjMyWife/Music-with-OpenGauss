
var albumBottom = document.getElementById('albumBottom');
var briefBottom = document.getElementById('briefBottom');
var songBottom = document.getElementById('songBottom');

var albumContent =document.getElementById("albumContent");
var briefContent =document.getElementById("briefContent");
var songContent = document.getElementById('songContent');

briefBottom.addEventListener('click', function (event) {
    albumContent.style.display = "none";
    briefContent.style.display = "flex";
    songContent.style.display = "none";
})

albumBottom.addEventListener('click', function (){
    albumContent.style.display = "flex";
    briefContent.style.display = "none";
    songContent.style.display = "none";
})

songBottom.addEventListener('click', function (event) {
    albumContent.style.display = "none";
    briefContent.style.display = "none";
    songContent.style.display = "flex";
})


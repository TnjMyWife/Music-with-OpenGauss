/* 获取主题背景 */
var body = document.getElementById('body');
/* 获取音频播放器对象 */
var audio = document.getElementById('audioTag');
/* 进度条 */
var progress = document.getElementById('progress');
/* 总进度条 */
var progressTotal = document.getElementById('progress-total');
/* 播放模式按钮 */
var mode = document.getElementById('playMode');
var modeImg = document.getElementById('playModeImg');
/* 上一首按钮 */
var skipForward = document.getElementById('skipForward');
/* 暂停按钮 */
var pause = document.getElementById('playPause');
var playImg = document.getElementById('playImg');
/* 下一首按钮 */
var skipBackward = document.getElementById('skipBackward');
/* 音量按钮 */
var volume = document.getElementById('volume');
/* 音量调节滑块 */
var volumeTogger = document.getElementById('volumn-togger');
var volumeImg = document.getElementById('volume-Img')
/* 列表 */
var list = document.getElementById('list');
/* 倍速 */
var speed = document.getElementById('speed');
/* MV */
var MV = document.getElementById('MV');
var mvArea = document.getElementById('mv-area');
// 左侧关闭面板
var closeList = document.getElementById('no-list-area');
// 音乐列表面板
var musicList = document.getElementById('list-area');

/* 暂停/播放切换 */
pause.onclick = function (e) {
    if (audio.paused) {
        audio.play();
        playImg.src = '/img/继续播放.png';
    } else {
        audio.pause();
        playImg.src = '/img/暂停.png';
    }
}

/* 监听音频播放时间，更新进度条 */
function updateProgress() {
    progress.style.width = audio.currentTime / audio.duration * 100 + "%";
}
audio.addEventListener('timeupdate', updateProgress);

/* 指定进度播放 */
var isDragging = false;
    /* 按下后更新进度 */
progressTotal.addEventListener('mousedown', function (event) {
    /* 获取进度条的宽度(px) */
    var pgsWidth = parseFloat(window.getComputedStyle(progressTotal, null).width.replace('px', ''));

    /* 鼠标移动时更新进度 */
    function handleMouseMove(event) {
        if (isDragging) {
            var rate = event.offsetX / pgsWidth;
            audio.currentTime = audio.duration * rate;
            updateProgress(audio);
        }
    }

    /* 鼠标释放时停止拖动，并播放音频 */
    function handleMouseUp() {
        isDragging = false;
        document.removeEventListener('mousemove', handleMouseMove);
        document.removeEventListener('mouseup', handleMouseUp);
        audio.play();
        playImg.src = '/img/继续播放.png';
    }

    /* 监听 */
    document.addEventListener('mousemove', handleMouseMove);
    document.addEventListener('mouseup', handleMouseUp);

    /* 初始点击时开始拖动，并更新进度 */
    isDragging = true;
    var rate = event.offsetX / pgsWidth;
    audio.currentTime = audio.duration * rate;
    updateProgress(audio);
});

/* 播放模式切换 */
var modeId = 1;
mode.addEventListener('click', function (event) {
    modeId = modeId + 1;
    if (modeId > 3) {
        modeId = 1;
    }
    modeImg.src = "/img/mode" + modeId.toString() + ".png";
});

/* 倍速切换 */
speed.addEventListener('click', function (event) {
    var speedText = speed.innerText;
    if (speedText == "1.0X") {
        speed.innerText = "1.5X";
        audio.playbackRate = 1.5;
    }
    else if (speedText == "1.5X") {
        speed.innerText = "2.0X";
        audio.playbackRate = 2.0;
    }
    else if (speedText == "2.0X") {
        speed.innerText = "0.5X";
        audio.playbackRate = 0.5;
    }
    else if (speedText == "0.5X") {
        speed.innerText = "1.0X";
        audio.playbackRate = 1.0;
    }
});

// 存储上一次的音量
var lastVolumn = 50
// 滑块调节音量
audio.addEventListener('timeupdate', function updateVolumn() {
    audio.volume = volumeTogger.value / 50;
    if (volumeTogger.value  == 0) {
        volumeImg.src = "/img/音量.png";
    }
    else
        volumeImg.src = '/img/音量.png';
} );

// 点击音量调节设置静音
volume.addEventListener('click', function setNoVolumn() {
    if (volumeTogger.value == 0) {
        if (lastVolumn == 0) {
            lastVolumn = 50;
        }
        volumeTogger.value = lastVolumn;
        volumeImg.src = "/img/音量.png";
    }
    else {
        lastVolumn = volumeTogger.value;
        volumeTogger.value = 0;
        volumeImg.src = "/img/音量.png";
    }
} );

function closeListBoard() {
    musicList.classList.remove("list-card-show");
    musicList.classList.add("list-card-hide");
    closeList.style.display = "none";
}

// 点击列表展开音乐列表，点击其余区域或在此点击关闭
list.addEventListener('click', function (event) {
    if (musicList.classList.contains("list-card-show")) {
        musicList.classList.remove("list-card-show");
        musicList.classList.add("list-card-hide");
        closeList.style.display = "none";
    } else {
        musicList.classList.remove("list-card-hide");
        musicList.classList.add("list-card-show");
        musicList.style.display = "flex";
        closeList.style.display = "flex";
        closeList.addEventListener('click', closeListBoard);
    }
});

// MV功能
MV.addEventListener('click', function (event) {
    if (mvArea.innerHTML == '') {
        mvArea.innerHTML = `
            <video controls autoplay>
                <source src="/video/coldplay.mp4" type="video/mp4">
            </video>
        `;
        mvArea.style.display = 'block';
    }
    else mvArea.innerHTML = '';
});


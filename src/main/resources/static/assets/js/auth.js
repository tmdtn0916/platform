function getdata() {
    fetch('/getAuth')
        .then(response => response.json())
        .then(data => {
            handleData(data)
        })
        .catch(error => {
            console.error('데이터를 가져오는 중 오류 발생:', error);
        });
}

function handleData(data) {
    // 데이터를 처리하고 원하는 작업을 수행
    if (data.auth === "Gameflex") {
        alert("구독이 필요합니다.")
        window.location.reload();
    }
}

 document.getElementById("gameRegist").addEventListener('click', function () {
    getdata();
})
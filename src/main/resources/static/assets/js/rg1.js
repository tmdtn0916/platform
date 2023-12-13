// DOMContentLoaded 이벤트 리스너 추가
document.addEventListener('DOMContentLoaded', function() {
    // 페이지가 로드될 때 자동으로 리뷰 목록을 가져옴
    loadReviews();
});

// 리뷰 목록을 가져오는 함수
function loadReviews() {
    fetch('/getReview') // 서버 엔드포인트 경로를 수정하세요.
        .then(response => response.json())
        .then(data => {
            // 서버로부터 받아온 데이터(data)를 처리
            displayReviews(data);
        })
        .catch(error => {
            console.error('데이터를 가져오는 중 오류 발생:', error);
        });
}

function displayReviews(reviews) {
    const reviewsContainer = document.getElementById('comments-container');

    // 리뷰 목록을 초기화
    reviewsContainer.innerHTML = '';

    // 받아온 리뷰 목록을 HTML에 추가
    reviews.forEach(review => {
        const reviewElement = document.createElement('div');
        reviewElement.innerHTML = "<strong>"+ review.title + "</strong> - 추천: " +(review.recommend === true? "추천함" : "추천하지 않음")+ "<p>"+review.content+"</p>";
        reviewsContainer.appendChild(reviewElement);
    });
}
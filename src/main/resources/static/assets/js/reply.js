// 댓글 데이터
let comments = [];

// 댓글 추가 함수
function addComment() {
    let title = document.getElementById("demo-name").value;
    let category = document.getElementById("demo-category").value;
    let message = document.getElementById("demo-message").value;

    if (title && category !== null && message) {
        let newComment = {
            title: title,
            category: category,
            message: message
        };

        comments.push(newComment);

        updateComments();

        // 폼 비우기
        document.getElementById("demo-name").value = "";
        document.getElementById("demo-category").value = "";
        document.getElementById("demo-message").value = "";
    } else {
        alert("모든 필드를 작성하세요.");
    }
}

// 댓글 목록 갱신 함수
function updateComments() {
    let commentsContainer = document.getElementById("comments-container");
    commentsContainer.innerHTML = "";

    for (let i = 0; i < comments.length; i++) {
        let comment = comments[i];

        let commentElement = document.createElement("div");
        commentElement.innerHTML = "<strong>" + comment.title + "</strong> - 추천: " + (comment.category === "1" ? "추천함" : "추천하지 않음") + "<p>" + comment.message + "</p>";
        commentsContainer.appendChild(commentElement);
    }
}


// 댓글 폼 제출 이벤트 핸들러
document.getElementById("comment-form").addEventListener("submit", function (event) {
    event.preventDefault();
    addComment();
});
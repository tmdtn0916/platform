let selectedCategories = [];

document.getElementById('categories').addEventListener('change', function () {
    let selectedOptions = this.selectedOptions;
    selectedCategories = Array.from(selectedOptions).map(function (option) {
        return option.value;
    });
    // hidden input 필드에 선택한 항목을 설정
    document.getElementById('selectedCategoriesInput').value = selectedCategories.join(',');
});

document.getElementById('submitButton').addEventListener('click', function () {
    // 여기에서 selectedCategories 배열을 서버로 전송하는 로직을 추가하세요.
    // 예를 들어, AJAX를 사용하거나 폼을 서버로 제출하는 방법을 사용할 수 있습니다.
    console.log(selectedCategories)
});
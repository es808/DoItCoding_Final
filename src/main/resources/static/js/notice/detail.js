$(function (){
    $('#delete').click(function (e){
        if(confirm("정말로 삭제하시겠습니까?")==false) {
            e.preventDefault()
        }
    })
})
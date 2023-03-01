$(function (){
    // 저장된 카테고리가 자동으로 selected 되게 처리
    // $('#select_category').val($('#selected_category').text()).change()
    let selected_category=$('#selected_category').html()
    $('#select_category option[value="'+selected_category+'"]').prop('selected',true)

    // 저장된 티켓 정보가 자동으로 selected 되게 처리
    let selected_ticketid=$('#selected_ticketid').text()
    $('#select_ticket option[value="'+selected_ticketid+'"]').prop('selected',true)

    // 저장된 공개/비공개 여부가 자동으로 라디오 버튼 찍히게 처리
    let selected_open=$('#selected_open').text()
    console.log(selected_open)
    $('input[name="qna_open"][value="'+selected_open+'"]').prop('checked',true)
})
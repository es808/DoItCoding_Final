$(function (){
    let selected_category=$('#notice_category').text()
    $('#select_category option[value="'+selected_category+'"]').prop('selected',true)
})
$(function (){
    let searchColumn=$('#div_searchColumn').html()
    if(searchColumn!=null){
        $('#select_column option[value="'+searchColumn+'"]').prop('selected',true)
    }
    let keyword=$('#div_keyword').html()
    if(keyword!=null){
        $('#keyword').val(keyword)
    }
})
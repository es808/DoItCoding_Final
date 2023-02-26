$(function (){
    searchColumn=$('#div_searchColumn').html()
    if(searchColumn!=null){
        $('#select_column option[value="'+searchColumn+'"]').prop('selected',true)
    }
})
$(function () {
    $(".perfil").click(function () {
        $("#trocarImgPerfil").modal();
    });

    $("#excluiConta").click(function () {
        $("#excluirModal").modal();
    });

    $("#logout").click(function () {
        $("#logoutModal").modal();
    });

    $('#formCreateItem\\:selectOfItemType').click(function () {
	
        if (document.getElementById('formCreateItem:selectOfItemType').value == 'SIM') {
            document.getElementById('formCreateItem:dateOfItem').disabled = true;           
            $('#helpItem').show();
        } else {
            document.getElementById('formCreateItem:dateOfItem').disabled = false;
            $('#helpItem').hide();
        }	
    });
	
})


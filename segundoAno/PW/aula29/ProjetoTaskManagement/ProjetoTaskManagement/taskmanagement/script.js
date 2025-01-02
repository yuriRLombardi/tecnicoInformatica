function pegarIDEdit(id) {
    let editar = id.getAttribute("data-idTarefa");
    let armId = document.getElementById('idTarefaEdit');
    armId.value = editar;
}
function pegarIDExcluir(id) {
    let excluir = id.getAttribute("data-idTarefa");
    let armId = document.getElementById('idTarefaExcluir');
    armId.value = excluir;
}
function filtroTarefas(selecao) {
    if (selecao == "") {
        document.getElementById("txtHint").innerHTML = "";
        return;
    } else {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("txtHint").innerHTML = this.responseText;
        }
        };
        xmlhttp.open("GET","filtro.php?selecao="+selecao,true);
        xmlhttp.send();
    }
}
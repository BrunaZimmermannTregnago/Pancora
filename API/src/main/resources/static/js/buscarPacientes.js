function buscarPacientes(){

    var url = "http://localhost:8000/listar-paciente";

    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", url, false);

    xhttp.send();//A execução do script para aqui até a requisição retornar do servidor

    var dados = xhttp.responseText;
    var html = "";
    JSON.parse(dados).forEach( function (registro){
        html += '<tr><td class="space-list">'
        +registro.nome
        +'</td><td class="space-list">'
        +registro.telefone
        +'</td><td class="space-list">'
        +registro.sexo
        +'</td><td class="space-list">'
        +registro.cidadeId.nome
        +'</td><td class="space-list">'
        +registro.cidadeId['ufId'].nomeSigla
        +"</td></tr>"

    })
    document.getElementById('registros').innerHTML = html;
}
function cadastrarSintoma(){
    var sintomaId = $("#sintomaid").val();
    var cpf = $("#cpf").val();
    var grauIntesidade = $("#grauintensidade").val();
    var dataInicio = $("#datainicio").val();
    var dataFinal = $("#datafinal").val();

    if(sintomaId==null) alert("Informe o sintoma.");
    if(grauIntesidade==null) alert("Informe o grau de intensidade do sintoma.");
    if(dataInicio==null) alert("Informe a data de início do sintoma.");

    $.ajax({
               method : "POST",
               url : "/cadastro-sintoma",
               data : JSON.stringify({dataInicio : dataInicio,
                                    grauIntesidade : grauIntesidade,
                                    dataFinal : dataFinal,
                                    cpf : cpf,
                                    sintomaId : sintomaId}),
               contentType : "application/json; charset=utf-8",
               success : function(response){
                   $("#sintomaId").val(response.id);
                   alert("Cadastro realizado com sucesso!");
               },
			   error: function(xhr, status, errorThrown){
                   alert("Erro ao cadastrar." + xhr.responseText);
               }
           });
}
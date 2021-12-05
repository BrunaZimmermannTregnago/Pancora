function cadastrarPaciente(){
    var cpf = $("#cpf").val();
    var nome = $("#nome").val();
    var telefone = $("#telefone").val();
    var dataNascimento = $("#datanascimento").val();
    var peso = $("#peso").val();
    var altura = $("#altura").val();
    var rua = $("#rua").val();
    var numero = $("#numero").val();
    var cep = $("#cep").val();
    var bairroId = $("#bairro").val();
    var cidadeId = $("#cidade").val();
    var sexo = $("#sexo").val();

    $.ajax({
               method : "POST",
               url : "/cadastro-paciente",
               data : JSON.stringify({cpf : cpf,
                                      nome : nome,
                                      telefone : telefone,
                                      dataNascimento: dataNascimento,
                                      peso : peso,
                                      altura : altura,
                                      ruaEndereco : rua,
                                      numeroEndereco: numero,
                                      cep : cep,
                                      bairroId : bairroId,
                                      cidadeId : cidadeId,
                                      sexo : sexo}),
               contentType : "application/json; charset=utf-8",
               success : function(response){
                   $("#nome").val(response.id);
                   alert("Cadastro realizado com sucesso!");
               },
			   error: function(xhr, status, errorThrown){
                   alert("Erro ao cadastrar." + xhr.responseText);
               }
           });
}
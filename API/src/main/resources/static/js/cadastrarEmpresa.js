function cadastrarEmpresa(){
    var razaoSocial = $("#razaoSocial").val();
    var nomeFantasia = $("#nomeFantasia").val();
    var ramo = $("#ramo").val();
    var cnpj = $("#cnpj").val();
    var cidade = $("#cidade").val();
    var estado = $("#estado").val();
    var rua = $("#rua").val();
    var numero = $("#numero").val();
    var email = $("#email").val();
    var telefone = $("#telefone").val();
    var cep = $("#cep").val();
    var bairro = $("#bairro").val();

    $.ajax({
               method : "POST",
               url : "/cadastro-empresa",
               data : JSON.stringify({cnpj : cnpj,
                                      razaoSocial : razaoSocial,
                                      nomeFantasia : nomeFantasia,
                                      telefone : telefone,
                                      email : email,
                                      ramoAtividade : ramo,
                                      ruaEndereco : rua,
                                      numeroEndereco : numero,
                                      cep : cep,
                                      bairroId : bairro,
                                      cidadeId : cidade}),
               contentType : "application/json; charset=utf-8",
               success : function(response){
                   $("#nomeFantasia").val(response.id);
                   alert("Cadastro realizado com sucesso!");
               },
			   error: function(xhr, status, errorThrown){
                   alert("Erro ao cadastrar." + xhr.responseText);
               }
           });
}
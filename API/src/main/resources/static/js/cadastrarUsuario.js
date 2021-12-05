function cadastrarUsuario(){
    var username = $("#username").val();
    var email = $("#email").val();
    var password = $("#password").val();

    if(username == ""){
        alert("Informe seu nome de usuário!");
        $("#username").focus();
        return;
    }else if(email == ""){
        alert("Informe seu email!");
        $("#email").focus();
        return;
    }else if(password == ""){
        alert("Informe sua senha!");
        $("#password").focus();
        return;
    }else{
        $.ajax({
             method : "POST",
             url : "/registration",
             data : JSON.stringify({username : username,
                                    email : email,
                                    password : password}),
             contentType : "application/json; charset=utf-8",
             success : function(response){
                 $("#username").val(response.id);
                 alert("Obrigado por se cadastrar! Valide sua conta através do link de confirmação que enviamos para o seu email.");
             },
             error : function(xhr, status, errorThrown){
                 alert("Erro ao cadastrar." + xhr.responseText);
             }
        });
    }
 }
create or replace procedure consultaPaciente(cpf bigint)
as 
$body$
declare 
	nome varchar := '';
begin
	select pacnom into nome from paciente
	where paccpf = cpf;
	raise notice '%', nome;
end
$body$
language plpgsql;

create or replace procedure alteraNome(cpf bigint, nome varchar)
as 
$body$
begin 
 	update paciente set pacnom = nome
 	where paccpf = cpf;
 	raise notice 'Alterado com sucesso!';
end
$body$
language plpgsql;

create or replace function quantos_ativos()
returns trigger as 
$body$
declare 
	cont int := 0;
begin 
	select count(*) into cont from situacao_paciente sp
	where sitid = 6;
	raise notice '% casos estão ativos.', cont; 
	return new;
end
$body$
language plpgsql;

create trigger quantos_ativos_after_tg
after update 
on situacao_paciente
for each row 
execute procedure quantos_ativos();

update situacao_paciente set sitid = 6
where sitpacid = 4;

create or replace function quantos_recuperados()
returns trigger as 
$body$
declare 
	cont int := 0;
begin 
	select count(*) into cont from situacao_paciente sp
	where sitid = 2;
	raise notice '% casos estão recuperados.', cont; 
	return new;
end
$body$
language plpgsql;
 
create trigger quantos_recuperados_after_tg
after update
on situacao_paciente
for each row 
execute procedure quantos_recuperados();

update situacao_paciente set sitid = 6
where sitpacid = 4;
--------------------------------------------------------------------------------------------------------------------------------

create or replace function funcionamento_trigger()
	returns trigger as 
	$body$
	begin
		raise notice '% - % - % - NEW(%) , OLD(%)', TG_RELNAME, TG_OP, TG_WHEN, new::text, old::text; 
		return new;
	end
	$body$
	language plpgsql;
	
-- CRIANDO A TRIGGER
create trigger situacao_paciente_before_tg
before insert or update or delete 
on situacao_paciente -- tabela
for each row 
execute procedure funcionamento_trigger();
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

--------------------------------------------------------------REVISAR toda_situacao()--------------------------------------------------------------

create or replace function toda_situacao()
returns trigger as 
$body$
declare 
	cont int := 0;
begin 
	select count(sp.*) into cont from situacao_paciente sp
	inner join situacao s on s.sitid = sp.sitid
	group by s.sitpac;
	for i in 1..6 loop
		raise notice '% casos.', cont;
	end loop;
	return new;
end
$body$
language plpgsql;

create trigger toda_situcao_after_tg
after insert 
on situacao_paciente
for each row 
execute procedure toda_situacao();

update situacao_paciente set sitid = 6
where sitpacid = 4;

delete from situacao_paciente where paccpf = 70745065565;

insert into situacao_paciente (sitid, paccpf, sitpacdatini) values
(1,70745065565,'2021-03-25');

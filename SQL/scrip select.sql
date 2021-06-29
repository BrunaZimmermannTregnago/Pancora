-- view 1.

create view vw_pacientes_febre_70_60_anos as
SELECT pa.paccpf as CPF, pa.pacnom as nome from paciente pa
INNER JOIN sintoma_paciente sp on pa.paccpf = sp.paccpf and sp.sinid = 1
where pa.pacdatnas 
between (current_date - interval '70 years') and (current_date - interval '60 years')
ORDER BY pa.pacnom asc;

-- view 2.

create view vw_nao_reagente_municipios as
select pa.pacnom as nome, ci.cidnom as cidade from Paciente pa
inner join Cidade ci on pa.cidid = ci.cidid 
inner join Situacao_Paciente spa on spa.paccpf = pa.paccpf
where pa.pacsex='F' and ci.cidnom in ('Maravilha','Descanso','Pinhalzinho','Chapecó','Itapiranga') 
and spa.sitid = 5
order by ci.cidnom asc,pa.pacnom desc;

-- view 3.

create view vw_casos_suspeitos_por_cidade as
select c.cidid "código da cidade", c.cidnom cidade, count(spa.sitid) "casos suspeitos"
from cidade c
left join paciente p on p.cidid = c.cidid
left join situacao_paciente spa on spa.paccpf = p.paccpf and spa.sitid = 1
group by c.cidid
order by count(spa.sitid) desc;

-- view 4.

create view vw_idade_agosto_setembro_2020 as
select count(p.paccpf) as positivados, ((current_date - p.pacdatnas)/365) as idade 
from paciente p 
inner join situacao_paciente spa on spa.paccpf = p.paccpf and spa.sitid = 6
where spa.dat_ini between '2020-08-01' and '2020-10-31'
group by idade
order by count(p.paccpf) desc;

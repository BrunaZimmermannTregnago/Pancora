-- select 1.
SELECT pa.paccpf, pa.pacnom from paciente pa
INNER JOIN sintoma_paciente sp on pa.paccpf = sp.paccpf and sp.sinid = 1
where pa.pacdatnas 
between (current_date - interval '70 years') and (current_date - interval '60 years')
ORDER BY pa.pacnom asc;

-- select 2.

select pa.pacnom, ci.cidnom from Paciente pa
inner join Cidade ci on pa.cidid = ci.cidid 
inner join Situacao_Paciente spa on spa.paccpf = pa.paccpf 
inner join Situacao si on si.sitid =spa.sitid 
where pa.pacsex='M' and (ci.cidnom='Maravilha' or ci.cidnom='Descanso'or ci.cidnom='Pinhalzinho' or ci.cidnom='Chapecï¿½' or ci.cidnom='Itapiranga') and si.sitpac='Nï¿½o reagente' 
order by ci.cidnom asc,pa.pacnom desc;

-- view 3.

create view vw_casos_suspeitos_por_cidade as
select c.cidid "código da cidade", c.cidnom cidade, count(spa.sitid) "casos suspeitos"
from cidade c
left join paciente p on p.cidid = c.cidid
left join situacao_paciente spa on spa.paccpf = p.paccpf and spa.sitid = 1
group by c.cidid
order by count(spa.sitid) desc;

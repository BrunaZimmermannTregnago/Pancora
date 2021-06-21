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
where pa.pacsex='M' and (ci.cidnom='Maravilha' or ci.cidnom='Descanso'or ci.cidnom='Pinhalzinho' or ci.cidnom='Chapec�' or ci.cidnom='Itapiranga') and si.sitpac='N�o reagente' 
order by ci.cidnom asc,pa.pacnom desc
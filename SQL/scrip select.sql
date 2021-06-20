-- select 2.

select pa.pacnom, ci.cidnom from Paciente pa
inner join Cidade ci on pa.cidid = ci.cidid 
inner join Situacao_Paciente spa on spa.paccpf =pa.paccpf 
inner join Situacao si on si.sitid =spa.sitid 
where pa.pacsex='M' and (ci.cidnom='Maravilha' or ci.cidnom='Descanso'or ci.cidnom='Pinhalzinho' or ci.cidnom='Chapecó' or ci.cidnom='Itapiranga') and si.sitpac='Não reagente' 
order by ci.cidnom asc,pa.pacnom desc
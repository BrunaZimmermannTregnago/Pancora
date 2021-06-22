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
order by ci.cidnom asc,pa.pacnom DESC


-- select 3.
SELECT baiid, bainom 
  FROM Bairro;

-- select 4.
SELECT cidid, cidnom, ufid 
  FROM Cidade;

 --select 5.
SELECT comid, comdes 
  FROM Comorbidade;

 --select 6.
SELECT compacid, comid, paccpf 
  FROM Comorbidade_Paciente;
 
 --select 7.
SELECT empcnpj, emprazsoc, empnomfan, emptel, empema, empramati, empendrua, empendnum, empcep, baiid, cidid 
  FROM Empresa;
 
 --select 8.
SELECT emppacid, emppacfun, empcnpj, paccpf 
  FROM Empresa_Paciente;
 
 --select 9.
SELECT oricid, orides 
  FROM Orientacao;

 --select 10.
SELECT paccpf, pacnom, pactel, pacema, pacdatnas, pacpes, pacalt, pacendrua, pacendnum, paccep, pacpos, baiid, cidid 
  FROM Paciente;
 
 --select 11.
SELECT sinid, sindes 
  FROM Sintoma;
 
  --select 12.
SELECT sintipid, sinpacdatini, sinpacgraint, sinpacdatfim, paccpf, sinid 
  FROM Sintoma_Paciente;
 
 --select 13.
SELECT sitid, sitpac 
  FROM Situacao;
 
 --select 14.
SELECT sitpacid, sitid, paccpf 
  FROM Situacao_Paciente;
 
 --select 15.
SELECT tipusuid, tipusudes, paccpf, empcnpj 
  FROM Tipo_Usuario;
 
 --select 16.  
SELECT ufid, ufsignom 
  FROM Unidade_Federativa;
 
 --select 17.
SELECT vacid, vacnom 
  FROM Vacina;
 
 --select 18.
SELECT vacpacid, vacdos, vacid, paccpf 
  FROM Vacina_Paciente;
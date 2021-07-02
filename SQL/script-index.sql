-- INDEX

create index paciente_nome 
on paciente(pacnom);

create index paciente_usuario
on paciente(tipusuid);

create index paciente_cidade
on paciente(cidid);

create index empresa_nome
on empresa(empnomfan);

create index empresa_cidade
on empresa(cidid);

create index emp_paciente_empresa
on empresa_paciente(empcnpj);

create index emp_paciente_paciente
on empresa_paciente(paccpf);

create index sintoma_nome
on sintoma(sindes);

create index sin_paciente_paciente
on sintoma_paciente(paccpf);

create index situacao_nome
on situacao(sitpac);

create index sit_paciente_paciente
on situacao_paciente(paccpf);

create index comorbidade_nome
on comorbidade(comdes);

create index vac_paciente_paciente
on vacina_paciente(paccpf);

create index vac_paciente_vacina
on vacina_paciente(vacid);

create index cidade_uf
on cidade(ufid);

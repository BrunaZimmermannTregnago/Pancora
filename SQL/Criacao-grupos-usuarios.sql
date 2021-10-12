CREATE group empresa;
GRANT SELECT, INSERT, DELETE, UPDATE ON bairro, cidade, comorbidade, comorbidade_paciente, empresa,
empresa_paciente, orientacao, paciente, situacao, situacao_paciente, tipo_usuario, unidade_federativa,
vacina, vacina_paciente to empresa;

create group paciente;
GRANT SELECT ON bairro, cidade, comorbidade, comorbidade_paciente, empresa,
empresa_paciente, orientacao, paciente, situacao, situacao_paciente, tipo_usuario, unidade_federativa,
vacina, vacina_paciente to paciente;
GRANT SELECT, INSERT, DELETE, UPDATE on sintoma, sintoma_paciente to paciente;


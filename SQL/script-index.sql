-- INDEX

create index paciente_info_index on
paciente (paccpf, pacnom, pacsex, pacdatnas, pacpes, pacalt);

create index paciente_contato_index on
paciente (pactel, pacema, paccep, cidid, baiid, pacendrua, pacendnum);

create index empresa_index on
empresa (empnomfan, empcnpj, emprazsoc, emptel, empema);

create index sintoma_index on
sintoma (sinid, sindes);

create index situacao_index on 
situacao (sitid, sitpac);

create index comorbidade_index on 
comorbidade (comid, comdes);

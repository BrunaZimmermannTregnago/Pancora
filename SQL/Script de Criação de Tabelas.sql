--CREATE
CREATE TABLE Bairro (
  baiid  SERIAL NOT NULL, 
  bainom varchar(250) NOT NULL, 
  PRIMARY KEY (baiid));
COMMENT ON TABLE Bairro IS 'Cadastro do bairro da cidade.';
COMMENT ON COLUMN Bairro.baiid IS 'Código de idetificação do bairro da cidade';
COMMENT ON COLUMN Bairro.bainom IS 'Nome do bairro da cidade';

CREATE TABLE Cidade (
  cidid  int4 NOT NULL, 
  cidnom varchar(250) NOT NULL, 
  ufid   int4 NOT NULL, 
  PRIMARY KEY (cidid));
COMMENT ON COLUMN Cidade.cidid IS 'Código de identificação da cidade';
COMMENT ON COLUMN Cidade.cidnom IS 'Nome da cidade';

CREATE TABLE Comorbidade (
  comid  SERIAL NOT NULL, 
  comdes varchar(80) NOT NULL UNIQUE, 
  PRIMARY KEY (comid));
COMMENT ON TABLE Comorbidade IS 'Histórico de Comorbidades';
COMMENT ON COLUMN Comorbidade.comid IS 'Código de identificação do histórico de comorbidades do paciente.';
COMMENT ON COLUMN Comorbidade.comdes IS 'Descrição da comorbidade.';

CREATE TABLE Comorbidade_Paciente (
  compacid SERIAL NOT NULL, 
  comid    int4 NOT NULL, 
  paccpf   numeric(11, 0) NOT NULL, 
  PRIMARY KEY (compacid));
COMMENT ON TABLE Comorbidade_Paciente IS 'Tabela de ligação entre Comorbidade e Paciente';
COMMENT ON COLUMN Comorbidade_Paciente.compacid IS 'Código de identificação';

CREATE TABLE Empresa (
  empcnpj   numeric(14, 0) NOT NULL, 
  emprazsoc varchar(80) NOT NULL, 
  empnomfan varchar(80) NOT NULL, 
  emptel    varchar(15) NOT NULL, 
  empema    varchar(60), 
  empramati varchar(80), 
  empendrua varchar(255) NOT NULL, 
  empendnum varchar(15) NOT NULL, 
  empcep    int4 NOT NULL, 
  baiid     int4 NOT NULL, 
  cidid     int4 NOT NULL, 
  PRIMARY KEY (empcnpj));
COMMENT ON TABLE Empresa IS 'Cadastro de empresas.';
COMMENT ON COLUMN Empresa.empcnpj IS 'Cadastro do CNPJ da empresa.';
COMMENT ON COLUMN Empresa.emprazsoc IS 'Razão social da empresa.';
COMMENT ON COLUMN Empresa.empnomfan IS 'Nome fantasia da empresa.';
COMMENT ON COLUMN Empresa.emptel IS 'Telefone da empresa.';
COMMENT ON COLUMN Empresa.empema IS 'Email da empresa.';
COMMENT ON COLUMN Empresa.empramati IS 'Ramo de atividade da empresa.';
COMMENT ON COLUMN Empresa.empendrua IS 'Rua do endereço da empresa';
COMMENT ON COLUMN Empresa.empendnum IS 'Número do endereço da empresa';
COMMENT ON COLUMN Empresa.empcep IS 'CEP da empresa';

CREATE TABLE Empresa_Paciente (
  emppacid  SERIAL NOT NULL, 
  emppacfun varchar(80) NOT NULL, 
  empcnpj   numeric(14, 0) NOT NULL, 
  paccpf    numeric(11, 0) NOT NULL, 
  PRIMARY KEY (emppacid));
COMMENT ON TABLE Empresa_Paciente IS 'Tabela de ligação entre Empresa e Paciente.';
COMMENT ON COLUMN Empresa_Paciente.emppacid IS 'Código de identificação da relação.';
COMMENT ON COLUMN Empresa_Paciente.emppacfun IS 'Função desempenhada pelo paciente dentro empresa.';

CREATE TABLE Orientacao (
  oricid SERIAL NOT NULL, 
  orides varchar(255) NOT NULL, 
  PRIMARY KEY (oricid));
COMMENT ON COLUMN Orientacao.oricid IS 'Código de identificação da orientação.';
COMMENT ON COLUMN Orientacao.orides IS 'Descrição da orientação.';

CREATE TABLE Paciente (
  paccpf    numeric(11, 0) NOT NULL, 
  pacnom    varchar(200) NOT NULL, 
  pactel    varchar(15) NOT NULL, 
  pacema    varchar(60) NOT NULL, 
  pacdatnas date NOT NULL, 
  pacpes    numeric(5, 2) NOT NULL, 
  pacalt    numeric(3, 2) NOT NULL, 
  pacendrua varchar(250) NOT NULL, 
  pacendnum varchar(15) NOT NULL, 
  paccep    int4 NOT NULL, 
  pacpos    char(1) DEFAULT 'F' NOT NULL CHECK(pacpos in ('F','V') ) 		, 
  baiid     int4 NOT NULL, 
  cidid     int4 NOT NULL, 
  PRIMARY KEY (paccpf));
COMMENT ON TABLE Paciente IS 'Cadastro do paciente';
COMMENT ON COLUMN Paciente.paccpf IS 'CPF do paciente';
COMMENT ON COLUMN Paciente.pacnom IS 'Nome de paciente';
COMMENT ON COLUMN Paciente.pactel IS 'Telefone do paciente';
COMMENT ON COLUMN Paciente.pacema IS 'Email do paciente';
COMMENT ON COLUMN Paciente.pacdatnas IS 'Data de nascimento do paciente';
COMMENT ON COLUMN Paciente.pacpes IS 'Peso do paciente';
COMMENT ON COLUMN Paciente.pacalt IS 'Altura do paciente';
COMMENT ON COLUMN Paciente.pacendrua IS 'Rua do endereço do paciente';
COMMENT ON COLUMN Paciente.pacendnum IS 'Número do endereço do paciente';
COMMENT ON COLUMN Paciente.paccep IS 'CEP do paciente';
COMMENT ON COLUMN Paciente.pacpos IS 'Situação da contaminação do paciente, se em algum momento já foi reagente.';

CREATE TABLE Sintoma (
  sinid  SERIAL NOT NULL, 
  sindes varchar(80) NOT NULL UNIQUE, 
  CONSTRAINT Sintoma_pk
    PRIMARY KEY (sinid));
COMMENT ON TABLE Sintoma IS 'Cadastro do tipo do sintoma.';
COMMENT ON COLUMN Sintoma.sinid IS 'Código de identificação do tipo do sintoma.';
COMMENT ON COLUMN Sintoma.sindes IS 'Descrição do sintoma.';

CREATE TABLE Sintoma_Paciente (
  sintipid     SERIAL NOT NULL, 
  sinpacdatini date NOT NULL, 
  sinpacgraint varchar(50) NOT NULL CHECK(sinpacgraint in ('P','M','C')), 
  sinpacdatfim date, 
  paccpf       numeric(11, 0) NOT NULL, 
  sinid        int4 NOT NULL, 
  PRIMARY KEY (sintipid));
COMMENT ON COLUMN Sintoma_Paciente.sintipid IS 'Código de identificação dos sintomas.';
COMMENT ON COLUMN Sintoma_Paciente.sinpacdatini IS 'Data do início do(s) sintoma(s).';
COMMENT ON COLUMN Sintoma_Paciente.sinpacgraint IS 'Grau de intensidade dos sintomas (P - Pouco, M - Moderado, C - Constante)';
COMMENT ON COLUMN Sintoma_Paciente.sinpacdatfim IS 'Data do fim do(s) sintoma(s).';
COMMENT ON COLUMN Sintoma_Paciente.paccpf IS 'CPF do paciente.';

CREATE TABLE Situacao (
  sitid  SERIAL NOT NULL, 
  sitpac varchar(20) NOT NULL UNIQUE, 
  PRIMARY KEY (sitid));
COMMENT ON TABLE Situacao IS 'Cadastro da situação.';
COMMENT ON COLUMN Situacao.sitid IS 'Código de identificação da situação do paciente.';
COMMENT ON COLUMN Situacao.sitpac IS 'Situação do paciente. (Em isolamento, Recuperado, Em leito hospitalar, Tratamento na UTI, Não reagente)';

CREATE TABLE Situacao_Paciente (
  sitpacid SERIAL NOT NULL, 
  sitid    int4 NOT NULL, 
  paccpf   numeric(11, 0) NOT NULL, 
  PRIMARY KEY (sitpacid));
COMMENT ON TABLE Situacao_Paciente IS 'Tabela de ligação entre Situacao e Paciente';
COMMENT ON COLUMN Situacao_Paciente.sitpacid IS 'Código de identifcação';

CREATE TABLE Tipo_Usuario (
  tipusuid  SERIAL NOT NULL, 
  tipusudes varchar(15) NOT NULL UNIQUE, 
  paccpf    numeric(11, 0) NOT NULL, 
  empcnpj   numeric(14, 0) NOT NULL, 
  PRIMARY KEY (tipusuid));
COMMENT ON COLUMN Tipo_Usuario.tipusuid IS 'Código identificador do tipo do usuário.';
COMMENT ON COLUMN Tipo_Usuario.tipusudes IS 'Descrição do tipo de usuário.';

CREATE TABLE Unidade_Federativa (
  ufid     SERIAL NOT NULL, 
  ufsignom varchar(2) NOT NULL UNIQUE, 
  PRIMARY KEY (ufid));
COMMENT ON TABLE Unidade_Federativa IS 'Cadastro da Unidade Federativa.';
COMMENT ON COLUMN Unidade_Federativa.ufid IS 'Código de identificação da Unidade Federativa';
COMMENT ON COLUMN Unidade_Federativa.ufsignom IS 'Sigla do nome da Unidade Federativa.';

CREATE TABLE Vacina (
  vacid  SERIAL NOT NULL, 
  vacnom varchar(100) NOT NULL, 
  PRIMARY KEY (vacid));
COMMENT ON COLUMN Vacina.vacnom IS 'Nome da vacina do laboratório';

CREATE TABLE Vacina_Paciente (
  vacpacid SERIAL NOT NULL, 
  vacdos   numeric(1, 0) NOT NULL, 
  vacid    int4 NOT NULL, 
  paccpf   numeric(11, 0) NOT NULL, 
  PRIMARY KEY (vacpacid)); 
COMMENT ON TABLE Vacina_Paciente IS 'Tabela de ligação entre Paciente e Vacina.';
COMMENT ON COLUMN Vacina_Paciente.vacpacid IS 'Código de identificação.';
COMMENT ON COLUMN Vacina_Paciente.vacdos IS 'Doses da vacina que o paciente tomou.';

ALTER TABLE Cidade ADD CONSTRAINT cid_ufid_fk FOREIGN KEY (ufid) REFERENCES Unidade_Federativa (ufid);
ALTER TABLE Empresa ADD CONSTRAINT emp_baiid_fk FOREIGN KEY (baiid) REFERENCES Bairro (baiid);
ALTER TABLE Paciente ADD CONSTRAINT pac_baiid_fk FOREIGN KEY (baiid) REFERENCES Bairro (baiid);
ALTER TABLE Paciente ADD CONSTRAINT pac_cidid_fk FOREIGN KEY (cidid) REFERENCES Cidade (cidid);
ALTER TABLE Empresa ADD CONSTRAINT emp_cidid_fk FOREIGN KEY (cidid) REFERENCES Cidade (cidid);
ALTER TABLE Sintoma_Paciente ADD CONSTRAINT sinpac_paccpf_fk FOREIGN KEY (paccpf) REFERENCES Paciente (paccpf);
ALTER TABLE Sintoma_Paciente ADD CONSTRAINT sinpac_sinid_fk FOREIGN KEY (sinid) REFERENCES Sintoma (sinid);
ALTER TABLE Vacina_Paciente ADD CONSTRAINT vacpac_vacid_fk FOREIGN KEY (vacid) REFERENCES Vacina (vacid);
ALTER TABLE Vacina_Paciente ADD CONSTRAINT vacpac_paccpf_fk FOREIGN KEY (paccpf) REFERENCES Paciente (paccpf);
ALTER TABLE Comorbidade_Paciente ADD CONSTRAINT compac_comid_fk FOREIGN KEY (comid) REFERENCES Comorbidade (comid);
ALTER TABLE Comorbidade_Paciente ADD CONSTRAINT compac_paccpf_fk FOREIGN KEY (paccpf) REFERENCES Paciente (paccpf);
ALTER TABLE Tipo_Usuario ADD CONSTRAINT tipusu_paccpf_fk FOREIGN KEY (paccpf) REFERENCES Paciente (paccpf);
ALTER TABLE Tipo_Usuario ADD CONSTRAINT tipusu_empcnpj_fk FOREIGN KEY (empcnpj) REFERENCES Empresa (empcnpj);
ALTER TABLE Empresa_Paciente ADD CONSTRAINT emppac_empcnpj_fk FOREIGN KEY (empcnpj) REFERENCES Empresa (empcnpj);
ALTER TABLE Empresa_Paciente ADD CONSTRAINT emppac_paccpf_fk FOREIGN KEY (paccpf) REFERENCES Paciente (paccpf);
ALTER TABLE Situacao_Paciente ADD CONSTRAINT sitpac_sitid_fk FOREIGN KEY (sitid) REFERENCES Situacao (sitid);
ALTER TABLE Situacao_Paciente ADD CONSTRAINT sitpac_paccpf_fk FOREIGN KEY (paccpf) REFERENCES Paciente (paccpf);

-- criando sequence e definindo set default para Cidade(cidid)
CREATE SEQUENCE cid_serial;
ALTER TABLE cidade ALTER COLUMN cidid SET DEFAULT nextval('cid_serial');

-- excluindo as colunas paccpf e empcnpj da tabela tipo_usuario
alter table tipo_usuario drop column paccpf;
alter table tipo_usuario drop column empcnpj;

-- criando coluna fk tipusuid na tabela paciente
alter table paciente add column tipusuid int4 not null constraint pac_tipusuid_fk references Tipo_Usuario (tipusuid);

-- adicionando coluna pacsex na tabela paciente
alter table paciente add column pacsex char(1) not null constraint pac_pacsex_ck check (pacsex in ('F','M','N','O'));
comment on column paciente.pacsex is 'Sexo do paciente (F - Feminino, M - Masculino, N - Não-binário, O - Outro).';

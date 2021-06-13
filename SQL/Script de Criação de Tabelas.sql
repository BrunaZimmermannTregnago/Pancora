--CREATE
CREATE TABLE Bairro (
  baiid  SERIAL NOT NULL, 
  bainom varchar(250) NOT NULL, 
  PRIMARY KEY (baiid));
COMMENT ON TABLE Bairro IS 'Cadastro do bairro da cidade.';
COMMENT ON COLUMN Bairro.baiid IS 'C�digo de idetifica��o do bairro da cidade';
COMMENT ON COLUMN Bairro.bainom IS 'Nome do bairro da cidade';

CREATE TABLE Cidade (
  cidid  int4 NOT NULL, 
  cidnom varchar(250) NOT NULL, 
  ufid   int4 NOT NULL, 
  PRIMARY KEY (cidid));
COMMENT ON COLUMN Cidade.cidid IS 'C�digo de identifica��o da cidade';
COMMENT ON COLUMN Cidade.cidnom IS 'Nome da cidade';

CREATE TABLE Comorbidade (
  comid  SERIAL NOT NULL, 
  comdes varchar(80) NOT NULL UNIQUE, 
  PRIMARY KEY (comid));
COMMENT ON TABLE Comorbidade IS 'Hist�rico de Comorbidades';
COMMENT ON COLUMN Comorbidade.comid IS 'C�digo de identifica��o do hist�rico de comorbidades do paciente.';
COMMENT ON COLUMN Comorbidade.comdes IS 'Descri��o da comorbidade.';

CREATE TABLE Comorbidade_Paciente (
  compacid SERIAL NOT NULL, 
  comid    int4 NOT NULL, 
  paccpf   numeric(11, 0) NOT NULL, 
  PRIMARY KEY (compacid));
COMMENT ON TABLE Comorbidade_Paciente IS 'Tabela de liga��o entre Comorbidade e Paciente';
COMMENT ON COLUMN Comorbidade_Paciente.compacid IS 'C�digo de identifica��o';

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
COMMENT ON COLUMN Empresa.emprazsoc IS 'Raz�o social da empresa.';
COMMENT ON COLUMN Empresa.empnomfan IS 'Nome fantasia da empresa.';
COMMENT ON COLUMN Empresa.emptel IS 'Telefone da empresa.';
COMMENT ON COLUMN Empresa.empema IS 'Email da empresa.';
COMMENT ON COLUMN Empresa.empramati IS 'Ramo de atividade da empresa.';
COMMENT ON COLUMN Empresa.empendrua IS 'Rua do endere�o da empresa';
COMMENT ON COLUMN Empresa.empendnum IS 'N�mero do endere�o da empresa';
COMMENT ON COLUMN Empresa.empcep IS 'CEP da empresa';

CREATE TABLE Empresa_Paciente (
  emppacid  SERIAL NOT NULL, 
  emppacfun varchar(80) NOT NULL, 
  empcnpj   numeric(14, 0) NOT NULL, 
  paccpf    numeric(11, 0) NOT NULL, 
  PRIMARY KEY (emppacid));
COMMENT ON TABLE Empresa_Paciente IS 'Tabela de liga��o entre Empresa e Paciente.';
COMMENT ON COLUMN Empresa_Paciente.emppacid IS 'C�digo de identifica��o da rela��o.';
COMMENT ON COLUMN Empresa_Paciente.emppacfun IS 'Fun��o desempenhada pelo paciente dentro empresa.';

CREATE TABLE Orientacao (
  oricid SERIAL NOT NULL, 
  orides varchar(255) NOT NULL, 
  PRIMARY KEY (oricid));
COMMENT ON COLUMN Orientacao.oricid IS 'C�digo de identifica��o da orienta��o.';
COMMENT ON COLUMN Orientacao.orides IS 'Descri��o da orienta��o.';

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
COMMENT ON COLUMN Paciente.pacendrua IS 'Rua do endere�o do paciente';
COMMENT ON COLUMN Paciente.pacendnum IS 'N�mero do endere�o do paciente';
COMMENT ON COLUMN Paciente.paccep IS 'CEP do paciente';
COMMENT ON COLUMN Paciente.pacpos IS 'Situa��o da contamina��o do paciente, se em algum momento j� foi reagente.';

CREATE TABLE Sintoma (
  sinid  SERIAL NOT NULL, 
  sindes varchar(80) NOT NULL UNIQUE, 
  CONSTRAINT Sintoma 
    PRIMARY KEY (sinid));
COMMENT ON TABLE Sintoma IS 'Cadastro do tipo do sintoma.';
COMMENT ON COLUMN Sintoma.sinid IS 'C�digo de identifica��o do tipo do sintoma.';
COMMENT ON COLUMN Sintoma.sindes IS 'Descri��o do sintoma.';

CREATE TABLE Sintoma_Paciente (
  sintipid     SERIAL NOT NULL, 
  sinpacdatini date NOT NULL, 
  sinpacgraint varchar(50) NOT NULL CHECK(sinpacgraint in ('P','M','C')), 
  sinpacdatfim date, 
  paccpf       numeric(11, 0) NOT NULL, 
  sinid        int4 NOT NULL, 
  PRIMARY KEY (sintipid));
COMMENT ON COLUMN Sintoma_Paciente.sintipid IS 'C�digo de identifica��o dos sintomas.';
COMMENT ON COLUMN Sintoma_Paciente.sinpacdatini IS 'Data do in�cio do(s) sintoma(s).';
COMMENT ON COLUMN Sintoma_Paciente.sinpacgraint IS 'Grau de intensidade dos sintomas (P - Pouco, M - Moderado, C - Constante)';
COMMENT ON COLUMN Sintoma_Paciente.sinpacdatfim IS 'Data do fim do(s) sintoma(s).';
COMMENT ON COLUMN Sintoma_Paciente.paccpf IS 'CPF do paciente.';

CREATE TABLE Situacao (
  sitid  SERIAL NOT NULL, 
  sitpac varchar(20) NOT NULL UNIQUE, 
  PRIMARY KEY (sitid));
COMMENT ON TABLE Situacao IS 'Cadastro da situa��o.';
COMMENT ON COLUMN Situacao.sitid IS 'C�digo de identifica��o da situa��o do paciente.';
COMMENT ON COLUMN Situacao.sitpac IS 'Situa��o do paciente. (Em isolamento, Recuperado, Em leito hospitalar, Tratamento na UTI, N�o reagente)';

CREATE TABLE Situacao_Paciente (
  sitpacid SERIAL NOT NULL, 
  sitid    int4 NOT NULL, 
  paccpf   numeric(11, 0) NOT NULL, 
  PRIMARY KEY (sitpacid));
COMMENT ON TABLE Situacao_Paciente IS 'Tabela de liga��o entre Situacao e Paciente';
COMMENT ON COLUMN Situacao_Paciente.sitpacid IS 'C�digo de identifca��o';

CREATE TABLE Tipo_Usuario (
  tipusuid  SERIAL NOT NULL, 
  tipusudes varchar(15) NOT NULL UNIQUE, 
  paccpf    numeric(11, 0) NOT NULL, 
  empcnpj   numeric(14, 0) NOT NULL, 
  PRIMARY KEY (tipusuid));
COMMENT ON COLUMN Tipo_Usuario.tipusuid IS 'C�digo identificador do tipo do usu�rio.';
COMMENT ON COLUMN Tipo_Usuario.tipusudes IS 'Descri��o do tipo de usu�rio.';

CREATE TABLE Unidade_Federativa (
  ufid     SERIAL NOT NULL, 
  ufsignom varchar(2) NOT NULL UNIQUE, 
  PRIMARY KEY (ufid));
COMMENT ON TABLE Unidade_Federativa IS 'Cadastro da Unidade Federativa.';
COMMENT ON COLUMN Unidade_Federativa.ufid IS 'C�digo de identifica��o da Unidade Federativa';
COMMENT ON COLUMN Unidade_Federativa.ufsignom IS 'Sigla do nome da Unidade Federativa.';

CREATE TABLE Vacina (
  vacid  SERIAL NOT NULL, 
  vacnom varchar(100) NOT NULL, 
  PRIMARY KEY (vacid));
COMMENT ON COLUMN Vacina.vacnom IS 'Nome da vacina do laborat�rio';

CREATE TABLE Vacina_Paciente (
  vacpacid SERIAL NOT NULL, 
  vacdos   numeric(1, 0) NOT NULL, 
  vacid    int4 NOT NULL, 
  paccpf   numeric(11, 0) NOT NULL, 
  PRIMARY KEY (vacpacid));
 
COMMENT ON TABLE Vacina_Paciente IS 'Tabela de liga��o entre Paciente e Vacina.';
COMMENT ON COLUMN Vacina_Paciente.vacpacid IS 'C�digo de identifica��o.';
COMMENT ON COLUMN Vacina_Paciente.vacdos IS 'Doses da vacina que o paciente tomou.';

ALTER TABLE Cidade ADD CONSTRAINT FKCidade208106 FOREIGN KEY (ufid) REFERENCES Unidade_Federativa (ufid);
ALTER TABLE Empresa ADD CONSTRAINT FKEmpresa871276 FOREIGN KEY (baiid) REFERENCES Bairro (baiid);
ALTER TABLE Paciente ADD CONSTRAINT FKPaciente832639 FOREIGN KEY (baiid) REFERENCES Bairro (baiid);
ALTER TABLE Paciente ADD CONSTRAINT FKPaciente666930 FOREIGN KEY (cidid) REFERENCES Cidade (cidid);
ALTER TABLE Empresa ADD CONSTRAINT FKEmpresa705567 FOREIGN KEY (cidid) REFERENCES Cidade (cidid);
ALTER TABLE Sintoma_Paciente ADD CONSTRAINT FKSintoma_Pa94459 FOREIGN KEY (paccpf) REFERENCES Paciente (paccpf);
ALTER TABLE Sintoma_Paciente ADD CONSTRAINT FKSintoma_Pa429408 FOREIGN KEY (sinid) REFERENCES Sintoma (sinid);
--erro ao gerar
ALTER TABLE Vacina_Paciente ADD CONSTRAINT FKVacina_Pac537939 FOREIGN KEY (vacid) REFERENCES Vacina (vacid);
ALTER TABLE Vacina_Paciente ADD CONSTRAINT FKVacina_Pac194476 FOREIGN KEY (paccpf) REFERENCES Paciente (paccpf);
ALTER TABLE Comorbidade_Paciente ADD CONSTRAINT FKComorbidad637235 FOREIGN KEY (comid) REFERENCES Comorbidade (comid);
ALTER TABLE Comorbidade_Paciente ADD CONSTRAINT FKComorbidad472115 FOREIGN KEY (paccpf) REFERENCES Paciente (paccpf);
ALTER TABLE Tipo_Usuario ADD CONSTRAINT FKTipo_Usuar136520 FOREIGN KEY (paccpf) REFERENCES Paciente (paccpf);
ALTER TABLE Tipo_Usuario ADD CONSTRAINT FKTipo_Usuar834369 FOREIGN KEY (empcnpj) REFERENCES Empresa (empcnpj);
ALTER TABLE Empresa_Paciente ADD CONSTRAINT FKEmpresa_Pa963383 FOREIGN KEY (empcnpj) REFERENCES Empresa (empcnpj);
ALTER TABLE Empresa_Paciente ADD CONSTRAINT FKEmpresa_Pa37317 FOREIGN KEY (paccpf) REFERENCES Paciente (paccpf);
ALTER TABLE Situacao_Paciente ADD CONSTRAINT FKSituacao_P977369 FOREIGN KEY (sitid) REFERENCES Situacao (sitid);
ALTER TABLE Situacao_Paciente ADD CONSTRAINT FKSituacao_P144747 FOREIGN KEY (paccpf) REFERENCES Paciente (paccpf);




--INSERT

insert INTO Comorbidade (comdes) values ('Idade igual ou superior a 60 anos');
insert INTO Comorbidade (comdes) values('Tabagismo');
insert INTO Comorbidade (comdes) values('Obesidade');
insert INTO Comorbidade (comdes) values('Miocardiopatias de diferentes etiologias');
insert INTO Comorbidade (comdes) values('Hipertens�o arterial');
insert INTO Comorbidade (comdes) values('Pneumopatias graves ou descompensados');
insert INTO Comorbidade (comdes) values('Imunodepress�o e imunossupress�o');
insert INTO Comorbidade (comdes) values('Doen�as renais cr�nicas em est�gio avan�ado (graus 3, 4 e 5)');
insert INTO Comorbidade (comdes) values('Diabetes melito, conforme ju�zo cl�nico');
insert INTO Comorbidade (comdes) values('Doen�as cromoss�micas com estado de fragilidade imunol�gica');
insert INTO Comorbidade (comdes) values('Neoplasia maligna (exceto c�ncer n�o melan�tico de pele)');
insert INTO Comorbidade (comdes) values('Algumas doen�as hematol�gicas (incluindo anemia falciforme e talassemia)');
insert INTO Comorbidade (comdes) values('Gesta��o');

alter table paciente add column usuario int8 constraint usuario_paciente_fk references app_user(id);
alter table paciente alter column usuario set not null;
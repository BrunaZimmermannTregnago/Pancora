package br.edu.unoesc.springboot.pancora.dto;

import br.edu.unoesc.springboot.pancora.entities.Empresa;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class EmpresaDTO implements Serializable {
    private static final long serialVersionUID = 7595634282930721716L;
    @Setter private BigDecimal cnpj;

    @Setter private Integer cidadeId;

    @Setter private Integer bairroId;

    @Setter Integer cep;

    @Setter private String numeroEndereco;

    @Setter private String ruaEndereco;

    @Setter private String ramoAtividade;

    @Setter private String email;

    @Setter private String telefone;

    @Setter private String nomeFantasia;

    @Setter private String razaoSocial;

    public Empresa getEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setEmail(this.email);
        empresa.setCep(this.cep);
        empresa.setNomeFantasia(this.nomeFantasia);
        empresa.setNumeroEndereco(this.numeroEndereco);
        empresa.setRamoAtividade(this.ramoAtividade);
        empresa.setRuaEndereco(this.ruaEndereco);
        empresa.setRazaoSocial(this.razaoSocial);
        empresa.setTelefone(this.telefone);
        empresa.setCnpj(this.cnpj);
        return empresa;
    }
}
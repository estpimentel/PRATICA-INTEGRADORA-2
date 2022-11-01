package br.com.dh.crudSimples.dto;
// AQUI ENTRAM APENAS OS CAMPOS QUE EU QUERO QUE MEU USUÁRIO TENHA ACESSO
import br.com.dh.crudSimples.model.Pessoa;
import lombok.Data;

@Data
public class PessoaDTO {
    private String nome;
    private String idade;

    public PessoaDTO(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.idade = pessoa.getIdade();
    }
}

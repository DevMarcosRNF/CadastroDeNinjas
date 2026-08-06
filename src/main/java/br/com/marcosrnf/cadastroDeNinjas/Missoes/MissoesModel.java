package br.com.marcosrnf.cadastroDeNinjas.Missoes;

import br.com.marcosrnf.cadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    // OneToMany - UMA missão pode ter MUITOS ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;
}

package br.com.marcosrnf.cadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDto){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDto.getId());
        ninjaModel.setNome(ninjaDto.getNome());
        ninjaModel.setIdade(ninjaDto.getIdade());
        ninjaModel.setImgUrl(ninjaDto.getImgUrl());
        ninjaModel.setEmail(ninjaDto.getEmail());
        ninjaModel.setRank(ninjaDto.getRank());
        ninjaModel.setMissoes(ninjaDto.getMissoes());
        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDto = new NinjaDTO();
        ninjaDto.setId(ninjaModel.getId());
        ninjaDto.setNome(ninjaModel.getNome());
        ninjaDto.setIdade(ninjaModel.getIdade());
        ninjaDto.setImgUrl(ninjaModel.getImgUrl());
        ninjaDto.setEmail(ninjaModel.getEmail());
        ninjaDto.setRank(ninjaModel.getRank());
        ninjaDto.setMissoes(ninjaModel.getMissoes());
        return ninjaDto;
    }
}

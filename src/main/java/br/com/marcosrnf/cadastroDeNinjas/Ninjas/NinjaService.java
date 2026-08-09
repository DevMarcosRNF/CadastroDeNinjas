package br.com.marcosrnf.cadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    public NinjaModel listarNinjaPorId(Long id){
        Optional<NinjaModel> opt = ninjaRepository.findById(id);
        return opt.orElse(null);
    }

    public NinjaModel editarNinja(NinjaModel ninja, Long id){
//        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
//        if(ninjaModel.isPresent()){
//            NinjaModel ninjaAtualizado = new NinjaModel();
//            ninjaAtualizado.setId(id);
//            ninjaAtualizado.setNome(ninja.getNome());
//            ninjaAtualizado.setEmail(ninja.getEmail());
//            ninjaAtualizado.setIdade(ninja.getIdade());
//            ninjaAtualizado.setImgUrl(ninja.getImgUrl());
//            ninjaAtualizado.setMissoes(ninja.getMissoes());
//            return ninjaRepository.save(ninjaAtualizado);
//        }
        if(ninjaRepository.existsById(id)){
            ninja.setId(id);
            ninjaRepository.save(ninja);
        }
        return null;
    }

    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }
}

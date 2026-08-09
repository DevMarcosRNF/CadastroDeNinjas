package br.com.marcosrnf.cadastroDeNinjas.Ninjas;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDto){
        NinjaModel ninja = ninjaMapper.map(ninjaDto);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjaModel = ninjaRepository.findAll();
        return ninjaModel.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO listarNinjaPorId(Long id){
        Optional<NinjaModel> opt = ninjaRepository.findById(id);
        if(opt.isPresent()){
            return ninjaMapper.map(opt.get());
        }
        return null;
    }

    public NinjaDTO editarNinja(NinjaDTO ninjaDto, Long id){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        if(ninjaModel.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDto);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }
}

package com.example.demo.service;

import com.example.demo.controller.dto.HospitalDTO;
import com.example.demo.controller.mapper.HospitalMapper;
import com.example.demo.domain.Hospital;
import com.example.demo.repository.HospitalRepository;
import com.example.demo.repository.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class HospitalService {
    private final HospitalMapper hospitalMapper;
    private final HospitalRepository hospitalRepository;
    private final UsuariosRepository usuariosRepository;

    public HospitalService(HospitalRepository hospitalRepository, UsuariosRepository usuariosRepository) {
        this.hospitalRepository = hospitalRepository;
        this.hospitalMapper = new HospitalMapper();
        this.usuariosRepository = usuariosRepository;
    }

    public void createHospital(HospitalDTO hospitalDTO) {
        Hospital newHospital = hospitalMapper.hospitalDTOtoHospital(hospitalDTO);
        newHospital.setUsuario(
                usuariosRepository.findUsuarioByIdentificacion(newHospital.getId())
        );
        hospitalRepository.save(newHospital);
    }

    public List<HospitalDTO> getListHospitals() {
        return hospitalMapper.hospitalesToHospitalesDTO(hospitalRepository.findAll());
    }
}

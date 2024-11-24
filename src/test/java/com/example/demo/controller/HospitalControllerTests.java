package com.example.demo.controller;

import com.example.demo.config.Authorities;
import com.example.demo.controller.dto.HospitalDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.demo.config.Authorities.HOSPITAL;
import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HospitalControllerTests {
    @Autowired
    TestRestTemplate testRestTemplate;
    private static final String url = "/hospital";

    @Test
    @DisplayName("Should create an Hospital and return OK")
    void createHospital() {
        HospitalDTO hospitalDTO = new HospitalDTO();
        hospitalDTO.setId("1");
        hospitalDTO.setNombre("Hospital test");
        hospitalDTO.setDireccion("Direccion test");
        hospitalDTO.setServiciosMedicos("Servicios Medicos test");
    }
}

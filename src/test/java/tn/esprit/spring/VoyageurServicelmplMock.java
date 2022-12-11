package tn.esprit.spring.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.repository.VoyageurRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class VoyageurServicelmplMock {

    @Mock
    VoyageurRepository voyageurRepository;
    @InjectMocks
    VoyageurServiceImpl StI;

    Voyageur voyageur = new Voyageur("libelleVoyageur1", 10, 3);
    List<Voyageur> listVoyageurs = new ArrayList<Voyageur>() {
        {
            add(new Voyageur("libelleVoyageur2", 20, 5));
            add(new Voyageur("libelleVoyageur3", 30, 8));
        }
    };


    @Test
    void recupererVoyageParId() {
        Mockito.when(voyageurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(voyageur));
        Voyageur voyageur1 = StI.recupererVoyageParId(0L);
        Assertions.assertNotNull(voyageur1);
    }

    @Test
    void recupererAll() {
        Mockito.when(voyageurRepository.findAll()).thenReturn(listVoyageurs);
        List<Voyageur> list = StI.recupererAll();
        Assertions.assertNotNull(list);
    }
}

package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final AttractionRepository attractionRepository;
    private final ThrillRepository thrillRepository;
    private final TypeRepository typeRepository;
    private final ZoneRepository zoneRepository;

    public DataLoader(AttractionRepository attractionRepository,
                      ThrillRepository thrillRepository,
                      TypeRepository typeRepository,
                      ZoneRepository zoneRepository) {
        this.attractionRepository = attractionRepository;
        this.thrillRepository = thrillRepository;
        this.typeRepository = typeRepository;
        this.zoneRepository = zoneRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Insertar datos en la base de datos

        // Crear Zonas
        Zone zone1 = new Zone("Fantasy Land");
        Zone zone2 = new Zone("Adventure World");
        zoneRepository.saveAll(List.of(zone1, zone2));

        // Crear Intensidades (Thrill)
        Thrill thrill1 = new Thrill("Alta");
        Thrill thrill2 = new Thrill("Media");
        Thrill thrill3 = new Thrill("Baja");
        thrillRepository.saveAll(List.of(thrill1, thrill2, thrill3));

        // Crear Tipos de Atracción
        Type type1 = new Type("Montaña Rusa");
        Type type2 = new Type("Carrusel");
        Type type3 = new Type("Torre de caída");
        typeRepository.saveAll(List.of(type1, type2, type3));

        // Crear Atracciones
        Attraction attraction1 = new Attraction();
        attraction1.setName("Dragon Coaster");
        attraction1.setDescription("Una montaña rusa extrema con giros de 360°.");
        attraction1.setHeight(30.5);
        attraction1.setDuration(120);
        attraction1.setSpeed(100.0);
        attraction1.setMinHeight(140);
        attraction1.setImageUrl1("dragon1.jpg");
        attraction1.setImageUrl2("dragon2.jpg");
        attraction1.setImageUrl3("dragon3.jpg");
        attraction1.setVideoUrl("dragon.mp4");
        attraction1.setZone(zone1);
        attraction1.setIntensity(thrill1);
        attraction1.setType(type1);

        Attraction attraction2 = new Attraction();
        attraction2.setName("Magic Carousel");
        attraction2.setDescription("Un carrusel encantado para todas las edades.");
        attraction2.setHeight(5.0);
        attraction2.setDuration(180);
        attraction2.setSpeed(5.0);
        attraction2.setMinHeight(0);
        attraction2.setImageUrl1("carousel1.jpg");
        attraction2.setImageUrl2("carousel2.jpg");
        attraction2.setImageUrl3("carousel3.jpg");
        attraction2.setVideoUrl("carousel.mp4");
        attraction2.setZone(zone2);
        attraction2.setIntensity(thrill3);
        attraction2.setType(type2);

        // Guardar Atracciones en la base de datos
        attractionRepository.saveAll(List.of(attraction1, attraction2));

        System.out.println("✅ Datos insertados correctamente en la base de datos.");
    }
}

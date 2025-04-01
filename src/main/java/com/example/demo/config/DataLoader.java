package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import com.example.demo.repository.AttractionRepository;
import com.example.demo.repository.ThrillRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.repository.TypeRepository;
import com.example.demo.entity.Zone;
import com.example.demo.entity.Attraction;
import com.example.demo.entity.Thrill;
import com.example.demo.entity.Type;

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
        System.out.println("Insertando zonas de prueba...");
        Zone zone1 = new Zone("FRONTIER TOWN");
        Zone zone2 = new Zone("CAMP SNOOPY");
        Zone zone3 = new Zone("GEMINI MIDWAY");
        Zone zone4 = new Zone("FRONTIER TRAIL");
        Zone zone5 = new Zone("MILLENNIUM MIDWAY");
        Zone zone6 = new Zone("MAIN MIDWAY");
        Zone zone7 = new Zone("PLANET SNOOPY™");
        Zone zone8 = new Zone("KIDDY KINGDOM");
        Zone zone9 = new Zone("BOARDWALK");

        zoneRepository.saveAll(List.of(zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9));
        System.out.println("Zonas insertadas correctamente.");

        // Crear Intensidades (Thrill)
        System.out.println("Insertando niveles de intensidad...");
        Thrill thrill1 = new Thrill("Low");
        Thrill thrill2 = new Thrill("Moderate");
        Thrill thrill3 = new Thrill("Aggressive");
        Thrill thrill4 = new Thrill("Mild");
        Thrill thrill5 = new Thrill("High");

        thrillRepository.saveAll(List.of(thrill1, thrill2, thrill3, thrill4, thrill5));
        System.out.println("Intensidades insertadas correctamente.");

        // Crear Tipos de Atracción
        System.out.println("Insertando tipos de atracciones...");
        Type type1 = new Type("Roller coasters");
        Type type2 = new Type("Thrill rides");
        Type type3 = new Type("Family rides");
        Type type4 = new Type("Water Ride");
        Type type5 = new Type("Children rides");

        typeRepository.saveAll(List.of(type1, type2, type3, type4, type5));
        System.out.println("Tipos de atracciones insertados correctamente.");

        // Crear Atracciones
        Attraction attraction1 = new Attraction();
        attraction1.setName("BlueStreak");
        attraction1.setDescription("Una montaña rusa de madera clásica y la más antigua en funcionamiento en Cedar Point. Ofrece un recorrido de 1 minuto y 30 segundos con una altura de 78 pies y una velocidad de hasta 40 mph. Su diseño tradicional de ida y vuelta proporciona múltiples colinas y una emocionante experiencia de airtime");
        attraction1.setHeight(78.0);
        attraction1.setDuration(90);
        attraction1.setSpeed(40.0);
        attraction1.setMinHeight(48);
        attraction1.setImageUrl1("bluestreak1.png");
        attraction1.setImageUrl2("bluestreak2.jng");
        attraction1.setImageUrl3("bluestreak3.jpeg");
        attraction1.setVideoUrl("https://www.youtube.com/embed/t5aeLbY4bE8?si=G7qcOJd7ATmSEPcr");
        attraction1.setZone(zone6);
        attraction1.setIntensity(thrill1);
        attraction1.setType(type1);
        attraction1.setLine(40); // Tiempo de espera en minutos
        


        // Guardar Atracciones en la base de datos
        attractionRepository.saveAll(List.of(attraction1));

        System.out.println("✅ Datos insertados correctamente en la base de datos.");
    }
}

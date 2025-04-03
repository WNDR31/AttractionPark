package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import com.example.demo.repository.AttractionRepository;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.ThrillRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.repository.TypeRepository;
import com.example.demo.entity.Zone;
import com.example.demo.entity.Attraction;
import com.example.demo.entity.Hotel;
import com.example.demo.entity.Thrill;
import com.example.demo.entity.Type;

@Component
public class DataLoader implements CommandLineRunner {

    private final AttractionRepository attractionRepository;
    private final ThrillRepository thrillRepository;
    private final TypeRepository typeRepository;
    private final ZoneRepository zoneRepository;
    private final HotelRepository hotelRepository;
    

    public DataLoader(AttractionRepository attractionRepository,
                      ThrillRepository thrillRepository,
                      TypeRepository typeRepository,
                      ZoneRepository zoneRepository,
                      HotelRepository hotelRepository) {
        this.attractionRepository = attractionRepository;
        this.thrillRepository = thrillRepository;
        this.typeRepository = typeRepository;
        this.zoneRepository = zoneRepository;
        this.hotelRepository = hotelRepository;
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
        Zone zone9 = new Zone("LAKESIDE MIDWAY");

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
        Type type1 = new Type("Roller coasters"); // line = 40
        Type type2 = new Type("Thrill rides"); // line = 30
        Type type3 = new Type("Family rides"); // line = 20
        Type type4 = new Type("Water Ride"); // line = 20
        Type type5 = new Type("Children rides"); // line = 10

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
        attraction1.setIntensity(thrill4);
        attraction1.setType(type1);
        attraction1.setLine(40); // Tiempo de espera en minutos

        Attraction attraction2 = new Attraction();
        attraction2.setName("Power tower");
        attraction2.setDescription("Power Tower es una atracción de lanzamiento y caída de 240 pies, donde los pasajeros experimentan velocidades de hasta 60 mph y eligen la dirección en que serán lanzados.");
        attraction2.setHeight(240.0); //foot 
        attraction2.setDuration(90); //seconds 
        attraction2.setSpeed(60.0); //mph 
        attraction2.setMinHeight(48);
        attraction2.setImageUrl1("PowerTower.jpg");
        attraction2.setImageUrl2("powertower2.jpg");
        attraction2.setImageUrl3("powertower3.jpg");
        attraction2.setVideoUrl("https://youtu.be/OyOEWslMzhA?si=Ed1TmC5YAYlPw3jq");
        attraction2.setZone(zone3); 
        attraction2.setIntensity(thrill5);
        attraction2.setType(type2);
        attraction2.setLine(30); // Tiempo de espera en minutos
        
        Attraction attraction3 = new Attraction();
        attraction3.setName("Raptor");
        attraction3.setDescription("Raptor es una montaña rusa invertida de acero que ofrece una experiencia intensa y emocionante con cuatro inversiones. Con una altura de 137 pies y una velocidad de 57 mph, este recorrido desafiante pone a los pasajeros boca abajo mientras atraviesan curvas rápidas y caídas vertiginosas.");
        attraction3.setHeight(137.0);
        attraction3.setDuration(135);  
        attraction3.setSpeed(57.0);
        attraction3.setMinHeight(54);
        attraction3.setImageUrl1("raptor1.jpg");
        attraction3.setImageUrl2("raptor2.JPG");
        attraction3.setImageUrl3("raptor3.JPG");
        attraction3.setVideoUrl("https://youtu.be/Tb2H-8CQuyY?si=340I_YGX4QFqddXv");
        attraction3.setZone(zone6);  
        attraction3.setIntensity(thrill5); 
        attraction3.setType(type1);  
        attraction3.setLine(40);


        Attraction attraction4 = new Attraction();
        attraction4.setName("Atomic Scrambler");
        attraction4.setDescription("Atomic Scrambler es una atracción que te hace girar en todas direcciones, creando un caos de giros y fuerzas centrífugas mientras disfrutas de un espectáculo de colores.");
        attraction4.setHeight(240.0); //foot 
        attraction4.setDuration(90); //seconds 
        attraction4.setSpeed(60.0); //mph 
        attraction4.setMinHeight(38);
        attraction4.setImageUrl1("atomicscrambler1.jpg");
        attraction4.setImageUrl2("atomicscrambler2.jpeg");
        attraction4.setImageUrl3("atomicscrambler3.jpg");
        attraction4.setVideoUrl("https://youtu.be/La4Hx-kJNeE?si=QGcvvBAouoJ_CO7o");
        attraction4.setZone(zone6); 
        attraction4.setIntensity(thrill3);
        attraction4.setType(type2);
        attraction4.setLine(30); // Tiempo de espera en minutos

        Attraction attraction5 = new Attraction();
        attraction5.setName("Monster");
        attraction5.setDescription("Monster es una atracción con tentáculos giratorios que lanzan a los pasajeros en giros independientes, inclinándose y sacudiéndolos mientras experimentan sensaciones de ingravidez y emoción.");
        attraction5.setHeight(0.0); //foot 
        attraction5.setDuration(120); //seconds 
        attraction5.setSpeed(20.0); //mph 
        attraction5.setMinHeight(46);
        attraction5.setImageUrl1("monster1.jpg");
        attraction5.setImageUrl2("monster2.jpg");
        attraction5.setImageUrl3("monster3.jpg");
        attraction5.setVideoUrl("https://youtu.be/HzpwhBFcaGo?si=O1U9XcT78zP_gv7s");
        attraction5.setZone(zone3); 
        attraction5.setIntensity(thrill2);
        attraction5.setType(type3);
        attraction5.setLine(20); // Tiempo de espera en minutos

        Attraction attraction6 = new Attraction();
        attraction6.setName("Thunder Canyon");
        attraction6.setDescription("Thunder Canyon es un paseo en balsa por rápidos impredecibles, llenos de olas, cascadas y giros que aseguran mojar a todos los pasajeros.");
        attraction6.setHeight(0.0); //foot 
        attraction6.setDuration(180); //seconds 
        attraction6.setSpeed(15.0); //mph 
        attraction6.setMinHeight(46);
        attraction6.setImageUrl1("thundercanyon1.jpg");
        attraction6.setImageUrl2("thundercanyon2.jpg");
        attraction6.setImageUrl3("thundercanyon3.jpg");
        attraction6.setVideoUrl("https://youtu.be/6xh3k36HBq8?si=AGGIoL1NMQbTmNX_");
        attraction6.setZone(zone4); 
        attraction6.setIntensity(thrill1);
        attraction6.setType(type4);
        attraction6.setLine(20); // Tiempo de espera en minutos

        Attraction attraction7 = new Attraction();
        attraction7.setName("Snoopy's Express Railroad");
        attraction7.setDescription("Snoopy’s Express Railroad es un tren que recorre Planet Snoopy, ofreciendo una experiencia relajante y divertida para toda la familia, mientras observas el parque y planificas las atracciones por venir.");
        attraction7.setHeight(0.0); //foot 
        attraction7.setDuration(120); //seconds 
        attraction7.setSpeed(5.0); //mph 
        attraction7.setMinHeight(36);
        attraction7.setImageUrl1("snoopyexpress1.jpg");
        attraction7.setImageUrl2("snoopyexpress2.jpg");
        attraction7.setImageUrl3("snoopyexpress3.jpg");
        attraction7.setVideoUrl("https://youtu.be/y6U8Gl0X8Ds?si=eaTuX3N57ai6n1oF");
        attraction7.setZone(zone7); 
        attraction7.setIntensity(thrill1);
        attraction7.setType(type3);
        attraction7.setLine(20); // Tiempo de espera en minutos

        Attraction attraction8 = new Attraction();
        attraction8.setName("Valravn");
        attraction8.setDescription("Valravn es una montaña rusa de acero que abrió como la más alta, rápida y larga del mundo dentro de la categoría Dive Coaster. Con 223 pies de altura y una velocidad de 75 mph, Valravn desafía a los pasajeros con un emocionante descenso vertical de 90 grados y giros espectaculares, lo que la convierte en una de las mejores atracciones de Cedar Point.");
        attraction8.setHeight(223.0); // feet
        attraction8.setDuration(143); // seconds 
        attraction8.setSpeed(75.0); // mph
        attraction8.setMinHeight(54);
        attraction8.setImageUrl1("valravn1.jpg");
        attraction8.setImageUrl2("valravn2.jpg");
        attraction8.setImageUrl3("valravn3.jpg");
        attraction8.setVideoUrl("https://youtu.be/1b1rvkktEv0");
        attraction8.setZone(zone6); // MAIN MIDWAY
        attraction8.setIntensity(thrill3); // Aggressive (asumiendo que thrill3 es "Aggressive")
        attraction8.setType(type1); // Roller coasters
        attraction8.setLine(40); // Tiempo de espera en minutos (para Roller coasters)
        
        Attraction attraction9 = new Attraction();
        attraction9.setName("Snoopy's Deep Sea Divers");
        attraction9.setDescription("Paseo de péndulo donde la familia disfruta de un submarino amarillo que sube al cielo, ofreciendo vistas espectaculares de Planet Snoopy.");
        attraction9.setHeight(0.0); //foot 
        attraction9.setDuration(120); //seconds 
        attraction9.setSpeed(10.0); //mph 
        attraction9.setMinHeight(36);
        attraction9.setImageUrl1("snoopydeep1.jpg");
        attraction9.setImageUrl2("snoopydeep2.jpg");
        attraction9.setImageUrl3("snoopydeep3.jpg");
        attraction9.setVideoUrl("https://youtu.be/YuHJgrh9Qpo?si=1oTUAi6X19t0Jw7l");
        attraction9.setZone(zone7); 
        attraction9.setIntensity(thrill1);
        attraction9.setType(type3);
        attraction9.setLine(20); // Tiempo de espera en minutos

        Attraction attraction10 = new Attraction();
        attraction10.setName("GateKeeper");
        attraction10.setDescription("GateKeeper es una montaña rusa de acero con un diseño de inversiones y una caída impresionante. Con una altura de 170 pies y una velocidad de 67 mph, esta montaña rusa ofrece una experiencia única con un par de inversores y un vuelo inverso mientras los pasajeros cruzan por encima de la entrada del parque.");
        attraction10.setHeight(170.0); // feet
        attraction10.setDuration(120); // seconds (67 minutos)
        attraction10.setSpeed(67.0); // mph
        attraction10.setMinHeight(54);
        attraction10.setImageUrl1("gatekeeper1.jpg");
        attraction10.setImageUrl2("gatekeeper2.jpg");
        attraction10.setImageUrl3("gatekeeper3.jpg");
        attraction10.setVideoUrl("https://youtu.be/pkOqi7Du3Og?si=M0Z4xJ8VzZ9WMDU7");
        attraction10.setZone(zone9); 
        attraction10.setIntensity(thrill5); 
        attraction10.setType(type1); 
        attraction10.setLine(40); 

        Attraction attraction11 = new Attraction();
        attraction11.setName("Giant Wheel");
        attraction11.setDescription("Giant Wheel es una rueda de observación de 136 pies (41.5 m) de altura, que ofrece impresionantes vistas panorámicas del parque y el lago Erie. Abierta desde 1972, esta atracción es un clásico de Cedar Point.");
        attraction11.setHeight(136.0); // feet
        attraction11.setDuration(220);
        attraction11.setSpeed(0.3); // No tiene velocidad significativa
        attraction11.setMinHeight(48);
        attraction11.setImageUrl1("giantwheel1.jpg");
        attraction11.setImageUrl2("giantwheel2.webp");
        attraction11.setImageUrl3("giantwheel3.jpeg");
        attraction11.setVideoUrl("https://youtu.be/rIRnP7OwyMU?si=sDcFNdQPQGk67afR");
        attraction11.setZone(zone9); 
        attraction11.setIntensity(thrill3); 
        attraction11.setType(type3); 
        attraction11.setLine(20); 

        Attraction attraction12 = new Attraction();
        attraction12.setName("Corkscrew");
        attraction12.setDescription("Corkscrew es una montaña rusa de acero icónica que fue la primera en el mundo en contar con tres inversiones. Desde su apertura en 1976, ha desafiado a los visitantes con su característico bucle y dos giros en sacacorchos sobre la pasarela del parque. Con una velocidad de 48 mph y una longitud de 2,050 pies, ofrece una experiencia intensa de giros y cambios de dirección que desafían la gravedad.");
        attraction12.setHeight(85.0);
        attraction12.setDuration(120);
        attraction12.setSpeed(48.0);
        attraction12.setMinHeight(48);
        attraction12.setImageUrl1("corkscrew1.jpg");
        attraction12.setImageUrl2("corkscrew2.jpg");
        attraction12.setImageUrl3("corkscrew3.jpeg");
        attraction12.setVideoUrl("https://youtu.be/tBkTuaL--30?si=hZOa6Wa69vUbFSJy");
        attraction12.setZone(zone3); 
        attraction12.setIntensity(thrill5); 
        attraction12.setType(type1); 
        attraction12.setLine(40);

        // Atracción 13 - Gemini
        Attraction attraction13 = new Attraction();
        attraction13.setName("Gemini");
        attraction13.setDescription("Gemini es una montaña rusa de madera y acero que ofrece una experiencia de carreras entre dos trenes. Con una altura de 125 pies y una velocidad de hasta 60 mph, este icónico recorrido de doble vía ha sido uno de los favoritos de los visitantes de Cedar Point desde su apertura en 1978.");
        attraction13.setHeight(125.0);
        attraction13.setDuration(150);
        attraction13.setSpeed(60.0);
        attraction13.setMinHeight(54);
        attraction13.setImageUrl1("gemini1.jpg");
        attraction13.setImageUrl2("gemini2.jpeg");
        attraction13.setImageUrl3("gemini3.jpeg");
        attraction13.setVideoUrl("https://youtu.be/O5anQIKQgAo?si=htfH5lptIHpVdoxe");
        attraction13.setZone(zone3); 
        attraction13.setIntensity(thrill5); 
        attraction13.setType(type1); 
        attraction13.setLine(40);
            
        // Atracción 14 - Magnum XL-200
        Attraction attraction14 = new Attraction();
        attraction14.setName("Magnum XL-200");
        attraction14.setDescription("Magnum XL-200 es una montaña rusa de acero que ofrece una experiencia impresionante con caídas de hasta 200 pies de altura y una velocidad de 72 mph. Fue la primera montaña rusa en superar los 200 pies, y sigue siendo una de las más emocionantes en Cedar Point, destacando por sus impresionantes caídas y airtime.");
        attraction14.setHeight(205.0);
        attraction14.setDuration(180); // 3 minutos = 180 segundos
        attraction14.setSpeed(72.0);
        attraction14.setMinHeight(54);
        attraction14.setImageUrl1("magnum1.jpg");
        attraction14.setImageUrl2("magnum2.png");
        attraction14.setImageUrl3("magnum3.jpg");
        attraction14.setVideoUrl("https://youtu.be/3x3fIh72rfw?si=AJpss0QOIi05Y2Tm");
        attraction14.setZone(zone3); 
        attraction14.setIntensity(thrill5); 
        attraction14.setType(type1); 
        attraction14.setLine(40);

        // Atracción 15 - Iron Dragon
        Attraction attraction15 = new Attraction();
        attraction15.setName("Iron Dragon");
        attraction15.setDescription("Iron Dragon es una montaña rusa suspendida que ofrece una experiencia única de vuelo, donde los pasajeros se cuelgan bajo los rieles mientras realizan giros, caídas y suaves inversiones. Con una altura de 76 pies y una velocidad de hasta 40 mph, esta atracción es conocida por su relajante pero emocionante recorrido.");
        attraction15.setHeight(76.0);
        attraction15.setDuration(120); // 2 minutos = 120 segundos
        attraction15.setSpeed(40.0);
        attraction15.setMinHeight(48);
        attraction15.setImageUrl1("irondragon1.jpg");
        attraction15.setImageUrl2("irondragon2.jpeg");
        attraction15.setImageUrl3("irondragon3.jpg");
        attraction15.setVideoUrl("https://youtu.be/2cwUMqSWSmU?si=2aioZ0oPGOzL5THv");
        attraction15.setZone(zone5); 
        attraction15.setIntensity(thrill4); 
        attraction15.setType(type1);
        attraction15.setLine(40);

        // Atracción 16 - Millennium Force
        Attraction attraction16 = new Attraction();
        attraction16.setName("Millennium Force");
        attraction16.setDescription("Millennium Force es una de las montañas rusas más rápidas y altas del mundo. Con una altura de 310 pies y una velocidad de 93 mph, esta atracción de acero ofrece un recorrido épico con impresionantes caídas y airtime, lo que la convierte en un favorito entre los aficionados a las montañas rusas.");
        attraction16.setHeight(310.0);
        attraction16.setDuration(180); // 3 minutos = 180 segundos
        attraction16.setSpeed(93.0);
        attraction16.setMinHeight(54);
        attraction16.setImageUrl1("millenniumforce1.jpg");
        attraction16.setImageUrl2("millenniumforce2.JPG");
        attraction16.setImageUrl3("millenniumforce3.jpg");
        attraction16.setVideoUrl("https://youtu.be/MybcORGVkEU?si=OkWtrWZsheO4Y5aV");
        attraction16.setZone(zone5); 
        attraction16.setIntensity(thrill5); 
        attraction16.setType(type1); 
        attraction16.setLine(40);
    

        // Atracción 17 - Rougarou
        Attraction attraction17 = new Attraction();
        attraction17.setName("Rougarou");
        attraction17.setDescription("Rougarou es una montaña rusa invertida que combina la emoción de los giros rápidos y los intensos airtime moments con un diseño único. Con una altura de 145 pies y una velocidad de 60 mph, esta atracción desafía la gravedad con sus cuatro inversiones y giros vertiginosos.");
        attraction17.setHeight(145.0);
        attraction17.setDuration(150); // 2.5 minutos = 150 segundos
        attraction17.setSpeed(60.0);
        attraction17.setMinHeight(54);
        attraction17.setImageUrl1("rougarou1.jpg");
        attraction17.setImageUrl2("rougarou2.jpg");
        attraction17.setImageUrl3("rougarou3.jpg");
        attraction17.setVideoUrl("https://youtu.be/RuweAtyeUuU?si=e67m6dxTkTo9yUNU");
        attraction17.setZone(zone5);
        attraction17.setIntensity(thrill5);
        attraction17.setType(type1); 
        attraction17.setLine(40);

        // Atracción 18 - Cedar Creek Mine Ride
        Attraction attraction18 = new Attraction();
        attraction18.setName("Cedar Creek Mine Ride");
        attraction18.setDescription("Cedar Creek Mine Ride es una montaña rusa de tren minero que transporta a los visitantes al Viejo Oeste. Con dos elevadores y múltiples giros, ofrece una experiencia emocionante a través de túneles, sobre el agua y a través de una doble hélice. Abierta en 1969, sigue siendo una atracción icónica en Frontier Town.");
        attraction18.setHeight(48.0);
        attraction18.setDuration(170); // 2.83 minutos ≈ 170 segundos
        attraction18.setSpeed(40.0);
        attraction18.setMinHeight(48);
        attraction18.setImageUrl1("creekmine1.jpg");
        attraction18.setImageUrl2("creekmine2.jpg");
        attraction18.setImageUrl3("creekmine3.JPG");
        attraction18.setVideoUrl("https://youtu.be/6x69vGPT-bw?si=FAte_xTF56Ea1JCL");
        attraction18.setZone(zone1);
        attraction18.setIntensity(thrill4);
        attraction18.setType(type1); 
        attraction18.setLine(40);

        // Atracción 19 - Maverick
        Attraction attraction19 = new Attraction();
        attraction19.setName("Maverick");
        attraction19.setDescription("Maverick es una montaña rusa de acero que combina caídas intensas, giros cerrados y una velocidad impresionante. Con una altura de 105 pies y una velocidad de hasta 70 mph, Maverick es conocida por sus rápidas transiciones y su experiencia de airtime que mantiene a los pasajeros al borde de sus asientos.");
        attraction19.setHeight(105.0);
        attraction19.setDuration(120); // 2 minutos = 120 segundos
        attraction19.setSpeed(70.0);
        attraction19.setMinHeight(54);
        attraction19.setImageUrl1("maverick1.jpg");
        attraction19.setImageUrl2("maverick2.jpg");
        attraction19.setImageUrl3("maverick3.jpg");
        attraction19.setVideoUrl("https://youtu.be/WUpQMWGVw4g?si=hiuZYnpiO3vP3R9e");
        attraction19.setZone(zone1);
        attraction19.setIntensity(thrill5); 
        attraction19.setType(type1); 
        attraction19.setLine(40);

        // Atracción 20 - Steel Vengeance
        Attraction attraction20 = new Attraction();
        attraction20.setName("Steel Vengeance");
        attraction20.setDescription("Steel Vengeance es una montaña rusa híbrida de acero que utiliza una estructura de madera que supera los 200 pies de altura, convirtiéndola en la primera hypercoaster híbrida del mundo. Con 200 pies de altura y una velocidad de 74 mph, esta montaña rusa ofrece más de 27 momentos de airtime en su recorrido.");
        attraction20.setHeight(205.0);
        attraction20.setDuration(150); // 2.5 minutos = 150 segundos
        attraction20.setSpeed(74.0);
        attraction20.setMinHeight(54);
        attraction20.setImageUrl1("steelvengeance1.jpg");
        attraction20.setImageUrl2("steelvengeance2.jpg");
        attraction20.setImageUrl3("steelvengeance3.jpg");
        attraction20.setVideoUrl("https://youtu.be/RTXTbzctl0c");
        attraction20.setZone(zone1); 
        attraction20.setIntensity(thrill5);
        attraction20.setType(type1); 
        attraction20.setLine(40);

        // Atracción 21 - Woodstock Express
        Attraction attraction21 = new Attraction();
        attraction21.setName("Woodstock Express");
        attraction21.setDescription("Woodstock Express es una montaña rusa infantil de acero fabricada por Vekoma, ubicada en Camp Snoopy. Esta atracción tiene un diseño de montaña rusa tradicional para niños, con un recorrido suave y fácil, perfecto para aquellos que se inician en el mundo de las montañas rusas.");
        attraction21.setHeight(35.0);
        attraction21.setDuration(90); // 1.5 minutos = 90 segundos
        attraction21.setSpeed(25.0);
        attraction21.setMinHeight(36);
        attraction21.setImageUrl1("woodstockexpress1.jpg");
        attraction21.setImageUrl2("woodstockexpress2.jpg");
        attraction21.setImageUrl3("woodstockexpress3.jpg");
        attraction21.setVideoUrl("https://youtu.be/fDBydpPplzQ?si=QxJ48zc16mTTxy3G");
        attraction21.setZone(zone2); 
        attraction21.setIntensity(thrill4);
        attraction21.setType(type5); 
        attraction21.setLine(10); 

        // Atracción 22 - Wilderness Run
        Attraction attraction22 = new Attraction();
        attraction22.setName("Wilderness Run");
        attraction22.setDescription("Wilderness Run es una montaña rusa de acero diseñada especialmente para niños, anteriormente conocida como Jr. Gemini. Fue la primera montaña rusa fabricada por Intamin, y fue renombrada a Wilderness Run en 2014. Con una altura de 25 pies y una velocidad de 20 mph, es ideal para los más pequeños que están listos para su primera experiencia en montaña rusa.");
        attraction22.setHeight(25.0);
        attraction22.setDuration(90); // 1.5 minutos = 90 segundos
        attraction22.setSpeed(20.0);
        attraction22.setMinHeight(36);
        attraction22.setImageUrl1("wildernessrun1.jpg");
        attraction22.setImageUrl2("wildernessrun2.jpg");
        attraction22.setImageUrl3("wildernessrun3.jpg");
        attraction22.setVideoUrl("https://youtu.be/gkVt5uryylQ");
        attraction22.setZone(zone2); 
        attraction22.setIntensity(thrill2); 
        attraction22.setType(type5);
        attraction22.setLine(10);

        // Atracción 23 - Kiddy Kingdom Carousel
        Attraction attraction23 = new Attraction();
        attraction23.setName("Kiddy Kingdom Carousel");
        attraction23.setDescription("Kiddy Kingdom Carousel es un carrusel tradicional con animales y vehículos para montar. Es una atracción clásica de la zona, ideal para los más pequeños.");
        attraction23.setHeight(0.0);
        attraction23.setDuration(180); // 3 minutos = 180 segundos
        attraction23.setSpeed(0.0);
        attraction23.setMinHeight(36);
        attraction23.setImageUrl1("kiddiecarousel1.jpg");
        attraction23.setImageUrl2("kiddiecarousel2.jpg");
        attraction23.setImageUrl3("kiddiecarousel3.jpg");
        attraction23.setVideoUrl("https://youtu.be/YyUm5gO4eTg?si=isdcgLlTV_U_bLJN");
        attraction23.setZone(zone8); 
        attraction23.setIntensity(thrill1); // Low
        attraction23.setType(type5); 
        attraction23.setLine(10); // Tiempo de espera reducido para atracciones infantiles

        // Atracción 24 - Roto Whip
        Attraction attraction24 = new Attraction();
        attraction24.setName("Roto Whip");
        attraction24.setDescription("Roto Whip es un paseo giratorio en el que los niños se suben a carritos que giran rápidamente, ofreciendo un recorrido más dinámico y emocionante que otros paseos suaves.");
        attraction24.setHeight(10.0);
        attraction24.setDuration(120); // 2 minutos = 120 segundos
        attraction24.setSpeed(5.0);
        attraction24.setMinHeight(36);
        attraction24.setImageUrl1("roto-whip1.jpg");
        attraction24.setImageUrl2("roto-whip2.jpg");
        attraction24.setImageUrl3("roto-whip3.jpg");
        attraction24.setVideoUrl("https://youtu.be/8oHSwt3WUbc?si=iTBFH5E_ryMoWxUg");
        attraction24.setZone(zone8); 
        attraction24.setIntensity(thrill2); 
        attraction24.setType(type5); 
        attraction24.setLine(10); // Tiempo de espera reducido para atracciones infantiles

        
        // Guardar Atracciones en la base de datos
        attractionRepository.saveAll(List.of( attraction1,  attraction2,  attraction3,  attraction4,  attraction5, attraction6,  attraction7,  attraction8,  attraction9,  attraction10, attraction11, attraction12, attraction13, attraction14, attraction15, attraction16, attraction17, attraction18, attraction19, attraction20, attraction21, attraction22, attraction23, attraction24 ));
        System.out.println("Todas las atracciones (1-24) han sido insertadas correctamente.");

        // Crear Hoteles (Hoteles)
        System.out.println("Insertando hoteles...");
        Hotel hotel1 = new Hotel();
        hotel1.setName("Hotel Playa Dorada");
        hotel1.setSlogan("Vive la experiencia de un paraíso tropical.");
        hotel1.setShortDescription("Un lugar ideal para unas vacaciones de lujo junto al mar.");
        hotel1.setDescription("Hotel de lujo con acceso directo a la playa, piscina infinita y restaurantes gourmet.");
        hotel1.setTheme("Tropical");
        hotel1.setRoomTypes("Suite, Doble, Familia");
        hotel1.setParkAccessDetails("Acceso a parque temático cercano.");
        hotel1.setStars("5");
        hotel1.setCoverImage("https://via.placeholder.com/500x300?text=Hotel+Playa+Dorada");
        hotel1.setVideoUrl("https://www.youtube.com/watch?v=examplevideo1");

        Hotel hotel2 = new Hotel();
        hotel2.setName("Hotel Montaña Mágica");
        hotel2.setSlogan("Una escapatoria única entre las montañas.");
        hotel2.setShortDescription("Disfruta de la naturaleza en su máxima expresión.");
        hotel2.setDescription("Un retiro en las montañas con vistas impresionantes, spa y actividades al aire libre.");
        hotel2.setTheme("Montaña");
        hotel2.setRoomTypes("Doble, Suite");
        hotel2.setParkAccessDetails("Acceso a rutas de senderismo.");
        hotel2.setStars("4");
        hotel2.setCoverImage("https://via.placeholder.com/500x300?text=Hotel+Montaña+Mágica");
        hotel2.setVideoUrl("https://www.youtube.com/watch?v=examplevideo2");

        Hotel hotel3 = new Hotel();
        hotel3.setName("Hotel Ciudad Imperial");
        hotel3.setSlogan("El lujo y la comodidad en el corazón de la ciudad.");
        hotel3.setShortDescription("Disfruta de un alojamiento exclusivo en el centro de la ciudad.");
        hotel3.setDescription("Confort, ubicación privilegiada y un ambiente moderno. Ideal para negocios y turismo.");
        hotel3.setTheme("Ciudad");
        hotel3.setRoomTypes("Doble, Ejecutiva, Penthouse");
        hotel3.setParkAccessDetails("Estacionamiento subterráneo.");
        hotel3.setStars("5");
        hotel3.setCoverImage("https://via.placeholder.com/500x300?text=Hotel+Ciudad+Imperial");
        hotel3.setVideoUrl("https://www.youtube.com/watch?v=examplevideo3");

        hotelRepository.save(hotel1);
        hotelRepository.save(hotel2);
        hotelRepository.save(hotel3);        

        System.out.println("Hoteles insertados correctamente.");
    }
}

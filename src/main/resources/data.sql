INSERT INTO zone(name) VALUES 
('FRONTIER TOWN'), 
('CAMP SNOOPY'),
('GEMINI MIDWAY'), 
('FRONTIER TRAIL'),
('MILLENNIUM MIDWAY'), 
('MAIN MIDWAY'), 
('PLANET SNOOPY™'),
('KIDDY KINGDOM'),
('BOARDWALK');


INSERT INTO thrill (name) VALUES 
('Low'), 
('Moderate'), 
('Aggressive'), 
('Mild'), 
('High');


INSERT INTO type (name) VALUES 
('Roller coasters'), 
('Thrill rides'), 
('Family rides'), 
('Water Ride'), 
('Children rides');



INSERT INTO attraction(
    name, description, height, length, duration, speed, min_height, 
    min_height_with_adult, image_url1, image_url2, image_url3, 
    video_url, zone_id, intensity_id, type_id
) 

VALUES 
(
    'Blue Streak', 
    'Blue Streak es una montana rusa de madera clasica y la mas antigua en funcionamiento en Cedar Point. Ofrece un recorrido de 1 minuto y 30 segundos con una altura de 78 pies y una velocidad de hasta 40 mph. Su diseno tradicional de ida y vuelta proporciona multiples colinas y una emocionante experiencia de airtime.', 
    78, 
    2558, 
    2, 
    40, 
    48, 
    0, 
    'bluestreak1.png', 
    'bluestreak2.jpg', 
    'bluestreak3.jpeg', 
    'https://www.youtube.com/embed/t5aeLbY4bE8?si=G7qcOJd7ATmSEPcr', 
    6,  -- Ensure this ID exists in the `zone` table
    4,  -- Ensure this ID exists in the `thrill` table
    1   -- Ensure this ID exists in the `type` table
),
(
    'Cedar Creek Mine Ride', 
    'Cedar Creek Mine Ride es una montana rusa de tren minero que transporta a los visitantes al Viejo Oeste. Con dos elevadores y multiples giros, ofrece una experiencia emocionante a traves de tuneles, sobre el agua y a traves de una doble helice. Abierta en 1969, sigue siendo una atraccion iconica en Frontier Town.', 
    48, 
    2500, 
    2.83, 
    40, 
    48, 
    0, 
    'creekmine1.jpg', 
    'creekmine2.jpg', 
    'creekmine3.JPG', 
    'https://youtu.be/6x69vGPT-bw?si=FAte_xTF56Ea1JCL', 
    1,  -- FRONTIER TOWN
    4,  -- High (intensidad)
    1   -- Roller coasters
),
(
    'Corkscrew', 
    'Corkscrew es una montana rusa de acero iconica que fue la primera en el mundo en contar con tres inversiones. Desde su apertura en 1976, ha desafiado a los visitantes con su caracteristico bucle y dos giros en sacacorchos sobre la pasarela del parque. Con una velocidad de 48 mph y una longitud de 2,050 pies, ofrece una experiencia intensa de giros y cambios de direccion que desafian la gravedad.', 
    85, 
    2050, 
    2, 
    48, 
    48, 
    0, 
    'corkscrew1.jpg', 
    'corkscrew2.jpg', 
    'corkscrew3.jpeg', 
    'https://youtu.be/tBkTuaL--30?si=hZOa6Wa69vUbFSJy', 
    3,  -- GEMINI MIDWAY
    5,  -- Aggressive (intensidad)
    1   -- Roller coasters
),
(
    'GateKeeper', 
    'GateKeeper es una montana rusa de acero con un diseno de inversiones y una caida impresionante. Con una altura de 170 pies y una velocidad de 67 mph, esta montana rusa ofrece una experiencia unica con un par de inversores y un vuelo inverso mientras los pasajeros cruzan por encima de la entrada del parque.', 
    170, 
    4020, 
    2, 
    67, 
    54, 
    0, 
    'gatekeeper1.jpg', 
    'gatekeeper2.jpg', 
    'gatekeeper3.jpg', 
    'https://youtu.be/pkOqi7Du3Og?si=M0Z4xJ8VzZ9WMDU7', 
    6,  -- MAIN MIDWAY
    5,  -- Aggressive (intensidad)
    1   -- Roller coasters
),
(
    'Gemini', 
    'Gemini es una montana rusa de madera y acero que ofrece una experiencia de carreras entre dos trenes. Con una altura de 125 pies y una velocidad de hasta 60 mph, este iconico recorrido de doble via ha sido uno de los favoritos de los visitantes de Cedar Point desde su apertura en 1978.', 
    125, 
    3800, 
    2.5, 
    60, 
    54, 
    0, 
    'gemini1.jpg', 
    'gemini2.jpeg', 
    'gemini3.jpeg', 
    'https://youtu.be/O5anQIKQgAo?si=htfH5lptIHpVdoxe', 
    3,  -- GEMINI MIDWAY
    4,  -- High (intensidad)
    1   -- Roller coasters
),
(
    'Iron Dragon', 
    'Iron Dragon es una montana rusa suspendida que ofrece una experiencia unica de vuelo, donde los pasajeros se cuelgan bajo los rieles mientras realizan giros, caidas y suaves inversiones. Con una altura de 76 pies y una velocidad de hasta 40 mph, esta atraccion es conocida por su relajante pero emocionante recorrido.', 
    76, 
    3060, 
    2, 
    40, 
    48, 
    0, 
    'irondragon1.jpg', 
    'irondragon2.jpeg', 
    'irondragon3.jpg', 
    'https://youtu.be/2cwUMqSWSmU?si=2aioZ0oPGOzL5THv', 
    6,  -- MAIN MIDWAY
    4,  -- High (intensidad)
    1   -- Roller coasters
),
(
    'Magnum XL-200', 
    'Magnum XL-200 es una montana rusa de acero que ofrece una experiencia impresionante con caidas de hasta 200 pies de altura y una velocidad de 72 mph. Fue la primera montana rusa en superar los 200 pies, y sigue siendo una de las mas emocionantes en Cedar Point, destacando por sus impresionantes caidas y airtime.', 
    205, 
    5000, 
    3, 
    72, 
    54, 
    0, 
    'magnum1.jpg', 
    'magnum2.png', 
    'magnum3.jpg', 
    'https://youtu.be/3x3fIh72rfw?si=AJpss0QOIi05Y2Tm', 
    3,  -- GEMINI MIDWAY
    5,  -- Aggressive (intensidad)
    1   -- Roller coasters
),
(
    'Maverick', 
    'Maverick es una montana rusa de acero que combina caidas intensas, giros cerrados y una velocidad impresionante. Con una altura de 105 pies y una velocidad de hasta 70 mph, Maverick es conocida por sus rapidas transiciones y su experiencia de airtime que mantiene a los pasajeros al borde de sus asientos.', 
    105, 
    3800, 
    2, 
    70, 
    54, 
    0, 
    'maverick1.jpg', 
    'maverick2.jpg', 
    'maverick3.jpg', 
    'https://youtu.be/WUpQMWGVw4g?si=hiuZYnpiO3vP3R9e', 
    1,  -- FRONTIER TOWN
    5,  -- Aggressive (intensidad)
    1   -- Roller coasters
),
(
    'Millennium Force', 
    'Millennium Force es una de las montanas rusas mas rapidas y altas del mundo. Con una altura de 310 pies y una velocidad de 93 mph, esta atraccion de acero ofrece un recorrido epico con impresionantes caidas y airtime, lo que la convierte en un favorito entre los aficionados a las montanas rusas.', 
    310, 
    6500, 
    3, 
    93, 
    54, 
    0, 
    'millenniumforce1.jpg', 
    'millenniumforce2.JPG', 
    'millenniumforce3.jpg', 
    'https://youtu.be/MybcORGVkEU?si=OkWtrWZsheO4Y5aV', 
    6,  -- MAIN MIDWAY
    5,  -- Aggressive (intensidad)
    1   -- Roller coasters
),
(
    'Raptor', 
    'Raptor es una montana rusa invertida de acero que ofrece una experiencia intensa y emocionante con cuatro inversiones. Con una altura de 137 pies y una velocidad de 57 mph, este recorrido desafiante pone a los pasajeros boca abajo mientras atraviesan curvas rapidas y caidas vertiginosas.', 
    137, 
    3900, 
    2, 
    57, 
    54, 
    0, 
    'raptor1.jpg', 
    'raptor2.JPG', 
    'raptor3.JPG', 
    'https://youtu.be/Tb2H-8CQuyY?si=340I_YGX4QFqddXv', 
    6,  -- MAIN MIDWAY
    5,  -- Aggressive (intensidad)
    1   -- Roller coasters
),
(
    'Rougarou', 
    'Rougarou es una montana rusa invertida que combina la emocion de los giros rapidos y los intensos airtime moments con un diseno unico. Con una altura de 145 pies y una velocidad de 60 mph, esta atraccion desafia la gravedad con sus cuatro inversiones y giros vertiginosos.', 
    145, 
    3950, 
    2.5, 
     60, 
    54, 
    0, 
    'rougarou1.jpg', 
    'rougarou2.jpg', 
    'rougarou3.jpg', 
    'https://youtu.be/RuweAtyeUuU?si=e67m6dxTkTo9yUNU', 
    6,  -- MAIN MIDWAY
    5,  -- Aggressive (intensidad)
    1   -- Roller coasters
),
(
    'Sirens Curse', 
    'Sirens Curse es una montana rusa de acero que lleva a los pasajeros a traves de una serie de giros, caidas y momentos de airtime. Con una tematica de sirenas y un diseno unico que incluye una gran inversion en espiral, esta montana rusa desafia la gravedad mientras cuenta una historia emocionante.', 
    120, 
    3300, 
    2, 
    50, 
    48, 
    0, 
    'sirenscurse1.jpg', 
    'sirenscurse2.jpeg', 
    'sirenscurse3.jpeg', 
    'https://youtu.be/mIdb_eygDEM', 
    6,  -- MAIN MIDWAY
    4,  -- High (intensidad)
    1   -- Roller coasters
),
(
    'Steel Vengeance', 
    'Steel Vengeance es una montana rusa hibrida de acero que utiliza una estructura de madera que supera los 200 pies de altura, convirtiendola en la primera hypercoaster hibrida del mundo. Con 200 pies de altura y una velocidad de 74 mph, esta montana rusa ofrece mas de 27 momentos de airtime en su recorrido.', 
    205, 
    5100, 
    2.5, 
    74, 
    54, 
    0, 
    'steelvengeance1.jpg', 
    'steelvengeance2.jpg', 
    'steelvengeance3.jpg', 
    'https://youtu.be/RTXTbzctl0c', 
    1,  -- FRONTIER TOWN
    5,  -- Aggressive (intensidad)
    1   -- Roller coasters
),
(
    'Top Thrill 2', 
    'Top Thrill 2 es una montana rusa lanzada que abrio como la mas alta y rapida del mundo, alcanzando una altura de 420 pies y una velocidad maxima de 120 mph. Originalmente construida en 2003 por Intamin y renovada por Zamperla para la temporada 2024, esta montana rusa ofrece una experiencia extrema con un recorrido de lanzamiento que desafia los limites.', 
    420, 
    4200, 
    2, 
    120, 
    54, 
    0, 
    'topthrill2_1.jpg', 
    'topthrill2_2.jpg', 
    'topthrill2_3.jpg', 
    'https://youtu.be/4XsAATlMGlM', 
    6,  -- TOP THRILL 2 MIDWAY
    5,  -- Aggressive (intensidad)
    1   -- Roller coasters
),
(
    'Valravn', 
    'Valravn es una montana rusa de acero que abrio como la mas alta, rapida y larga del mundo dentro de la categoria Dive Coaster. Con 223 pies de altura y una velocidad de 75 mph, Valravn desafia a los pasajeros con un emocionante descenso vertical de 90 grados y giros espectaculares, lo que la convierte en una de las mejores atracciones de Cedar Point.', 
    223, 
    4320, 
    2, 
    75, 
    54, 
    0, 
    'valravn1.jpg', 
    'valravn2.jpg', 
    'valravn3.jpg', 
    'https://youtu.be/1b1rvkktEv0', 
    6,  -- MAIN MIDWAY
    5,  -- Aggressive (intensidad)
    1   -- Roller coasters
),
(
    'Wilderness Run', 
    'Wilderness Run es una montana rusa de acero disenada especialmente para ninos, anteriormente conocida como Jr. Gemini. Fue la primera montana rusa fabricada por Intamin, y fue renombrada a Wilderness Run en 2014. Con una altura de 25 pies y una velocidad de 20 mph, es ideal para los mas pequenos que estan listos para su primera experiencia en montana rusa.', 
    25, 
    900, 
    1.5, 
    20, 
    36, 
    0, 
    'wildernessrun1.jpg', 
    'wildernessrun2.jpg', 
    'wildernessrun3.jpg', 
    'https://youtu.be/gkVt5uryylQ', 
    7,  -- CAMP SNOOPY
    2,  -- Low (intensidad)
    1   -- Kiddie rides
),
(
    'Wild Mouse', 
    'Wild Mouse es una montana rusa de tipo "wild mouse" con coches que giran individualmente. Cada coche tiene capacidad para cuatro pasajeros, y alcanza una velocidad maxima de 35 mph. Esta montana rusa de Zamperla ofrece un recorrido de giros rapidos y caidas cortas, lo que la hace emocionante pero accesible para todos los publicos.', 
    60, 
    1500, 
    2, 
    35, 
    48, 
    0, 
    'wildmouse1.jpg', 
    'wildmouse2.jpg', 
    'wildmouse3.jpg', 
    'https://youtu.be/_1LhhUxrh1Q?si=nSWVkEExH3N9NGTe', 
    8,  -- BOARDWALK
    4,  -- High (intensidad)
    1   -- Roller coasters
),
(
    'Woodstock Express', 
    'Woodstock Express es una montana rusa infantil de acero fabricada por Vekoma, ubicada en Camp Snoopy. Esta atraccion tiene un diseno de montana rusa tradicional para ninos, con un recorrido suave y facil, perfecto para aquellos que se inician en el mundo de las montanas rusas.', 
    35, 
    1000, 
    1.5, 
    25, 
    36, 
    0, 
    'woodstockexpress1.jpg', 
    'woodstockexpress2.jpg', 
    'woodstockexpress3.jpg', 
    'https://youtu.be/fDBydpPplzQ?si=QxJ48zc16mTTxy3G', 
    7,  -- CAMP SNOOPY
    4,  -- High (intensidad)
    1   -- Kiddie rides
),
(
    'Cedar Point & Lake Erie Railroad', 
    'El Cedar Point & Lake Erie Railroad es un recorrido en tren tematico del oeste con una duracion de 15 minutos y un trayecto de 2 millas (3.2 km). El tren de via estrecha de 3 pies (914 mm) tiene dos estaciones: una cerca de Iron Dragon y otra cerca de Steel Vengeance.', 
    0, 
    3200, 
    15, 
    10, 
    36, 
    0, 
    'train1.jpg', 
    'train2.png', 
    'train3.png', 
    'https://youtu.be/_vbxkmZuodM?si=0ujYvRondk2VfRDg', 
    1,  -- MILLENNIUM MIDWAY and FRONTIER TOWN
    1,  -- Low (intensidad)
    3   -- Train Rides
),
(
    'Giant Wheel', 
    'Giant Wheel es una rueda de observacion de 136 pies (41.5 m) de altura, que ofrece impresionantes vistas panoramicas del parque y el lago Erie. Abierta desde 1972, esta atraccion es un clasico de Cedar Point.', 
    136, 
    0, 
    5, 
    0, 
    48, 
    0, 
    'giantwheel1.jpg', 
    'giantwheel2.webp', 
    'giantwheel3.jpeg', 
    'https://youtu.be/rIRnP7OwyMU?si=sDcFNdQPQGk67afR', 
    8,  -- BOARDWALK
    2,  -- Low (intensidad)
    3   -- Observation Rides
),

(
    'Pipe Scream', 
    'Pipe Scream es una montana rusa tipo Skater Coaster donde un solo carrito viaja a lo largo de una pista en forma de "U" de 302 pies (92 m) de largo. Alcanzando una altura de 43 pies (13 m), ofrece un recorrido rapido y emocionante.', 
    43, 
    302, 
    2, 
    0, 
    48, 
    0, 
    'pipescream1.jpg', 
    'pipescream2.jpg', 
    'pipescream3.jpeg', 
    'https://youtu.be/mv9lGf83juc?si=kLYJte9wkWNn_k3D', 
    3,  -- GEMINI MIDWAY
    4,  -- High (intensidad)
    3   -- Roller Coasters
),
(
    'Sky Ride', 
    'Sky Ride es una gondola de transporte aereo que lleva a los pasajeros desde la entrada del parque hasta una estacion cerca de Corkscrew. Ofrece vistas panoramicas y es una forma relajante de recorrer el parque desde las alturas.', 
    0, 
    2000, 
    5, 
    0, 
    48, 
    0, 
    'skyrid1.jpg', 
    'skyrid2.jpg', 
    'skyrid3.jpeg', 
    'https://youtu.be/o4AaYvh9hsc?si=Q-PPFevaHsDMXLyi', 
    6,  -- MAIN MIDWAY
    3,  -- Medium (intensidad)
    3   -- Gondola Rides
),
(
    'Kiddy Kingdom Carousel', 
    'Kiddy Kingdom Carousel es un carrusel tradicional con animales y vehiculos para montar. Es una atraccion clasica de la zona, ideal para los mas pequenos.', 
    0, 
    0, 
    3, 
    0, 
    36, 
    0, 
    'kiddiecarousel1.jpg', 
    'kiddiecarousel2.jpg', 
    'kiddiecarousel3.jpg', 
    'https://youtu.be/YyUm5gO4eTg?si=isdcgLlTV_U_bLJN', 
    6,  -- KIDDIE KINGDOM
    1,  -- Low (intensidad)
    5   -- Carousel Rides
),
(
    'Roto Whip', 
    'Roto Whip es un paseo giratorio en el que los ninos se suben a carritos que giran rapidamente, ofreciendo un recorrido mas dinamico y emocionante que otros paseos suaves.', 
    10, 
    200, 
    2, 
    5, 
    36, 
    0, 
    'roto-whip1.jpg', 
    'roto-whip2.jpg', 
    'roto-whip3.jpg', 
    'https://youtu.be/8oHSwt3WUbc?si=iTBFH5E_ryMoWxUg', 
    6,  -- KIDDIE KINGDOM
    2,  -- Low (intensidad)
    5   -- Kids Rides
),
(
    'Sky Fighters', 
    'Sky Fighters es una atraccion en la que los ninos pueden montar aviones en miniatura mientras giran en el aire, ofreciendo una experiencia de vuelo ligera y emocionante.', 
    12, 
    180, 
    2, 
    5, 
    36, 
    0, 
    'skyfighters1.jpg', 
    'skyfighters2.jpeg', 
    'skyfighters3.jpg', 
    'https://youtu.be/NBifmJ5YCHc?si=C4a1aiaRX0928tju', 
    6,  -- KIDDIE KINGDOM
    2,  -- Low (intensidad)
    5   -- Kids Rides
);


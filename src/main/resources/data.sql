
INSERT INTO zone(name) VALUES 
('FRONTIER TOWN'), 
('CAMP SNOOPY™'),
('GEMINI MIDWAY'), 
('FRONTIER TRAIL'),
('MILLENNIUM MIDWAY'), 
('MAIN MIDWAY'), 
('PLANET SNOOPY™'),
('KIDDY KINGDOM'),
('LAKESIDE MIDWAY');


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

INSERT INTO attraction(name, description, height, length, duration, speed, min_height, min_height_with_adult, image_url1, image_url2, image_url3, video_url, zone_id, intensity_id, type_id)
VALUES
('Steel Vengeance', 'Una de las montañas rusas más intensas del parque.', 50.5, 2000.0, 150, 120.0, 130, 100, 'https://example.com/steel_vengeance_1.jpg', 'https://example.com/steel_vengeance_2.jpg', 'https://example.com/steel_vengeance_3.jpg', 'https://example.com/steel_vengeance_video.mp4', 1, 5, 1),
('The Racer', 'Una montaña rusa clásica de madera.', 45.0, 1600.0, 120, 90.0, 110, 80, 'https://example.com/the_racer_1.jpg', 'https://example.com/the_racer_2.jpg', 'https://example.com/the_racer_3.jpg', 'https://example.com/the_racer_video.mp4', 2, 2, 1);

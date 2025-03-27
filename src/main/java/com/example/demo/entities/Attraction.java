package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class Attraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double height;
    private Double length;
    private Integer duration;
    private Double speed;
    private Integer minHeight;
    private Integer minHeightWithAdult;
    private String imageUrl1;
    private String imageUrl2;
    private String imageUrl3;
    private String videoUrl;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    @ManyToOne
    @JoinColumn(name = "intensity_id")
    private Thrill intensity;

    public Attraction() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }

    public Double getLength() { return length; }
    public void setLength(Double length) { this.length = length; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }

    public Double getSpeed() { return speed; }
    public void setSpeed(Double speed) { this.speed = speed; }

    public Integer getMinHeight() { return minHeight; }
    public void setMinHeight(Integer minHeight) { this.minHeight = minHeight; }

    public Integer getMinHeightWithAdult() { return minHeightWithAdult; }
    public void setMinHeightWithAdult(Integer minHeightWithAdult) { this.minHeightWithAdult = minHeightWithAdult; }

    public String getImageUrl1() { return imageUrl1; }
    public void setImageUrl1(String imageUrl1) { this.imageUrl1 = imageUrl1; }

    public String getImageUrl2() { return imageUrl2; }
    public void setImageUrl2(String imageUrl2) { this.imageUrl2 = imageUrl2; }

    public String getImageUrl3() { return imageUrl3; }
    public void setImageUrl3(String imageUrl3) { this.imageUrl3 = imageUrl3; }

    public String getVideoUrl() { return videoUrl; }
    public void setVideoUrl(String videoUrl) { this.videoUrl = videoUrl; }

    public Zone getZone() { return zone; }
    public void setZone(Zone zone) { this.zone = zone; }

    public Thrill getIntensity() { return intensity; }
    public void setIntensity(Thrill intensity) { this.intensity = intensity; }
}

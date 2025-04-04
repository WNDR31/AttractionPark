package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Attraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Long id;
    private String name;
    @Column(length = 1000) 
    private String description;
    private Double height;
    private Integer duration;
    private Double speed;
    private Integer minHeight;
    private String imageUrl1;
    private String imageUrl2;
    private String imageUrl3;
    private String videoUrl;
    private Integer line; 
    
    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    @ManyToOne
    @JoinColumn(name = "intensity_id")
    private Thrill intensity;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;  // Relation with Type

    public Attraction() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }

    public Double getSpeed() { return speed; }
    public void setSpeed(Double speed) { this.speed = speed; }

    public Integer getMinHeight() { return minHeight; }
    public void setMinHeight(Integer minHeight) { this.minHeight = minHeight; }


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

    public Type getType() { return type; } // Getter for Type
    public void setType(Type type) { this.type = type; } // Setter for Type
    public Integer getLine() {
        return line;
    }
    
    public void setLine(Integer line) {
        this.line = line;
    }
}

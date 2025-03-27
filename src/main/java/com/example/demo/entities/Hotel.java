package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String slogan;
    private String shortDescription;
    private String description;
    private String theme;
    private String roomTypes;
    private String parkAccessDetails;
    private String stars;
    private String imageUrl1;
    private String imageUrl2;
    private String imageUrl3;
    private String imageUrl4;
    private String imageUrl5;
    private String coverImage;
    private String videoUrl;

    public Hotel() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSlogan() { return slogan; }
    public void setSlogan(String slogan) { this.slogan = slogan; }

    public String getShortDescription() { return shortDescription; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getTheme() { return theme; }
    public void setTheme(String theme) { this.theme = theme; }

    public String getRoomTypes() { return roomTypes; }
    public void setRoomTypes(String roomTypes) { this.roomTypes = roomTypes; }

    public String getParkAccessDetails() { return parkAccessDetails; }
    public void setParkAccessDetails(String parkAccessDetails) { this.parkAccessDetails = parkAccessDetails; }

    public String getStars() { return stars; }
    public void setStars(String stars) { this.stars = stars; }

    public String getImageUrl1() { return imageUrl1; }
    public void setImageUrl1(String imageUrl1) { this.imageUrl1 = imageUrl1; }

    public String getImageUrl2() { return imageUrl2; }
    public void setImageUrl2(String imageUrl2) { this.imageUrl2 = imageUrl2; }

    public String getImageUrl3() { return imageUrl3; }
    public void setImageUrl3(String imageUrl3) { this.imageUrl3 = imageUrl3; }

    public String getImageUrl4() { return imageUrl4; }
    public void setImageUrl4(String imageUrl4) { this.imageUrl4 = imageUrl4; }

    public String getImageUrl5() { return imageUrl5; }
    public void setImageUrl5(String imageUrl5) { this.imageUrl5 = imageUrl5; }

    public String getCoverImage() { return coverImage; }
    public void setCoverImage(String coverImage) { this.coverImage = coverImage; }

    public String getVideoUrl() { return videoUrl; }
    public void setVideoUrl(String videoUrl) { this.videoUrl = videoUrl; }

}

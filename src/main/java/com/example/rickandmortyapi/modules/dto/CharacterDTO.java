package com.example.rickandmortyapi.modules.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private String status;

    @JsonProperty("species")
    private String species;

    @JsonProperty("image")
    private String image;

    @JsonProperty("created")
    private String created;

    @Override
    public String toString() {
        return "Name: " + getName() +
                "\nStatus: " + getStatus() +
                "\nSpecies: " + getSpecies() +
                "\nImage: " + getImage() +
                "\nCreated: " + getCreated() +
                "\n******************************************************";
    }
}

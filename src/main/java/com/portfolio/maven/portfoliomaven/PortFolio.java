package com.portfolio.maven.portfoliomaven;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("PortFolio")
public class PortFolio {
    @Id
    private String id;
    private String name;
    private String email;
    private String description;
    
}

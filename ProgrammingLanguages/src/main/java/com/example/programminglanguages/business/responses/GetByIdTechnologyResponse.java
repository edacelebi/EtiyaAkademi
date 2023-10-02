package com.example.programminglanguages.business.responses;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdTechnologyResponse {
    private int id;
    private String name;
}

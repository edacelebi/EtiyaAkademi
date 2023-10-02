package com.example.programminglanguages.business.requests;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTechnologyRequest {
    private int id;
    private String name;
}

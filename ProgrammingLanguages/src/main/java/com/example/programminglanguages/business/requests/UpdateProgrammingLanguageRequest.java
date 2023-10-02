package com.example.programminglanguages.business.requests;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProgrammingLanguageRequest {
    private int id;
    private String name;
}

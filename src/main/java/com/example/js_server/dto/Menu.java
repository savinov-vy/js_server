package com.example.js_server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private String img;
    private String altimg;
    private String title;
    private String descr;
    private Integer price;
}

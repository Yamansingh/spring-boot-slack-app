package com.demo.exception;

import lombok.*;

import java.time.LocalDateTime;




import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MyErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}

package sample.common.dao.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Task {

    private Long id;                  // BIGINT
    private String username;          // VARCHAR(50)
    private String title;             // VARCHAR(255)
    private String content;           // TEXT
    private String name;              // VARCHAR(100)
    private LocalDate startDate;      // DATE
    private LocalDate endDate;        // DATE
    private LocalDateTime createdAt;  // TIMESTAMP
    private LocalDateTime updatedAt;  // TIMESTAMP

}

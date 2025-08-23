package sample.common.dao.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    // --- Getter & Setter ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}

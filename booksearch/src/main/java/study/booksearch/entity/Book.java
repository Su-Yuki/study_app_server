package study.booksearch.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String categoryId;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String url;
    private String imageUrl;
    @CreationTimestamp
    @Column(name="created_at", updatable=false)
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;

    public Book() {}

    public Book(String title, String categoryId, Status status, String url, String imageUrl) {
        this.title = title;
        this.categoryId = categoryId;
        this.status = status;
        this.url = url;
        this.imageUrl = imageUrl;
    }

    public Book(UUID id, String title, String categoryId, Status status, String url, String imageUrl) {
        this.id = id;
        this.title = title;
        this.categoryId = categoryId;
        this.status = status;
        this.url = url;
        this.imageUrl = imageUrl;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Book{ID:" + getId() +
            ", title:" + getTitle() +
            ", category:" + getCategoryId() +
            ", status:" + getStatus();
    }

}

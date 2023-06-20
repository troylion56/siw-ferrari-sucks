package it.unitoma3.ferrarisucks.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotBlank
    private String title;

    @Min(1)
    @Max(5)
    private int rating;


    @Column(length =100)
    @Length(max=100)
    @NotBlank
    private String comment;

    @ManyToOne
    private User author;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}

package dev.moalnawagy.movies_app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Reviews")
public class Review {
    @Id
    private ObjectId id;
    private String body;

    public Review(String body) {
        this.body = body;
    }
}

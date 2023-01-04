package com.ironhack.otakuhub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ironhack.otakuhub.dto.QuoteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String anime;
    @JsonProperty(value = "character")
    private String charac;
    private String quote;

    @ManyToOne
    private User users;

    public static Quote fromQuoteDTO(QuoteDTO quoteDTO) {
        var Quote = new Quote();
        Quote.setAnime(quoteDTO.getAnime());
        Quote.setCharac(quoteDTO.getCharac());
        Quote.setQuote(quoteDTO.getQuote());
        return Quote;
    }
}
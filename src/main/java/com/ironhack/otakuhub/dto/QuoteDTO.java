package com.ironhack.otakuhub.dto;

import com.ironhack.otakuhub.model.Quote;
import com.ironhack.otakuhub.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuoteDTO {
    private String anime;
    private String charac;
    private String quote;
    private User users;


    public static QuoteDTO fromQuote(Quote quote){
        var QuoteDTO = new QuoteDTO();
        QuoteDTO.setAnime(quote.getAnime());
        QuoteDTO.setCharac(quote.getCharac());
        QuoteDTO.setQuote(quote.getQuote());
        QuoteDTO.setUsers(quote.getUsers());
        return QuoteDTO;
    }
}



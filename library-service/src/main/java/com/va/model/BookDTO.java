package com.va.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    Long bookId;
    String title;
    String author;
    Integer publishedYear;
}

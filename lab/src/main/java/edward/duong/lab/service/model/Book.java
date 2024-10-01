package edward.duong.lab.service.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@ToString
public class Book {
    private Integer id;
    private String title;
    private String isbn;
}

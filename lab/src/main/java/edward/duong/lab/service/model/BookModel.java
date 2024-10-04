package edward.duong.lab.service.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookModel {
    private Integer id;
    private String title;
    private String isbn;
}

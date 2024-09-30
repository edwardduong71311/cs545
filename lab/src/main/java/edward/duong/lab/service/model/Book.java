package edward.duong.lab.service.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class Book {
    @NonNull
    private Integer id;
    private String title;
    private String isbn;
}

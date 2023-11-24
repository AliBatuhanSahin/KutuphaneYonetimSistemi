package dev.patika;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "book_borrowing")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookBorrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "borrower_name", nullable = false)
    private String borrowerName;

    @Column (name = "borrowing_date", nullable = false)
    private LocalDate borrowingDate;

    @Column (name = "return_date", nullable = false)
    private LocalDate returnDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;
}

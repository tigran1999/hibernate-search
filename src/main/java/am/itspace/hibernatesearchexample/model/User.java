package am.itspace.hibernatesearchexample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Indexed
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Field(termVector = TermVector.YES)
    @Column
    private String name;

    @Field(termVector = TermVector.YES)
    @Column
    private String surname;

    @Field(termVector = TermVector.YES)
    @Column
    private String characteristic;

    @Field(termVector = TermVector.YES)
    @Column
    private int age;

}

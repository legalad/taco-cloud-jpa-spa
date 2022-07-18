package sia.tacos;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "createdat")
    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "Nazwa musi się składać z przynajmniej pięciu znaków")
    private String name;

    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min = 1, message = "Musisz wybrać przynajmniej jeden składnik")
    private List<Ingredient> ingredients;

    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }

    public BigDecimal checkPrice(){
        BigDecimal sum = new BigDecimal(0);
        ingredients.forEach(i ->  sum.add(i.getPrice()));
        System.out.println(sum);
        return sum;
    }
}

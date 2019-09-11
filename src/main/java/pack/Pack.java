package main.java.pack;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import main.java.model.Product;

import java.util.Objects;

@Setter
@Getter
@RequiredArgsConstructor
public abstract class Pack implements Comparable {
    private String curreny = "$";

    public abstract Integer getQuantity();

    public abstract float getAmount();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pack pack = (Pack) o;
        return getQuantity() == pack.getQuantity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuantity());
    }

    @Override
    public int compareTo(Object object) {
        Pack pack = (Pack) object;
        return pack.getQuantity().compareTo(this.getQuantity());
    }

}

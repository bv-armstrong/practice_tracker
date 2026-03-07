package dev.bv_armstrong.practice_tracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table
public final class PracticeItem {


    @Id private long id;
    private String name;

    public PracticeItem(String name) {
        this.name = name;
    }

    public PracticeItem(
            long id,
            String name
    ) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (PracticeItem) obj;
        return this.id == that.id &&
                Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "PracticeItem[" +
                "id=" + id + ", " +
                "name=" + name + ']';
    }

}

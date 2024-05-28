import java.util.HashMap;
import java.util.Objects;

public class Vertex {
    private final HashMap<Object, Object> attributes;
    private String id;

    public Vertex(String id) {
        this.id = id;
        this.attributes = new HashMap<>();
    }

    // Получение идентификатора вершины
    public String getId() {
        return id;
    }

    // Добавление атрибута к вершине
    public void addAttribute(String key, Object value) {
        attributes.put(key, value);
    }

    // Получение атрибута вершины
    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    // Вывод информации о вершине
    @Override
    public String toString() {
        return "Vertex{" +
                "id='" + id + '\'' +
                ", attributes=" + attributes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(id, vertex.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

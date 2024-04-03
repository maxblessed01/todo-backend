package backend.likelion.todos;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {
    private String id;
    private String name;

    public User(String id, String name){
        this.id = id;
        this.name = name;
    }
}

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Appointment { 
    //criando atributos do compromisso
    private int id;
    private String title;
    private String description;
    private LocalDate date;
    private LocalTime time;

//Construtor que inicializa o objeto Appointment com os parâmetros passados
    public Appointment(int id, String title, String description, LocalDate date, LocalTime time) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    // Getters e Setters
    public int getId() { return id; } //obtém o valor do atributo id
    public void setId(int id) { this.id = id; }//modifica o valor do atributo id
    public void setTitle(String title) { this.title = title; }//modifica o valor do atributo title
    public void setDescription(String description) { this.description = description; }//modifca o valor do atributo description
    public void setDate(LocalDate date) { this.date = date; }//modiica o valor do atributo date
    public void setTime(LocalTime time) { this.time = time; }//modifca o valor do atributo time

    //construtor que inicializa a classe agenda e o scanner
    @Override
    public String toString() {
        return "Compromisso{\n" +
                "id=" + id + ",\n" +
                "título='" + title + '\'' + ",\n" +
                "descrição='" + description + '\'' + ",\n" +
                "data=" + date + ",\n" +
                "horário=" + time +
                '}';
    }

    // Sobrescrever equals e hashCode para garantir unicidade no HashSet
//Verifica se dois objetos Appointment são iguais comparando seus IDs. Isso é crucial para garantir que dois compromissos com o mesmo ID sejam considerados iguais, especialmente ao usar coleções como HashSet.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false; //getClass() garante que os objetos comparados sejam da mesma classe.
        Appointment that = (Appointment) o;
        return id == that.id;
    }

//utiliza o hashCode para atibuir um código único a cada id e facilitar a comparação e busca de objetos.
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private int id;
    private String title;
    private String description;
    private LocalDate date;
    private LocalTime time;

    public Appointment(int id, String title, String description, LocalDate date, LocalTime time) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    // Getters e Setters
    public int getId() { return id; } //utilizado no AppointmentManager para captar o id (22 e 28)

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setTime(LocalTime time) { this.time = time; }

    //uitlizado para retornar o compromisso quando a opçao de listar é acionada
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
}

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AppointmentManager {
    protected Set<Appointment> appointments; //atributo appointments que é um hashset, para garantir id's únicos

    public AppointmentManager() {
        this.appointments = new HashSet<>(); //construtor que inicializa o hashSet
    }

//método que adiciona um compromisso no hash, caso o ID já exista, retorna erro
    public void addAppointment(Appointment appointment) {
        if (appointments.add(appointment)) {
            System.out.println("Compromisso adicionado com sucesso.");
        } else {
            System.out.println("Um compromisso com esse ID já existe.");
        }
    }

//método que remove um compromisso pelo ID, caso o ID não exista, retorna erro
    public void removeAppointment(int id) {
        if (appointments.removeIf(appointment -> appointment.getId() == id)) {
            System.out.println("Compromisso removido com sucesso.");
        } else {
            System.out.println("Compromisso não encontrado.");
        }
    }

//método que utiliza a classe optional para poder utilizar os .filter(),.findFirst(),etc.
    public Optional<Appointment> getAppointmentById(int id) {
        return appointments.stream() //.stream realiza um 'derramamento' de todos os elementos da lista appointments
                .filter(appointment -> appointment.getId() == id) //filtra os ID iguais ao digitado
                .findFirst(); //lista o primeiro compatível
    }

//método que atualiza os dados do compromisso (vide parâmetros)    
    public void editAppointment(Appointment appointment, int newId, String newTitle, String newDescription, LocalDate newDate, LocalTime newTime) {
        appointment.setId(newId);
        appointment.setTitle(newTitle);
        appointment.setDescription(newDescription);
        appointment.setDate(newDate);
        appointment.setTime(newTime);
    }

//método que lista todos os compromissos    
    public Set<Appointment> listAppointments() {
        return appointments;
    }
}

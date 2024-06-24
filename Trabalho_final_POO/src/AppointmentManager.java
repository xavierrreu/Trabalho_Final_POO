import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppointmentManager {
    //criamos com o modificador protected para que subclasses possam manipular a lista diretamente
    protected List<Appointment> appointments; //lista appointments com os parametros da classe Appointment

    //cria uma nova arraylist para reservar os compromissos
    public AppointmentManager() {
        this.appointments = new ArrayList<>();
    } //usamos arraylist como implementação para a lista criada acima

    //metodo pai para adição de compromisso
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    //método pai para remoção de tarefa por meio do id
    public void removeAppointment(int id) {
        appointments.removeIf(appointment -> appointment.getId()==id);
    }

    //método pai para buscar um compromisso pelo ID informado no momento da criação
    public Optional<Appointment> getAppointmentById(int id) {
        return appointments.stream() //.stream cria um fluxo de dados que serão filtrados
                .filter(appointment -> appointment.getId() == id) //filtra pelo id dos dados vindos do fluxo
                .findFirst(); //capta o primeiro encontrado
    }
    public void editAppointment(Appointment appointment, int newId, String newTitle, String newDescription, LocalDate newDate, LocalTime newTime) {
        appointment.setId(newId);//seta um novo id caso seja essa a opção escolhida
        appointment.setTitle(newTitle);//seta um novo titulo caso seja essa a opção escolhida
        appointment.setDescription(newDescription);//seta uma nova descrição caso seja essa a opção escolhida
        appointment.setDate(newDate);//seta uma nova data caso seja essa a opção escolhida
        appointment.setTime(newTime);//seta um novo horario caso seja essa a opção escolhida
    }

    public List<Appointment> listAppointments(){
        return appointments;
    }
}

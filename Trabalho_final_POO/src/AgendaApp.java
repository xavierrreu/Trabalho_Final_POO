import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AgendaApp {
    private Agenda agenda;
    private Scanner scanner;

    public AgendaApp() {
        this.agenda = new Agenda();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        AgendaApp app = new AgendaApp(); //utilizando o agendaapp que é filho do appointManager
        app.showMenu(); //importando o método showMenu, utilizado abaixo
    }

    private void showMenu() {
        int choice;
        do {
            System.out.println("Agenda de Compromissos");
            System.out.println("1. Adicionar Compromisso");
            System.out.println("2. Remover Compromisso");
            System.out.println("3. Listar Compromissos");
            System.out.println("4. Editar Compromissos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addAppointment();
                case 2 -> removeAppointment();
                case 3 -> listAppointments();
                case 4 -> editAppointment();
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (choice != 5);
    }

    private void addAppointment() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Título: ");
        String title = scanner.nextLine();
        System.out.print("Descrição: ");
        String description = scanner.nextLine();
        System.out.print("Data (yyyy-MM-dd): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.print("Hora (HH:mm): ");
        LocalTime time = LocalTime.parse(scanner.nextLine());

        Appointment appointment = new Appointment(id, title, description, date, time);
        agenda.addAppointment(appointment);
        System.out.println("Compromisso adicionado com sucesso.");
    }

    private void removeAppointment() {
        System.out.print("ID do compromisso a remover: ");
        int id = Integer.parseInt(scanner.nextLine());
        agenda.removeAppointment(id);
        System.out.println("Compromisso removido com sucesso.");
    }

    private void listAppointments() {
        List<Appointment> appointments = agenda.listAppointments();
        if (appointments.isEmpty()) {
            System.out.println("Nenhum compromisso encontrado.");
        } else {
            appointments.forEach(System.out::println);
        }
    }

    private void editAppointment() {
        System.out.print("ID do compromisso a editar: ");
        int id = Integer.parseInt(scanner.nextLine());
        //A classe optional é utilizada para manipular valores que podem existir, ou não
        Optional<Appointment> appointmentOpt = agenda.getAppointmentById(id);

        if (appointmentOpt.isPresent()) {
            Appointment appointment = appointmentOpt.get();
            int choice;
            do {
                System.out.println("O que você deseja editar?");
                System.out.println("1. ID do compromisso");
                System.out.println("2. Título do compromisso");
                System.out.println("3. Descrição do compromisso");
                System.out.println("4. Data do compromisso");
                System.out.println("5. Hora do compromisso");
                System.out.println("6. Voltar ao menu");
                System.out.print("Escolha uma opção: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> editID(appointment);
                    case 2 -> editTitle(appointment);
                    case 3 -> editDescription(appointment);
                    case 4 -> editDate(appointment);
                    case 5 -> editTime(appointment);
                    case 6 -> showMenu();
                    default -> System.out.println("Opção inválida.");
                }
            } while (choice != 6);
        } else {
            System.out.println("Compromisso não encontrado.");
        }
    }

    private void editID(Appointment appointment) {
        System.out.print("Novo ID: ");
        int newId = Integer.parseInt(scanner.nextLine());
        appointment.setId(newId);
        System.out.println("ID atualizado com sucesso.");
    }

    private void editTitle(Appointment appointment) {
        System.out.print("Novo título: ");
        String newTitle = scanner.nextLine();
        appointment.setTitle(newTitle);
        System.out.println("Título atualizado com sucesso.");
    }

    private void editDescription(Appointment appointment) {
        System.out.print("Nova descrição: ");
        String newDescription = scanner.nextLine();
        appointment.setDescription(newDescription);
        System.out.println("Descrição atualizada com sucesso.");
    }

    private void editDate(Appointment appointment) {
        System.out.print("Nova data (yyyy-MM-dd): ");
        LocalDate newDate = LocalDate.parse(scanner.nextLine());
        appointment.setDate(newDate);
        System.out.println("Data atualizada com sucesso.");
    }

    private void editTime(Appointment appointment) {
        System.out.print("Nova hora (HH:mm): ");
        LocalTime newTime = LocalTime.parse(scanner.nextLine());
        appointment.setTime(newTime);
        System.out.println("Hora atualizada com sucesso.");
    }

}

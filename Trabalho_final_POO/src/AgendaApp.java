import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.Scanner;

public class AgendaApp {
    private Agenda agenda; //Cria dois atributos privados para serem utilizados pelos construtores e métodos
    private Scanner scanner;

    public AgendaApp() { //construtor que inicializa a classe agenda e o scanner
        this.agenda = new Agenda();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) { //inicializa o AgendaApp e chama o método
        AgendaApp app = new AgendaApp();
        app.showMenu();
    }

    private void showMenu() { //método que exibe o menu e lê a opção
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

            switch (choice) { //switch case que chama os métodos para cada escolha
                case 1 -> addAppointment();
                case 2 -> removeAppointment();
                case 3 -> listAppointments();
                case 4 -> editAppointment();
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (choice != 5); //caso a escolha seja 5, o programa encerra
    }

    private void addAppointment() { //método de que adiciona um novo compromisso
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

        Appointment appointment = new Appointment(id, title, description, date, time); //utiliza os atributos da classe Appointment para criar um novo compromisso
        agenda.addAppointment(appointment);
    }

    private void removeAppointment() { //método que remove um compromisso pelo ID
        System.out.print("ID do compromisso a remover: ");
        int id = Integer.parseInt(scanner.nextLine());
        agenda.removeAppointment(id);
    }

    private void listAppointments() { //método que lista todos os compromissos
        var appointments = agenda.listAppointments();
        if (appointments.isEmpty()) { //checa se a arraylist está vazia
            System.out.println("Nenhum compromisso encontrado.");
        } else {
            appointments.forEach(System.out::println); //percorre a lista e printa os elementos
        }
    }

    private void editAppointment() { //método que edita um compromisso pelo ID
        System.out.print("ID do compromisso a editar: ");
        int id = Integer.parseInt(scanner.nextLine());
        Optional<Appointment> appointmentOpt = agenda.getAppointmentById(id);
        //utilza a classe Optional por causa dos métodos disponíveis (.isPresent(), ifPresent(), etc.)
        
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

                switch (choice) { //switch que chama os métodos para cada escolha
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

    private void editID(Appointment appointment) {//método que edita o ID do compromisso
        System.out.print("Novo ID: ");
        int newId = Integer.parseInt(scanner.nextLine());
        appointment.setId(newId);
        System.out.println("ID atualizado com sucesso.");
    }

    private void editTitle(Appointment appointment) {//método que edita o título do compromisso
        System.out.print("Novo título: ");
        String newTitle = scanner.nextLine();
        appointment.setTitle(newTitle);
        System.out.println("Título atualizado com sucesso.");
    }

    private void editDescription(Appointment appointment) {//método que edita a descrição do compromisso
        System.out.print("Nova descrição: ");
        String newDescription = scanner.nextLine();
        appointment.setDescription(newDescription);
        System.out.println("Descrição atualizada com sucesso.");
    }

    private void editDate(Appointment appointment) {//método que edita a data do compromisso
        System.out.print("Nova data (yyyy-MM-dd): ");
        LocalDate newDate = LocalDate.parse(scanner.nextLine());
        appointment.setDate(newDate);
        System.out.println("Data atualizada com sucesso.");
    }

    private void editTime(Appointment appointment) {//método que edita a hora do compromisso
        System.out.print("Nova hora (HH:mm): ");
        LocalTime newTime = LocalTime.parse(scanner.nextLine());
        appointment.setTime(newTime);
        System.out.println("Hora atualizada com sucesso.");
    }
}


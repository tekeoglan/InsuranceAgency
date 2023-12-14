package com.tekeoglan.insuranceagency;

import java.util.Date;
import java.util.Scanner;

public class InsuranceAgency {

    private AccountManager accountManager;
    private boolean running;

    public InsuranceAgency() {
        this.accountManager = new AccountManager();
    }

    private void addAddress(Scanner scanner) {
        System.out.println("Please enter the address that you want to add.");
        scanner.nextLine();
        String input = scanner.nextLine().trim();
        Address address = this.accountManager.current instanceof EnterpriseAccout ? new BusinessAddress(input) : new HomeAddress(input);
        this.accountManager.current.addAddress(address);
    }

    private void addInsurance(Scanner scanner) {
        System.out.println("Please select one");
        System.out.println("1) Health Insurance");
        System.out.println("2) Car Insurance");
        System.out.println("3) Residence Insurance");
        System.out.println("4) Travel Insurance");
        int input = scanner.nextInt();
        Insurance insurance = null;

        double rate = this.accountManager.current instanceof EnterpriseAccout ? Insurance.ENTERPRISE_RATE : Insurance.INDIVIDUAL_RATE;

        switch (input) {
            case 1:
                insurance = new HealthInsurence(new Date(), new Date(), rate);
                break;
            case 2:
                insurance = new CarInsurance(new Date(), new Date(), rate);
                break;
            case 3:
                insurance = new ResidenceInsurance(new Date(), new Date(), rate);
                break;
            case 4:
                insurance = new TravelInsurance(new Date(), new Date(), rate);
                break;
            default:
                System.out.println("Invalid input");
                break;
        }

        if (insurance != null) {
            this.accountManager.current.addInsurence(insurance);
        }

    }

    public void dashboard(Scanner scanner) {
        while(this.running) {
            System.out.println("Welcome to user dashboard!");
            System.out.println("1) Show user info");
            System.out.println("2) Get a new insurance");
            System.out.println("3) Add a new address");
            System.out.println("4) Exit");
            switch (scanner.nextInt()) {
                case 1:
                    this.accountManager.current.showUserInfo();
                    break;
                case 2:
                    this.addInsurance(scanner);
                    break;
                case 3:
                    this.addAddress(scanner);
                    break;
                case 4:
                    this.running = false;
                    break;
                default:
                    System.out.println("please enter a valid input");
                    break;
            }
        }

    }

    public void register(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Please chose which type of account you want to create:");
        System.out.println("1) Individual  2) Enterprise");
        int type = scanner.nextInt();
        while (type != 1 && type != 2) {
            System.out.println("Please give a valid account type:");
            type = scanner.nextInt();
        }

        System.out.println("Please enter the fallowing fields:");
        System.out.println("First Name:");
        scanner.nextLine();
        String firstName = scanner.nextLine().trim();

        System.out.println("Last Name:");
        String lastName = scanner.nextLine().trim();

        System.out.println("Email:");
        String email = scanner.nextLine().trim();
        while (this.accountManager.isEmailExists(email)) {
            System.out.println("this email is in use, please enter a new one:");
            email = scanner.nextLine().trim();
        }

        System.out.println("Password:");
        String password = scanner.nextLine().trim();

        System.out.println("Job:");
        String job = scanner.nextLine().trim();

        System.out.println("Age:");
        int age = scanner.nextInt();

        User user = new User(firstName, lastName, email, password, job, age);

        Account account = type == 1 ? new IndivudualAccount(user) : new EnterpriseAccout(user);

        this.accountManager.register(account);
        System.out.println("User successfully created.");
    }

    public void login(Scanner scanner) {
        System.out.println("Please enter the fallowing fields:");
        System.out.println("Email:");
        scanner.nextLine();
        String email = scanner.nextLine().trim();

        System.out.println("Password:");
        String password = scanner.nextLine().trim();
        this.accountManager.login(email, password);
        if (this.accountManager.current != null) {
            dashboard(scanner);
        }
    }

    public void run() {
        this.running = true;
        Scanner scanner = new Scanner(System.in);

        while (this.running) {
            System.out.println("Welcome to InsuranceAgency, please an operation to proceed!");
            System.out.println("1- Register");
            System.out.println("2- Login");
            System.out.println("3- Exit");
            switch (scanner.nextInt()) {
                case 1:
                    this.register(scanner);
                    break;
                case 2:
                    this.login(scanner);
                    break;
                case 3:
                    this.running = false;
                    break;
                default:
                    System.out.println("Please give a valid input.");
                    break;
            }
        }

        scanner.close();
    }
}

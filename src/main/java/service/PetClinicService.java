package service;

import model.Consult;
import model.Pet;
import model.Veterinarian;
import repository.ConsultDao;
import repository.PetDao;
import repository.VeterinarianDao;

import java.util.Scanner;

public class PetClinicService {

    public static void main(String[] args) {
        showMenu();
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        System.out.println(option);
        showOption(option);
    }

    public static void showMenu() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - Print choice options.");
        System.out.println("\t 1 - Create");
        System.out.println("\t 2 - Update");
        System.out.println("\t 3 - Delete");
        System.out.println("\t 4 - List/Find");
    }

    public static void showOption(int option) {

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        showOption(option);
        while (!quit) {
            System.out.println("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    showMenu();
                    break;
                case 1:
                    create();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    find();
                    break;
                case 5:
                    quit = true;
                    break;
            }
        }
    }

    public static void showCreateMenu() {
        System.out.println("\t 0 - Veterinarian");
        System.out.println("\t 1 - Pet");
        System.out.println("\t 2 - Consult");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        System.out.println("Ai ales optiunea: " + option);


    }

    public static void create() {
        Scanner scanner = new Scanner(System.in);
        VeterinarianDao veterinarianDao = new VeterinarianDao();
        Veterinarian veterinarian = new Veterinarian();
        veterinarianDao.createVeterinarian(veterinarian);
    }


    public static void update() {
        Scanner scanner = new Scanner(System.in);
        VeterinarianDao veterinarianDao = new VeterinarianDao();
        Veterinarian veterinarian1 = veterinarianDao.findByIdVeterinarian(1L);
        veterinarian1.setFirstName(scanner.nextLine());
        veterinarianDao.updateVeterinarian(veterinarian1);

        ConsultDao consultDao = new ConsultDao();
        Consult consult = consultDao.findByIdConsult(1L);
        consult.setDescription(scanner.nextLine());
        consultDao.updateConsult(consult);

        PetDao petDao = new PetDao();
        Pet pet = petDao.findByIdPet(1L);
        pet.setRace(scanner.nextLine());
        petDao.updatePet(pet);

    }

    public static void delete() {
        Scanner scanner = new Scanner(System.in);
        VeterinarianDao veterinarianDao = new VeterinarianDao();
    }

    public static void find() {
        Scanner scanner = new Scanner(System.in);
        VeterinarianDao veterinarianDao = new VeterinarianDao();
        Veterinarian veterinarian = veterinarianDao.findByIdVeterinarian(1L);
        String veterinarian1 = scanner.nextLine();
        System.out.println(veterinarian1);
    }
}
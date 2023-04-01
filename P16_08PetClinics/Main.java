/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 26.3.2023 г.
 * Time: 9:08
 */
package P16_08PetClinics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = Integer.parseInt(scanner.nextLine());
        List<Pet> pets = new ArrayList<>();
        List<Clinic> clinics = new ArrayList<>();

        for (int i = 0; i < iterations; i++) {
            String input = scanner.nextLine();
            switch (input.split(" ")[0]) {
                case "Create":
                    //clinic and pet
                    String clinicOrPet = input.split(" ")[1];
                    if (clinicOrPet.equals("Pet")) {
                        String name = input.split(" ")[2];
                        int age = Integer.parseInt(input.split(" ")[3]);
                        String kind = input.split(" ")[4];
                        Pet pet = new Pet(name, age, kind);
                        pets.add(pet);
                    } else if (clinicOrPet.equals("Clinic")) {
                        String name = input.split(" ")[2];
                        int rooms = Integer.parseInt(input.split(" ")[3]);
                        try {
                            Clinic clinic = new Clinic(name, rooms);
                            clinics.add(clinic);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Add":
                    String petName = input.split(" ")[1];
                    String clinicName = input.split(" ")[2];
                    if (clinicIsAvalible(clinicName, clinics)) {
                        Clinic clinic = getClinic(clinicName, clinics);
                        if (isPetAvailible(petName, pets)) {
                            Pet pet = getPet(petName, pets);
                            System.out.println(clinic.add(pet));
                        } else {
                            System.out.println("false");
                        }
                    } else {
                        System.out.println("false");
                    }
                    break;
                case "Release":
                    String releaseClinicName = input.split(" ")[1];
                    Clinic clinic = getClinic(releaseClinicName, clinics);
                    System.out.println(clinic.release());
                    break;
                case "HasEmptyRooms":
                    String hasEmptyRoomName = input.split(" ")[1];
                    Clinic forCheck = getClinic(hasEmptyRoomName, clinics);
                    System.out.println(forCheck.hasEmptySpace());
                    break;
                case "Print":
                    //ОСТАВА ДА СЕ ИМПЛЕМЕНТИДА САМО ПРИНТ МЕТОДА ЗА КЛИНИКАТА С ДВА ВАРИАНТА
                    //ВАРИАНТ 1. --> ТРИ ВХОДА ИМЕ И СТАЯ --> ПРИНТИРА СЕ САМО СЪДЪРЖАНИЕТО НА СТАЯТА
                    //ВАРИАНТ 2. --> ДВА ВХОДА САМО ИМЕ --> ПРИНТИРА СЕ ЦЯЛАТА КЛИНИКА
                    //all clinic rooms or single clinic room
                    String[] split = input.split(" ");
                    if (split.length > 2) {
                        String clinicNameForPrint = split[1];
                        int clinicNumberForPrint = Integer.parseInt(split[2]);
                        Clinic clinicForPrint = getClinic(clinicNameForPrint, clinics);
                        clinicForPrint.print(clinicNumberForPrint);
                    } else {
                        String clinicNameForPrint = split[1];
                        Clinic clinicForPrint = getClinic(clinicNameForPrint, clinics);
                        clinicForPrint.print();
                    }
                    break;
            }
        }
    }

    private static Pet getPet(String petName, List<Pet> pets) {
        for (Pet pet : pets) {
            if (pet.getName().equals(petName)) {
                return pet;
            }
        }
        return null;
    }

    private static boolean isPetAvailible(String petName, List<Pet> pets) {
        for (Pet pet : pets) {
            if (pet.getName().equals(petName)) {
                return true;
            }
        }
        return false;
    }

    private static Clinic getClinic(String clinicName, List<Clinic> clinics) {
        for (Clinic clinic : clinics) {
            if (clinic.getName().equals(clinicName)) {
                return clinic;
            }
        }
        return null;
    }

    private static boolean clinicIsAvalible(String clinicName, List<Clinic> clinics) {
        for (Clinic clinic : clinics) {
            if (clinic.getName().equals(clinicName)) {
                return true;
            }
        }
        return false;
    }
}

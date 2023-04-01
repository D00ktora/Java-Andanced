/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 26.3.2023 г.
 * Time: 9:08
 */
package P16_08PetClinics;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Clinic {
    private String name;
    private Map<Integer, Pet> roomsWithPetrs;

    public Clinic(String name, int rooms) {
        if (rooms % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        } else {
            this.name = name;
            roomsWithPetrs = new LinkedHashMap<>();
            for (int i = 1; i <= rooms; i++) {
                roomsWithPetrs.put(i, null);
            }
        }
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Pet> getRoomsWithPetrs() {
        return roomsWithPetrs;
    }

    public boolean add(Pet pet) {
        int clinicCentralRoom = roomsWithPetrs.size() / 2 + 1;
        int clinicLeftIndex = roomsWithPetrs.size() / 2;
        int clinicRightIndex = roomsWithPetrs.size() / 2 + 2;

        if (this.roomsWithPetrs.size() == 1) {
            clinicCentralRoom = 1;
            clinicLeftIndex = 1;
            clinicRightIndex = 1;
        }
        while (clinicLeftIndex >= 0 && clinicRightIndex <= roomsWithPetrs.size()) {
            if (roomsWithPetrs.get(clinicCentralRoom) == null) {
                roomsWithPetrs.put(clinicCentralRoom, pet);
                return true;
            } else if (roomsWithPetrs.get(clinicLeftIndex) == null) {
                roomsWithPetrs.put(clinicLeftIndex, pet);
                return true;
            } else if (roomsWithPetrs.get(clinicRightIndex) == null) {
                roomsWithPetrs.put(clinicRightIndex, pet);
                return true;
            }
            clinicLeftIndex--;
            clinicRightIndex++;
        }
        return false;
    }

    public boolean release() {
        int clinicCentralRoom = roomsWithPetrs.size() / 2 + 1;
        int clinicLeftIndex = roomsWithPetrs.size() / 2;
        int clinicRightIndex = roomsWithPetrs.size() / 2 + 2;

        if (roomsWithPetrs.get(clinicCentralRoom) != null) {
            roomsWithPetrs.put(clinicCentralRoom, null);
            return true;
        }

        for (int i = clinicCentralRoom; i <= roomsWithPetrs.size(); i++) {
            if (roomsWithPetrs.get(i) != null) {
                roomsWithPetrs.put(i, null);
                return true;
            }
        }

        for (int i = 0; i < clinicCentralRoom; i++) {
            if (roomsWithPetrs.get(i) != null) {
                roomsWithPetrs.put(i, null);
                return true;
            }
        }

        return false;
    }

    public boolean hasEmptySpace() {
        for (Pet value : roomsWithPetrs.values()) {
            if (value == null) {
                return true;
            }
        }
        return false;
    }
    
    public void print() {
        for (Map.Entry<Integer, Pet> integerPetEntry : roomsWithPetrs.entrySet()) {
            if (integerPetEntry.getValue() == null) {
                System.out.println("Room empty");
            } else {
                System.out.println(integerPetEntry.getValue());
            }
        }
    }

    public void print(int number) {
        Pet pet = roomsWithPetrs.get(number);
        if (roomsWithPetrs.get(number) == null) {
            System.out.println("Room empty");
        } else {
            System.out.println(pet);
        }
    }

}

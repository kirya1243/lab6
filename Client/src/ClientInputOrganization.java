import Organization.Address;
import Organization.Coordinates;
import Organization.Organization;
import Organization.OrganizationType;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ClientInputOrganization {
    private Organization organization;
    private Coordinates coordinates;
    private Address address;
    private Scanner scanner;
    private boolean isUser;

    public ClientInputOrganization(Scanner scanner, boolean isUser) {
        organization = new Organization();
        coordinates = new Coordinates();
        address = new Address();
        this.scanner = scanner;
        this.isUser = isUser;
    }

    public ClientInputOrganization() {
    }

    public Organization run(){
        inputName();
        inputCoordinates();
        inputAnnualTurnover();
        inputOrganizationType();
        inputAddress();
        return organization;
    }

    public void inputName() {
        while(true) {
            if (isUser) {
                System.out.print("Enter name: ");
            }

            try {
                String name = scanner.nextLine().trim();
                if (name.equals("")) {
                    System.out.println("Name format error");
                    continue;
                }
                organization.setName(name);
                return;
            } catch (NumberFormatException ex) {
                System.out.println("Number format error");
            }
        }
    }
    public void inputCoordinates() {
        Double x = inputCoordinateX();
        Double y = inputCoordinateY();
        coordinates.setX(x);
        coordinates.setY(y);
        organization.setCoordinates(coordinates);
    }
    public Double inputCoordinateX() {
        while (true) {
            if (isUser) {
                System.out.print("Enter x coordinate: ");
            }

            try {
                String x = scanner.nextLine().trim().replace(",", ".");
                if (x.equals("")) {
                    System.out.println("Number format error");
                    continue;
                }
                return Double.valueOf(x);
            } catch (NumberFormatException ex) {
                System.out.println("Number format error");
            }
        }
    }
    public Double inputCoordinateY() {
        while(true) {
            if (isUser) {
                System.out.print("Enter y coordinate: ");
            }

            try {
                String y = scanner.nextLine().trim().replace(",", ".");
                if (y.equals("")) {
                    System.out.println("Number format error");
                    continue;
                }
                return Double.valueOf(y);
            } catch (NumberFormatException ex) {
                System.out.println("Number format error");
            }
        }
    }
    public void inputAnnualTurnover(){
        while(true) {
            if (isUser) {
                System.out.print("Enter Annual Turnover: ");
            }

            try {
                String annualTurnover = scanner.nextLine().trim();
                if (annualTurnover.equals("")) {
                    System.out.println("Name format error");
                    continue;
                }
                organization.setAnnualTurnover(Integer.parseInt(annualTurnover));
                return;
            } catch (NumberFormatException ex) {
                System.out.println("Number format error");
            }
        }
    }
    public void inputOrganizationType(){
        while(true) {
            if (isUser) {
                System.out.println(Arrays.toString(OrganizationType.values()));
                System.out.print("Choose Organization Type: ");
            }

            try {
                String orgType = scanner.nextLine().toUpperCase(Locale.ROOT).trim();
                if (orgType.equals("")) {
                    System.out.println("Name format error");
                    continue;
                }
                organization.setType(OrganizationType.valueOf(orgType));
                return;
            } catch (IllegalArgumentException ex) {
                System.out.println("Number format error");
            }
        }
    }
    public void inputAddress(){
        while(true) {
            if (isUser) {
                System.out.print("Enter address: ");
            }

            try {
                String inAddress = scanner.nextLine().trim();
                if (inAddress.equals("")) {
                    System.out.println("Name format error");
                    continue;
                }
                address.setStreet(inAddress);
                organization.setPostalAddress(address);
                return;
            } catch (NumberFormatException ex) {
                System.out.println("Number format error");
            }
        }
    }
}
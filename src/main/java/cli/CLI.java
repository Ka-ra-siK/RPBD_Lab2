package cli;

import find.*;
import salon.MovingInformation;
import salon.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;

public class CLI {
    private ClientsMapper clientsMapper;
    private MastersMapper mastersMapper;
    private MaterialMapper materialMapper;
    private MovingMapper movingMapper;
    private OrderMapper orderMapper;
    private SpecializationMapper specializationMapper;
    private StaffMapper staffMapper;

    public CLI() throws IOException {
        createCLI();
    }

    public static String write() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        return reader.readLine();
    }


    private void createCLI() throws IOException {
        clientsMapper = new ClientsMapper();
        mastersMapper = new MastersMapper();
        materialMapper = new MaterialMapper();
        movingMapper = new MovingMapper();
        orderMapper = new OrderMapper();
        specializationMapper = new SpecializationMapper();
        staffMapper = new StaffMapper();
        boolean isWorking = true;
        int answer = 0;
        int insideAnswer = 0;

        while (isWorking) {
            chooseMainMenu();
            try {
                answer = Integer.parseInt(write());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            switch (answer) {
                case 1: { // MovingInformation
                    boolean insideMenu = true;
                    while (insideMenu) {
                        menuInsideMovingInformation();
                        try {
                            insideAnswer = Integer.parseInt(write());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        switch (insideAnswer) {
                            case 1: {
                                var movingInformation = movingMapper.findAll();
                                for (int i = 0; i < movingInformation.size(); i++) {
                                    System.out.println((i + 1) + ". " + movingInformation.get(i));
                                }
                                break;
                            } //Write moving information

                            case 2: {
                                MovingInformation movingInformation = new MovingInformation();
                                System.out.println("Write position: ");
                                movingInformation.setPosition(write());
                                System.out.println("Write reason of transfer: ");
                                movingInformation.setTransferReason(write());
                                System.out.println("Write number of order: ");
                                movingInformation.setOrderNumber(Integer.valueOf(write()));
                                System.out.println("Write date of this order (yyyy-mm-dd): ");
                                movingInformation.setOrderDate(Date.valueOf(write()));
                                movingMapper.save(movingInformation);
                                break;
                            } //Add a moving information

                            case 3: {
                                var isEdit = true;
                                var movingInformation = movingMapper.findAll();
                                for (int i = 0; i < movingInformation.size(); i++) {
                                    System.out.println((i + 1) + ". " + movingInformation.get(i));
                                }
                                System.out.print("What moving information you want to edit (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                MovingInformation movingInformationEdit = movingInformation.get(id - 1);
                                while (isEdit) {
                                    movingInformationEdit();
                                    System.out.println("Write what are you want to edit: ");
                                    int editKey = Integer.parseInt(write());
                                    switch (editKey) {
                                        case 1: {
                                            System.out.println("Write new position: ");
                                            movingInformationEdit.setPosition(write());
                                            break;
                                        } // edit Position
                                        case 2: {
                                            System.out.println("Write new transfer reason: ");
                                            movingInformationEdit.setTransferReason(write());
                                            break;
                                        } // edit Transfer reason

                                        case 3: {
                                            System.out.println("Write new number of order: ");
                                            movingInformationEdit.setOrderNumber(Integer.valueOf(write()));
                                            break;
                                        } // edit Order number

                                        case 4: {
                                            System.out.println("Write new date of order (yyyy-mm-dd): ");
                                            movingInformationEdit.setOrderDate(Date.valueOf(write()));
                                            break;
                                        } // edit Date of order

                                        default: {
                                            isEdit = false;
                                            break;
                                        }
                                    }

                                }

                                movingMapper.edit(movingInformationEdit);
                                break;
                            } // Edit a moving information

                            case 4: {
                                var movingInformation = movingMapper.findAll();
                                for (int i = 0; i < movingInformation.size(); i++) {
                                    System.out.println((i + 1) + ". " + movingInformation.get(i));
                                }
                                System.out.print("What moving information you want to delete (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                movingMapper.delete(movingInformation.get(id - 1));
                                break;
                            } //Delete moving information

                            case 5: {
                                boolean isFind = true;
                                while (isFind) {
                                    movingInformationFind();
                                    System.out.println("Write what are you want to find: ");
                                    int infoKey = Integer.parseInt(write());
                                    /*
                                    *  System.out.println("1. Position");
                                        System.out.println("2. Transfer reason");
                                        System.out.println("3. Order number");
                                        System.out.println("4. Date of order");
                                    * */
                                    switch (infoKey) {
                                        case 1: {
                                            System.out.println("Write: ");
                                            var movingInformationFind = movingMapper.findAllByPosition(write());
                                            for (MovingInformation movingInformation : movingInformationFind) {
                                                System.out.println(movingInformation);
                                            }
                                            break;
                                        } // find Position

                                        case 2: {
                                            System.out.println("Write: ");
                                            var movingInformationFind = movingMapper.findAllByTransferReason(write());
                                            for (MovingInformation movingInformation : movingInformationFind) {
                                                System.out.println(movingInformation);
                                            }

                                            break;
                                        }//find Transfer reason

                                        case 3: {
                                            System.out.println("Write: ");
                                            var movingInformationFind = movingMapper.findAllByOrderNumber(write());
                                            for (MovingInformation movingInformation : movingInformationFind) {
                                                System.out.println(movingInformation);
                                            }

                                            break;
                                        }//find Order number

                                        case 4: {
                                            System.out.println("Write: ");
                                            var movingInformationFind = movingMapper.findAlByOrderDate(write());
                                            for (MovingInformation movingInformation : movingInformationFind) {
                                                System.out.println(movingInformation);
                                            }

                                            break;
                                        }//find ODate of order

                                        default: {
                                            isFind = false;
                                            break;
                                        }
                                    }
                                }
                                break;

                            } //  Find field in moving information
                            default: {
                                insideMenu = false;
                                break;
                            }
                        }

                    }


                }
                case 2: { // Staff
                    boolean insideMenu = true;
                    while (insideMenu) {
                        menuInsideStaff();
                        try {
                            insideAnswer = Integer.parseInt(write());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        switch (insideAnswer) {
                            //TODO
                        }

                    }
                    break;


                }
                case 3: { // Masters
                    boolean insideMenu = true;
                    while (insideMenu) {
                        menuInsideMasters();
                        try {
                            insideAnswer = Integer.parseInt(write());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        switch (insideAnswer) {
                            //TODO
                        }

                    }
                    break;

                }
                case 4: { // Materials
                    boolean insideMenu = true;
                    while (insideMenu) {
                        menuInsideMaterials();
                        try {
                            insideAnswer = Integer.parseInt(write());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        switch (insideAnswer) {
                            //TODO
                        }

                    }
                    break;

                }
                case 5: { // Specialization
                    boolean insideMenu = true;
                    while (insideMenu) {
                        menuInsideSpecialization();
                        try {
                            insideAnswer = Integer.parseInt(write());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        switch (insideAnswer) {
                            //TODO
                        }

                    }

                    break;
                }
                case 6: { // Order
                    boolean insideMenu = true;
                    while (insideMenu) {
                        menuInsideOrder();
                        try {
                            insideAnswer = Integer.parseInt(write());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        switch (insideAnswer) {
                            //TODO
                        }

                    }
                    break;

                }
                case 7: { // Client
                    boolean insideMenu = true;
                    while (insideMenu) {
                        menuInsideClients();
                        try {
                            insideAnswer = Integer.parseInt(write());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        switch (insideAnswer) {
                            //TODO
                        }

                    }

                    break;
                }
                default: {
                    isWorking = false;
                    break;
                }
            }
        }
    }

    private void chooseMainMenu() {
        System.out.println("Beauty Salon");
        System.out.println("----------------------");
        System.out.println("1. Moving Information");
        System.out.println("2. Staff");
        System.out.println("3. Masters");
        System.out.println("4. Materials");
        System.out.println("5. Specialization");
        System.out.println("6. Order");
        System.out.println("7. Client");
        System.out.println("0. Exit");
        System.out.println("Enter the item");
    }

    private void menuInsideMovingInformation() {
        System.out.println("Moving Information");
        System.out.println("1. List all moving information");
        System.out.println("2. Add a moving information");
        System.out.println("3. Edit a moving information");
        System.out.println("4. Delete moving information");
        System.out.println("5. Find field in moving information");
        System.out.println("0. Back");
    }

    private void movingInformationEdit() {
        System.out.println("What are you want to edit?");
        System.out.println("1. Position");
        System.out.println("2. Transfer reason");
        System.out.println("3. Order number");
        System.out.println("4. Date of order");
        System.out.println("0. Back");
    }

    private void movingInformationFind() {
        System.out.println("What are you want to find from?");
        System.out.println("1. Position");
        System.out.println("2. Transfer reason");
        System.out.println("3. Order number");
        System.out.println("4. Date of order");
        System.out.println("0. Back");
    }

    private void menuInsideStaff() {
        System.out.println("Staff");
        System.out.println("1. List all staffs");
        System.out.println("2. Add a staff");
        System.out.println("3. Edit a staff");
        System.out.println("4. Delete staff");
        System.out.println("5. Find field in staff");
        System.out.println("0. Back");
    }

    private void menuInsideMasters() {
        System.out.println("Masters");
        System.out.println("1. List all masters");
        System.out.println("2. Add a master");
        System.out.println("3. Edit a master");
        System.out.println("4. Delete master");
        System.out.println("5. Find field in master");
        System.out.println("0. Back");
    }

    private void menuInsideSpecialization() {
        System.out.println("Specialization");
        System.out.println("1. List all specializations");
        System.out.println("2. Add a specialization");
        System.out.println("3. Edit a specialization");
        System.out.println("4. Delete specialization");
        System.out.println("5. Find field in specialization");
        System.out.println("0. Back");
    }

    private void menuInsideMaterials() {
        System.out.println("Materials");
        System.out.println("1. List all materials");
        System.out.println("2. Add a material");
        System.out.println("3. Edit a material");
        System.out.println("4. Delete material");
        System.out.println("5. Find field in material");
        System.out.println("0. Back");
    }

    private void menuInsideOrder() {
        System.out.println("Order");
        System.out.println("1. List all orders");
        System.out.println("2. Add a order");
        System.out.println("3. Edit a order");
        System.out.println("4. Delete order");
        System.out.println("5. Find field in order");
        System.out.println("0. Back");
    }

    private void menuInsideClients() {
        System.out.println("Clients");
        System.out.println("1. List all clients");
        System.out.println("2. Add a client");
        System.out.println("3. Edit a client");
        System.out.println("4. Delete client");
        System.out.println("5. Find field in client");
        System.out.println("0. Back");
    }
}

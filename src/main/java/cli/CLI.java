package cli;

import find.*;
import salon.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;

//TODO добавить множественные связи при добавлении
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
                            case 1: {
                                var staff = staffMapper.findAll();
                                for (int i = 0; i < staff.size(); i++) {
                                    System.out.println((i + 1) + ". " + staff.get(i));
                                }
                                break;
                            } //Write staff

                            case 2: {
                                Staff staff = new Staff();
                                System.out.println("Write name of staff: ");
                                staff.setName(write());
                                System.out.println("Write surname of staff: ");
                                staff.setSurname(write());
                                System.out.println("Write patronymic of staff: ");
                                staff.setPatronymic(write());
                                System.out.println("Write address of staff: ");
                                staff.setAddress(write());
                                System.out.println("Write date of staff's birth (yyyy-mm-dd): ");
                                staff.setBirthDate(Date.valueOf(write()));
                                System.out.println("Write name of staff's position: ");
                                staff.setPosition(write());
                                System.out.println("Write salary of staff: ");
                                staff.setSalary(Integer.valueOf(write()));
                                staffMapper.save(staff);
                                break;
                            } //Add a staff

                            case 3: {
                                var isEdit = true;
                                var staff = staffMapper.findAll();
                                for (int i = 0; i < staff.size(); i++) {
                                    System.out.println((i + 1) + ". " + staff.get(i));
                                }
                                System.out.print("What staff you want to edit (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                Staff staffEdit = staff.get(id - 1);
                                while (isEdit) {
                                    staffEdit();
                                    System.out.println("Write what are you want to edit: ");
                                    int editKey = Integer.parseInt(write());

                                    switch (editKey) {
                                        case 1: {
                                            System.out.println("Write a new surname: ");
                                            staffEdit.setSurname(write());
                                            break;
                                        } //Surname

                                        case 2: {
                                            System.out.println("Write a new name: ");
                                            staffEdit.setName(write());
                                            break;
                                        } //Name

                                        case 3: {
                                            System.out.println("Write a new patronymic: ");
                                            staffEdit.setPatronymic(write());
                                            break;
                                        } // Patronymic

                                        case 4: {
                                            System.out.println("Write a new address: ");
                                            staffEdit.setAddress(write());
                                            break;
                                        } // Address

                                        case 5: {
                                            System.out.println("Write a new date of birth (yyyy-mm-dd): ");
                                            staffEdit.setBirthDate(Date.valueOf(write()));
                                            break;
                                        } // Date of birth

                                        case 6: {
                                            System.out.println("Write a new position: ");
                                            staffEdit.setPosition(write());
                                            break;
                                        } // Position

                                        case 7: {
                                            System.out.println("Write a new staff's salary: ");
                                            staffEdit.setSalary(Integer.valueOf(write()));
                                            break;
                                        } // Salary

                                        default: {
                                            isEdit = false;
                                            break;
                                        }
                                    }

                                }
                                staffMapper.edit(staffEdit);
                                break;
                            }  //Edit a staff

                            case 4: {
                                var staff = staffMapper.findAll();
                                for (int i = 0; i < staff.size(); i++) {
                                    System.out.println((i + 1) + ". " + staff.get(i));
                                }
                                System.out.print("What staff you want to delete (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                staffMapper.delete(staff.get(id - 1));
                                break;
                            } //Delete staff

                            case 5: {
                                boolean isFind = true;
                                while (isFind) {
                                    staffFind();
                                    System.out.println("Write what are you want to find: ");
                                    int infoKey = Integer.parseInt(write());
                                    switch (infoKey) {
                                        case 1: {
                                            System.out.println("Write: ");
                                            var staffFind = staffMapper.findAllBySurname(write());
                                            for (Staff staff : staffFind) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        } // Find Surname

                                        case 2: {
                                            System.out.println("Write: ");
                                            var staffFind = staffMapper.findAllByName(write());
                                            for (Staff staff : staffFind) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        } // Find Name

                                        case 3: {
                                            System.out.println("Write: ");
                                            var staffFind = staffMapper.findAllByPatronymic(write());
                                            for (Staff staff : staffFind) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        } // Find patronymic

                                        case 4: {
                                            System.out.println("Write: ");
                                            var staffFind = staffMapper.findAllByAddress(write());
                                            for (Staff staff : staffFind) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        } // Find address

                                        case 5: {
                                            System.out.println("Write: ");
                                            var staffFind = staffMapper.findAlByBirthDate(write());
                                            for (Staff staff : staffFind) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        } // Find date of birth

                                        case 6: {
                                            System.out.println("Write: ");
                                            var staffFind = staffMapper.findAllByPosition(write());
                                            for (Staff staff : staffFind) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        } // Find position

                                        case 7: {
                                            System.out.println("Write: ");
                                            var staffFind = staffMapper.findAllBySalary(write());
                                            for (Staff staff : staffFind) {
                                                System.out.println(staff);
                                            }
                                            break;
                                        } // Find salary

                                        default: {
                                            isFind = false;
                                            break;
                                        }

                                    }
                                }


                                break;
                            } //  Find field in staff


                            default: {
                                insideMenu = false;
                                break;
                            }
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
                            case 1: {
                                var masters = mastersMapper.findAll();
                                for (int i = 0; i < masters.size(); i++) {
                                    System.out.println((i + 1) + ". " + masters.get(i));
                                }
                                break;
                            } //Write Master

                            case 2: {
                                Masters masters = new Masters();
                                System.out.println("Write surname: ");
                                masters.setSurname(write());
                                mastersMapper.save(masters);
                                break;
                            }//Save master

                            case 3: {
                                var masters = mastersMapper.findAll();
                                for (int i = 0; i < masters.size(); i++) {
                                    System.out.println((i + 1) + ". " + masters.get(i));
                                }
                                System.out.print("What master you want to edit (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                Masters mastersEdit = masters.get(id - 1);
                                System.out.println("Write new position: ");
                                mastersEdit.setSurname(write());
                                mastersMapper.edit(mastersEdit);
                                break;
                            } // Edit master

                            case 4: {
                                var masters = mastersMapper.findAll();
                                for (int i = 0; i < masters.size(); i++) {
                                    System.out.println((i + 1) + ". " + masters.get(i));
                                }
                                System.out.print("What master you want to delete (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                mastersMapper.delete(masters.get(id - 1));
                                break;
                            } //delete master

                            case 5: {
                                boolean isFind = true;
                                while (isFind) {
                                    mastersFind();
                                    System.out.println("Write what are you want to find: ");
                                    int infoKey = Integer.parseInt(write());

                                    switch (infoKey) {
                                        case 1: {
                                            System.out.println("Write: ");
                                            var masterFind = mastersMapper.findAllBySurname(write());
                                            for (Masters masters : masterFind) {
                                                System.out.println(masters);
                                            }
                                            break;
                                        } // find surname

                                        default: {
                                            isFind = false;
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                            default: {
                                insideMenu = false;
                                break;
                            }
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
                            case 1:{
                                var materials = materialMapper.findAll();
                                for (int i = 0; i < materials.size(); i++) {
                                    System.out.println((i + 1) + ". " + materials.get(i));
                                }
                                break;
                            } //Write Materials

                            case 2:{
                                Materials materials = new Materials();
                                System.out.println("Write name of material: ");
                                materials.setName(write());
                                System.out.println("Write unit measurement: ");
                                materials.setUnitMeasurement(write());
                                System.out.println("Write cost: ");
                                materials.setCost(Integer.valueOf(write()));
                                materialMapper.save(materials);
                                break;
                            } //Add a Materials

                            case 3:{
                                var isEdit = true;
                                var materials = materialMapper.findAll();
                                for (int i = 0; i < materials.size(); i++) {
                                    System.out.println((i + 1) + ". " + materials.get(i));
                                }
                                System.out.print("What material you want to edit (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                Materials materialEdit = materials.get(id - 1);

                                while (isEdit){
                                    materialsEdit();
                                    System.out.println("Write what are you want to edit: ");
                                    int editKey = Integer.parseInt(write());
                                    switch (editKey) {
                                        case 1: {
                                            System.out.println("Write new name: ");
                                            materialEdit.setName(write());
                                            break;
                                        } // edit Name
                                        case 2: {
                                            System.out.println("Write new unit measurement: ");
                                            materialEdit.setUnitMeasurement(write());
                                            break;
                                        } // edit unit measurement

                                        case 3: {
                                            System.out.println("Write new cost of material: ");
                                            materialEdit.setCost(Integer.valueOf(write()));
                                            break;
                                        } // edit cost

                                        default: {
                                            isEdit = false;
                                            break;
                                        }
                                    }
                                }
                                materialMapper.edit(materialEdit);
                                break;
                            } //Edit Material

                            case 4:{
                                var materials = materialMapper.findAll();
                                for (int i = 0; i < materials.size(); i++) {
                                    System.out.println((i + 1) + ". " + materials.get(i));
                                }
                                System.out.print("What material you want to delete (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                materialMapper.delete(materials.get(id - 1));
                                break;
                            } //Delete Material

                            case 5:{
                                boolean isFind = true;
                                while (isFind) {
                                    materialsFind();
                                    System.out.println("Write what are you want to find: ");
                                    int infoKey = Integer.parseInt(write());
                                    switch (infoKey) {

                                        case 1:{
                                            System.out.println("Write: ");
                                            var materialFind = materialMapper.findAllByNameMaterial(write());
                                            for (Materials materials : materialFind) {
                                                System.out.println(materials);
                                            }
                                            break;
                                        } //find name

                                        case 2:{
                                            System.out.println("Write: ");
                                            var materialFind = materialMapper.findAllByUnitMeasurement(write());
                                            for (Materials materials : materialFind) {
                                                System.out.println(materials);
                                            }
                                            break;
                                        } //find unit mesurement

                                        case 3:{
                                            System.out.println("Write: ");
                                            var materialFind = materialMapper.findAllByCost(write());
                                            for (Materials materials : materialFind) {
                                                System.out.println(materials);
                                            }
                                            break;
                                        } //find by cost

                                        default: {
                                            isFind = false;
                                            break;
                                        }
                                    }
                                }

                                break;
                            } //Edit material

                            default: {
                                insideMenu = false;
                                break;
                            }
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
                            case 1:{
                                var specialization = specializationMapper.findAll();
                                for (int i = 0; i < specialization.size(); i++) {
                                    System.out.println((i + 1) + ". " + specialization.get(i));
                                }
                                break;
                            } //Write Specialization

                            case 2:{
                                Specialization specialization = new Specialization();
                                System.out.println("Write Specialization");
                                specialization.setName(write());
                                specializationMapper.save(specialization);
                                break;
                            } //Add Specialization

                            case 3:{
                                var specialization = specializationMapper.findAll();
                                for (int i = 0; i < specialization.size(); i++) {
                                    System.out.println((i + 1) + ". " + specialization.get(i));
                                }
                                System.out.print("What specialization you want to edit (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                Specialization specializationEdit = specialization.get(id - 1);
                                System.out.println("Write new name of specialization: ");
                                specializationEdit.setName(write());
                                specializationMapper.edit(specializationEdit);
                                break;
                            } //Edit Specialization


                            case 4:{
                                var specialization = specializationMapper.findAll();
                                for (int i = 0; i < specialization.size(); i++) {
                                    System.out.println((i + 1) + ". " + specialization.get(i));
                                }
                                System.out.print("What specialization you want to delete (0 to exit): ");
                                int id = Integer.parseInt(write());
                                if (id == 0)
                                    break;
                                specializationMapper.delete(specialization.get(id - 1));
                                break;

                            } //Delete Specialization


                            case 5:{
                                boolean isFind = true;
                                while (isFind) {
                                    specializationFind();
                                    System.out.println("Write what are you want to find: ");
                                    int infoKey = Integer.parseInt(write());

                                    switch (infoKey) {
                                        case 1: {
                                            System.out.println("Write: ");
                                            var specializationFind = specializationMapper.findAllByNameOfSpecialization(write());
                                            for (Specialization specialization : specializationFind) {
                                                System.out.println(specialization);
                                            }
                                            break;
                                        } // find name of specialiation
                                        default: {
                                            isFind = false;
                                            break;
                                        }
                                    }
                                }
                                break;

                            } //Find Specialization

                            default: {
                                insideMenu = false;
                                break;
                            }
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

    private void staffEdit() {
        System.out.println("What are you want to edit?");
        System.out.println("1. Surname");
        System.out.println("2. Name");
        System.out.println("3. Patronymic");
        System.out.println("4. Address");
        System.out.println("5. Date of birth");
        System.out.println("6. Position");
        System.out.println("7. Salary");
        System.out.println("0. Back");
    }

    private void staffFind() {
        System.out.println("What are you want to find from?");
        System.out.println("1. Surname");
        System.out.println("2. Name");
        System.out.println("3. Patronymic");
        System.out.println("4. Address");
        System.out.println("5. Date of birth");
        System.out.println("6. Position");
        System.out.println("7. Salary");
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

    private void mastersFind() {
        System.out.println("What are you want to find from?");
        System.out.println("1. Surname");
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

    private void specializationFind() {
        System.out.println("What are you want to find from?");
        System.out.println("1. Name of specialization");
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

    private void materialsEdit() {
        System.out.println("What are you want to edit?");
        System.out.println("1. Name");
        System.out.println("2. Unit measurement");
        System.out.println("3. Cost");
        System.out.println("0. Back");
    }

    private void materialsFind() {
        System.out.println("What are you want to find?");
        System.out.println("1. Name");
        System.out.println("2. Unit measurement");
        System.out.println("3. Cost");
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

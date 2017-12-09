/**
* Java. Level 1. HomeWork5
*
* @author Pavel Bulin
* @version 09.12.2017
* @link https://github.com/PavelBulin/git-repo.git
*/

class HomeWork5 {

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        int i = 0;
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Petrov Petr", "Gardener", "ppetr@email.com", "89876543210", 45000, 35);
        persArray[2] = new Person("Sidorov Gavril", "Electric", "sid_gavril@mailbox.com", "89988776655", 36000, 43);
        persArray[3] = new Person("Nikolaev Nikolay", "Programmer", "niknik@emailbox.com", "89123456789", 50000, 33);
        persArray[4] = new Person("Stepanov Stepan", "Rescuer", "sstepan@mailbox.com", "112", 40000, 44);
        while (i < persArray.length) {
            if (persArray[i].age > 40) {
                persArray[i].PersonCharacter();
                System.out.println();
            }    
            i++;
        }
    }
}

class Person {
    String FIO;
    String profession;
    String email;
    String phone;
    int salary;
    int age;

    Person(String FIO, String profession, String email, String phone, int salary, int age) {
        this.FIO = FIO;
        this.profession = profession;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    void PersonCharacter() {
            System.out.println(FIO);
            System.out.println(profession);
            System.out.println(email);
            System.out.println(phone);
            System.out.println(salary);
            System.out.println(age);
    }
}

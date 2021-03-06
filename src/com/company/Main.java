package com.company;

public class Main {

    public static void main(String[] args) throws RecordNotFound {
	Record phone1 = new Record(1000001, "89619997418", "Kirill");
    Record phone2 = new Record(1000002, "89609547080", "Diana");
    Record phone3 = new Record(1000003, "89619997418", "Hohol");
    Record phone4 = new Record(1000004, "89139065473", "Hohol2");

    PhoneBook book = new PhoneBook();
    try {
        book.createRecord(phone1);
        book.createRecord(phone2);
        book.createRecord(phone3);
        book.createRecord(phone4);
    }catch(PhoneNumberAlreadyExists e){
        System.out.println(e.getMessage());
    }
    System.out.println(book.getAllRecords());
    try {;
        book.updateRecord(new Record(1000001, "89659997400", ""));
    }catch(RecordNotValid e){
        System.out.println(e.getMessage());
        }
    System.out.println(book.getAllRecords());
    book.deleteRecord(12);
    System.out.println(book.getAllRecords());
    }
}
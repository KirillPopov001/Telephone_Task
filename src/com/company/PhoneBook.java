package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {

    private ArrayList<Record> list = new ArrayList<>();

    public PhoneBook(){

    }

    public ArrayList<Record> getAllRecords(){

        return this.list;
    }

    public void createRecord(Record record) throws PhoneNumberAlreadyExists{
        for(Record i: list){
            if(record.getPhoneNumber() == i.getPhoneNumber()) throw new PhoneNumberAlreadyExists("Этот номер телефона уже существует");
        }
        this.list.add(record);
    }

    public void updateRecord(Record record) throws RecordNotFound, RecordNotValid {

        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        String num = in.nextLine();
        System.out.print("Input a name: ");
        String imya = in.nextLine();
        if(num == "" || imya == "") throw new RecordNotValid("Не заполнены имя и/или номер телефона");
        int a = 0;
        for(Record i: list){
            if(i.getId() == record.getId()){
                i.setPhoneNumber(num);
                i.setName(imya);
            }
            a++;
        }
        if (a == list.size()) throw new RecordNotFound("Не существующий номер");
    }

    public void deleteRecord(long id) throws RecordNotFound {
        int a = 0;
        for(Record i: list) {
            if (i.getId() == id) {;
                list.remove(i);
            }
            a++;
        }
        if (a == list.size()) throw new RecordNotFound("Не существующий номер");
    }
}
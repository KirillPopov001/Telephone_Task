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
            if(record.getPhoneNumber().equals(i.getPhoneNumber())) {
                throw new PhoneNumberAlreadyExists("Этот номер телефона уже существует");
            }
        }
        this.list.add(record);
    }

    public void updateRecord(Record record) throws RecordNotFound, RecordNotValid {


        if(record.getName().equals("") || record.getPhoneNumber().equals("")){
            throw new RecordNotValid("Не заполнены имя и/или номер телефона");
        }
        if(record.getName() == null || record.getPhoneNumber() == null) {
            throw new RecordNotValid("Не заполнены имя и/или номер телефона");
        }
        for(Record i: list){
            if(i.getId() == record.getId()){
                i.setPhoneNumber(record.getPhoneNumber());
                i.setName(record.getName());
                return;
            }
        }
        throw new RecordNotFound("Не существующий номер");
    }

    public void deleteRecord(long id) throws RecordNotFound {
        for(Record i: list) {
            if (i.getId() == id) {;
                list.remove(i);
                return;
            }
        }
        throw new RecordNotFound("Не существующий номер");
    }
}
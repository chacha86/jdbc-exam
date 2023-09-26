package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class board {
    static Scanner scan = new Scanner(System.in);
    static AddView addView = new AddView();
    static AddressRepository addressRepository = new AddressRepository();

    public static void main(String[] args) {

        while (true) {

            System.out.print("명령어를 입력해주세요 : ");
            String cmd = scan.nextLine();

            if (cmd.equals("add")) {
                add();
            } else if (cmd.equals("list")) {
                list();
            } else if (cmd.equals("update")) {

            } else if (cmd.equals("exit")) {
                System.out.println("프로그램 종료.");
                break;
            }
        }

    }

    static void list() {
        ArrayList<Address> addressList = addressRepository.getAllAddresses();
        addView.printAddresses(addressList);
    }

    static void add() {

        System.out.print("이름 : ");
        String name = scan.nextLine();
        System.out.print("주소 : ");
        String address = scan.nextLine();
        System.out.print("전화번호 : ");
        String phone = scan.nextLine();

        addressRepository.insert(name, address, phone);
    }


}

package edu.java.contact03;

import java.util.Scanner;

import edu.java.contact.menu.Menu;

// MVC(Model-View-Controller) 아키텍쳐에서 View에 해당하는 클래스.
// UI(User Interface)를 담당하는 클래스.

public class ContactMain03 {
    
    private final Scanner scanner = new Scanner(System.in);
    private final ContactDaoImpl dao = ContactDaoImpl.getInstance();

    public static void main(String[] args) {
        System.out.println("*** 연락처 프로그램 v0.3 ***");
        
        ContactMain03 app = new ContactMain03();
        //-> ContactMain03의 static이 아닌 필드와 메서드들을 사용하기 위해서.

        boolean run = true;
        while (run) {
            int n = app.showMainMenu();
            Menu menu = Menu.getValue(n);
            switch (menu) {
            case QUIT:
                run = false;
                break;
            case CREATE:
                app.insertNewContact();
                break;
            case READ_ALL:
                break;
            case READ_BY_INDEX:
                break;
            case UPDATE:
                break;
            case DELETE:
                break;
            default:
                System.out.println("메인 메뉴 번호를 확인하세요...");
            }
        }
        
        System.out.println("*** 프로그램 종료 ***");
    }
    
    private void insertNewContact() {
        if (!dao.isMemoryAvailable()) { // 배열에 빈 공간이 없으면
            System.out.println("연락처를 저장할 공간이 부족합니다...");
            return;
        }
        // TODO
    }

    private int showMainMenu() {
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println("[0]종료 [1]새 연락처 [2]전체 목록 [3]검색 [4]수정 [5]삭제");
        System.out.println("------------------------------------------------------------");
        System.out.print("선택> ");
        int n = inputNumber();
        
        return n;
    }

    private int inputNumber() {
        while (true) {
            try {
                int n = Integer.parseInt(scanner.nextLine());
                return n;
                
            } catch (NumberFormatException e) {
                System.out.print("정수 입력>> ");
            }
        }
    }

}

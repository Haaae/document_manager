package main.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import main.domain.Status;

public class View {

    private static final Scanner scanner = new Scanner(System.in);

    public static int printRepositoryMenu() {
        System.out.println("=====================================================");
        System.out.println("메뉴");
        System.out.println();
        System.out.println("1. 문서 저장소 목록 보기");
        System.out.println("2. 문서 저장소 선택");
        System.out.println("3. 문서 저장소 생성");
        System.out.println("4. 문서 저장소 삭제");
        System.out.println("5. 프로그램 종료");
        System.out.println();
        System.out.println(": ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String printDeleteRepository() {
        System.out.println("=====================================================");
        System.out.println("문서 저장소 삭제");
        System.out.println("삭제할 문서 저장소의 이름을 입력해주세요(20자 이내).");
        System.out.println();
        System.out.println(": ");
        return scanner.nextLine();
    }
    
    public static String printSelectRepository() {
        System.out.println("=====================================================");
        System.out.println("문서 저장소 선택");
        System.out.println("선택할 문서 저장소의 이름을 입력해주세요(20자 이내).");
        System.out.println();
        System.out.println(": ");

        return scanner.nextLine();
    }

    public static void printStatusList(List<Status> statusList) {
        for (Status status : statusList) {
            System.out.println("No :" + status.getNo()
                    + ". Message : " + status.getMessage());
        }
    }

    public static void printRepositoryList(List<String> repositories) {
        int no = 1;
        for (String repository : repositories) {
            System.out.println(no++ + ". " + repository);
        }
    }

    public static int printStatusMenu() {
        System.out.println("=====================================================");
        System.out.println("문서 저장소 메뉴");
        System.out.println();
        System.out.println("1. 문서 저장소 상태 목록 보기");
        System.out.println("2. 문서 저장소 상태 선택");
        System.out.println("3. 문서 저장소 상태 생성");
        System.out.println("4. 문서 저장소 상태 삭제");
        System.out.println("5. 메뉴로 돌아가기");
        System.out.println();
        System.out.println(": ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String printInsertStatus() {
        System.out.println("=====================================================");
        System.out.println("문서 저장소 상태 생성");
        System.out.println("새로운 문서 저장소 상태의 이름을 입력해주세요(20자 이내).");
        System.out.println();
        System.out.println(": ");
        return scanner.nextLine();
    }

    public static int printDeleteStatus() {
        System.out.println("=====================================================");
        System.out.println("문서 저장소 상태 삭제");
        System.out.println("삭제할 문서 저장소 상태의 번호를 입력해주세요(20자 이내).");
        System.out.println();
        System.out.println(": ");
        return Integer.parseInt(scanner.nextLine());
    }


    public static int printSelectStatus() {
        System.out.println("=====================================================");
        System.out.println("선택할 문서 저장소 상태의 숫자를 입력해주세요.");
        System.out.println();
        return Integer.parseInt(scanner.nextLine());
    }

    public static int printDocumentMenu() {
        System.out.println("=====================================================");
        System.out.println("문서 저장소 메뉴");
        System.out.println();
        System.out.println("1. 문서 목록 보기");
        System.out.println("2. 문서 열람");
        System.out.println("3. 새 문서 생성");
        System.out.println("4. 메뉴로 돌아가기");
        System.out.println();
        System.out.println(": ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<String> printInsertDocument() {
        List<String> lines = new ArrayList<>();
        String temp = "";
        String line = "";

        System.out.println("=====================================================");
        System.out.println("문서 생성");
        System.out.println("생성할 문서의 제목을 입력해주세요(20자 이내).");
        System.out.println();
        System.out.println(": ");
        lines.add(scanner.nextLine());
        System.out.println();
        System.out.println("새 문서의 내용을 입력해주세요(2만 자 이내).");
        System.out.println("(입력 종료 : wq!)");
        System.out.println(": ");

        do {
            line += temp;
            temp = scanner.nextLine();
        } while (!temp.equals("wq!"));
        lines.add(line);
        return lines;
    }

    public static String printDeleteDocument() {

        System.out.println("=====================================================");
        System.out.println("문서 삭제");
        System.out.println("삭제할 문서의 제목을 입력해주세요(20자 이내).");
        System.out.println();
        System.out.println(": ");
        return scanner.nextLine();
    }

    public static String printSelectDocument() {
        System.out.println("=====================================================");
        System.out.println("문서 선택");
        System.out.println("선택할 문서의 제목을 입력해주세요(20자 이내).");
        System.out.println();
        System.out.println(": ");
        return scanner.nextLine();
    }
    
    
    public static void printDocument(String contents) {
        System.out.println("=====================================================");
        System.out.println("문서 선택");
        System.out.println("문서 내용");
        System.out.println(contents);
    }
}

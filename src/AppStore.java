import java.util.Scanner;

public class AppStore {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int id;
        String appName;
        String developer;
        double version;
        int price;
        int choice;

        System.out.print("앱이름을 입력해주세요: ");
        appName = s.nextLine();
        System.out.println("개발자를 입력해주세요: ");
        developer = s.nextLine();
        System.out.println("버전을 입력해주세요: ");
        version = Double.parseDouble(s.nextLine());
        System.out.println("가격을 입력해주세요: ");
        price = Integer.parseInt(s.nextLine());

        System.out.println("***************************************************");
        System.out.println("\t\t\t\t" + "Welcome AppStore");
        System.out.println("***************************************************");
        System.out.println(" 1. 등록된 앱 정보 확인하기 \t4.앱 업데이트");
        System.out.println(" 2. 다운로드된 앱 목록 보기\t5. 앱 삭제하기");
        System.out.println(" 3. 앱검색 및 설치 \t\t6. 결제내역 표시하기");
        System.out.println(" 8. 종료");
        System.out.println("***************************************************");
        System.out.print("메뉴 번호를 선택해주세요 : ");
        choice = s.nextInt();
        System.out.println(choice + "번을 선택했습니다");
    }
}
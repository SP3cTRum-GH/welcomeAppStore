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
        System.out.print("개발자를 입력해주세요: ");
        developer = s.nextLine();
        System.out.print("버전을 입력해주세요: ");
        version = Double.parseDouble(s.nextLine());
        System.out.print("가격을 입력해주세요: ");
        price = Integer.parseInt(s.nextLine());

        boolean stopFlag = false;

        while (!stopFlag) {
            System.out.println("***************************************************");
            System.out.println("\t\t\t\t" + "Welcome AppStore");
            System.out.println("***************************************************");
            System.out.println(" 1. 등록된 앱 정보 확인하기 \t4.앱 업데이트");
            System.out.println(" 2. 다운로드된 앱 목록 보기\t5. 앱 삭제하기");
            System.out.println(" 3. 앱검색 및 설치 \t\t6. 결제내역 표시하기");
            System.out.println(" 7. 종료");
            System.out.println("***************************************************");
            System.out.print("메뉴 번호를 선택해주세요 : ");
            choice = Integer.parseInt(s.nextLine());

            if(choice<1 || 7<choice) {
                System.out.println("1~7까지의 숫자을 입력하세요");
            }else{
                switch(choice){
                    case 1:
                        System.out.println("현재 앱정보");
                        System.out.println("앱이름:"+appName+" 개발자:"+developer+" 앱버전:"+version+" 가격:"+price);
                        break;
                    case 2:
                        System.out.println("2. 다운로드된 앱 목록 보기");
                        break;
                    case 3:
                        System.out.println("3. 앱검색 및 설치");
                        break;
                    case 4:
                        System.out.println("4.앱 업데이트");
                        break;
                    case 5:
                        System.out.println("5. 앱 삭제하기");
                        break;
                    case 6:
                        System.out.println("6. 결제내역 표시하기");
                        break;
                    default:
                        System.out.println("7.종료");
                        stopFlag = true;
                }
            }
        }
    }
}
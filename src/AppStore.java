import java.util.Scanner;

public class AppStore {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        AppStoreManager app = AppStoreManager.getInstence();

        String userName;
        int choice;

        System.out.print("고객 이름을 입력해주세요: ");
        userName = s.nextLine();

        boolean stopFlag = false;

        while (!stopFlag) {
            Menu.menuDisplay();
            System.out.print("메뉴 번호를 선택해주세요 : ");
            choice = Integer.parseInt(s.nextLine());

            if(choice<1 || 7<choice) {
                System.out.println("1~7까지의 숫자을 입력하세요");
            }else{
                switch(choice){
                    case Menu.APPINFO:
                        app.menuGuestInfo(userName);
                        break;
                    case Menu.DOWNLOADAPP:
                        app.showDownloadList();
                        break;
                    case Menu.INSTALLAPP:
                        app.searchInstall();
                        break;
                    case Menu.UPDATEAPP:
                        app.updateApp();
                        break;
                    case Menu.DELETEAPP:
                        app.deleteApp();
                        break;
                    case Menu.RECEIPT:
                        app.receipt();
                        break;
                    default:
                        app.menuExit();
                        stopFlag = true;
                }
            }
        }
    }
}
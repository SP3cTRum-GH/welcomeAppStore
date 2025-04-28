import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppStore {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        AppStoreManager app = AppStoreManager.getInstence();
        List<App> phoneAppList = new ArrayList<>();
        List<App> storeAppList = new ArrayList<>();
        app.loadAppList(storeAppList);
        String userName;
        String phoneNumber;
        int choice;

        System.out.print("고객 이름을 입력해주세요: ");
        userName = s.nextLine();
        System.out.print("연락처를 입력해주세요: ");
        phoneNumber = s.nextLine();
        
        User user = new User(userName, phoneNumber);

        boolean stopFlag = false;

        while (!stopFlag) {
            Menu.clear();
            Menu.menuDisplay();
            try{
            System.out.print("메뉴 번호를 선택해주세요 : ");
            choice = Integer.parseInt(s.nextLine());

            if(choice<1 || 8<choice) {
                System.out.println("1~8까지의 숫자을 입력하세요");
            }else{
                switch(choice){
                    case Menu.APPINFO:
                        app.menuGuestInfo(user);
                        break;
                    case Menu.DOWNLOADAPP:
                        app.showDownloadList(phoneAppList);
                        break;
                    case Menu.INSTALLAPP:
                        app.searchInstall(phoneAppList,user,storeAppList);
                        break;
                    case Menu.UPDATEAPP:
                        app.updateApp(phoneAppList,storeAppList);
                        break;
                    case Menu.DELETEAPP:
                        app.deleteApp(phoneAppList);
                        break;
                    case Menu.RECEIPT:
                        app.receipt(phoneAppList);
                        break;
                    case Menu.ADMINLOGIN:
                        boolean isAdmin = app.adminLogin(user);
                        if(isAdmin){
                            AdminManager adminManager = AdminManager.getInstence();
                            adminManager.adminPage(storeAppList);
                        }
                        break;
                    default:
                        app.menuExit();
                        stopFlag = true;
                }
            }
            }catch(NumberFormatException e){
                System.out.println("숫자를 입력해주세요");
            }
            System.out.println("계속하려면 아무키나 입력해주세요");
            s.nextLine();
        }
    }
}
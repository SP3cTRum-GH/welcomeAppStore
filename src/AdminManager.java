import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class AdminManager {
    private static AdminManager instance = new AdminManager();
    private AdminManager() {
    }

    public static AdminManager getInstence(){
        return instance;
    }

    public void adminPage(List<App> storeList){
        boolean stopFlag = false;
        while(!stopFlag){
            Menu.clear();
            Menu.adminMenu();
            Scanner scan = new Scanner(System.in);
            System.out.print("메뉴 번호를 선택해주세요 : ");
            int choice = Integer.parseInt(scan.nextLine());
            switch(choice){
                case 1:
                    showAppList(storeList);
                    break;
                case 2:
                    addApp(storeList);
                    break;
                case 3:
                    deleteApp(storeList);
                    break;
                case 4:
                    updateApp(storeList);
                    break;
                case 5:
                    stopFlag = true;
                    break;
                default:
                    System.out.println("1~5까지의 숫자을 입력하세요");
            }
            System.out.println("계속하려면 아무버튼을 눌러주세요");
            scan.nextLine();
        }
        System.out.println("관리자화면을 종료합니다.");
    }
    private void showAppList(List<App> storeList){
        for(App app : storeList){
            System.out.println(app);
        }
    }
    private void addApp(List<App> storeList){
        Scanner scan = new Scanner(System.in);
        System.out.print("앱 이름을 입력해주세요: ");
        String appName = scan.nextLine();
        System.out.print("개발자를 입력해주세요: ");
        String developer = scan.nextLine();
        System.out.print("앱 버전을 입력해주세요: ");
        double appVersion = Double.parseDouble(scan.nextLine());
        System.out.print("앱 가격을 입력해주세요: ");
        int appPrice = Integer.parseInt(scan.nextLine());
        App app = new App(appName, developer, appVersion, appPrice);
        storeList.add(app);
        try {
            FileWriter fw = new FileWriter("src/res/appList.txt", true);
            fw.write(appName + "@" + developer + "@" + appVersion + "@" + appPrice + "\n");
            fw.close();
            System.out.println("새 앱을 등록했습니다.");
        } catch (Exception e) { 
            System.out.println(e); 
        }
    }
    private void deleteApp(List<App> storeList){
        Scanner scan = new Scanner(System.in);
        System.out.print("삭제할 앱 이름을 입력해주세요: ");
        String deleteAppName = scan.nextLine();
        boolean isSearch = false;
        for(App app : storeList){
            if(app.getName().equals(deleteAppName)){
                storeList.remove(app);
                System.out.println("앱을 삭제했습니다.");
                isSearch = true;
                break;
            }
        }
        if(!isSearch){
            System.out.println("입력한 앱 이름을 찾을 수 없습니다.");
        }else{
            try {
                FileWriter fw = new FileWriter("src/res/appList.txt", false);
                for(App app : storeList){
                    fw.write(app.getName() + "@" + app.getDeveloper() + "@" + app.getVersion() + "@" + app.getPrice() + "\n");
                }
                fw.close();
            } catch (Exception e) { 
                System.out.println(e); 
            }
        }
    }
    private void updateApp(List<App> storeList){
        showAppList(storeList);
        Scanner scan = new Scanner(System.in);
        System.out.println("어떤 앱을 업데이트 하시겠습니까?");
        String appName = scan.nextLine();
        boolean isSearch = false;
        for(App app : storeList){
            if(app.getName().equals(appName)){
                double appVersion = 0.0;
                int appPrice = 0;
                while (true) {
                    System.out.print("앱 버전을 입력해주세요: ");
                    String input = scan.nextLine();
                    try {
                        appVersion = Double.parseDouble(input);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("잘못된 입력입니다. 숫자(실수)만 입력해주세요.");
                    }
                }
                while (true) {
                    System.out.print("앱 가격을 입력해주세요: ");
                    String input = scan.nextLine();
                    try {
                        appPrice = Integer.parseInt(input);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("잘못된 입력입니다. 숫자(정수)만 입력해주세요.");
                    }
                }
                app.setVersion(appVersion);
                app.setPrice(appPrice);
                System.out.println("앱을 업데이트 했습니다.");
                isSearch = true;
                break;
            }
        }
        if(!isSearch){
            System.out.println("입력한 앱 이름을 찾을 수 없습니다.");
        }else{
            try {
                FileWriter fw = new FileWriter("src/res/appList.txt", false);
                for(App app : storeList){
                    fw.write(app.getName() + "@" + app.getDeveloper() + "@" + app.getVersion() + "@" + app.getPrice() + "\n");
                }
                fw.close();
            } catch (Exception e) { 
                System.out.println(e); 
            }
        }
    }
}

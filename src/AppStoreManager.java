
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppStoreManager {
    private static AppStoreManager instance = new AppStoreManager();
    private AppStoreManager() {
    }

    public static AppStoreManager getInstence(){
        return instance;
    }

    public void menuGuestInfo(String userName, String phoneNumber){
        System.out.println("현재 고객정보");
        User user = new User(userName, phoneNumber);
        System.out.println(user);
    }
    public void showDownloadList(List<App> appList){
        System.out.println("2. 다운로드된 앱 목록 보기");
        for(App app : appList){
            System.out.println(app);
        }
    }
    public void searchInstall(List<App> appList){
        // System.out.println("3. 앱검색 및 설치");
        List<App> storeAppList = new ArrayList<>();
        loadAppList(storeAppList);
        for(App app : storeAppList){
            System.out.println(app);
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("다운받을 앱 이름을 입력해주세요: ");
        String appName = scan.nextLine();
        boolean isSearch = false;
        for(App app : storeAppList){
            if(app.getName().equals(appName)){
                isSearch = true;
                System.out.println(appName+ "앱을 설치하시겠습니까?(y/n).");
                String choice = scan.nextLine().toLowerCase();
                if(choice.equals("y")){
                    System.out.println(appName+ "앱을 설치합니다.");
                    appList.add(app);
                    break;
                }
            }
        }
        if(!isSearch){
            System.out.println("해당 앱은 없습니다.");
        }
    }
    public void updateApp(){
        System.out.println("4.앱 업데이트");
    }
    public void deleteApp(){
        System.out.println("5. 앱 삭제하기");
    }
    public void receipt(){
        System.out.println("6. 결제내역 표시하기");
    }
    public void adminLogin(User user){
        System.out.println("7. 관리자 로그인");
        System.out.println("관리자 정보를 입력하세요");
        Scanner input = new Scanner(System.in);
        System.out.print("아이디 : "); 
        String adminId = input.nextLine();
        System.out.print("비밀번호 : "); 
        String adminPW = input.nextLine();

        Admin admin = new Admin(user.getName(), user.getPhone());
        if (adminId.equals(admin.getId()) && adminPW.equals(admin.getPwd())) { 
            System.out.println("이름 : " + admin.getName() + ", 연락처 : " + admin.getPhone()); 
            System.out.println("아이디 : " + admin.getId() + ", 비밀번호 : " + admin.getPwd());
        } else { 
            System.out.println("관리자 정보가 일치하지 않습니다.");
        }
    }
    public void menuExit(){
        System.out.println("8. 종료");
    }

    private void loadAppList(List<App> appList){
        FileInputStream file;
        try {
            file = new FileInputStream("src/res/appList.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] tokens = line.split("@");
                String appName = tokens[0];
                String developer = tokens[1];
                double appVersion = Double.parseDouble(tokens[2]);
                int appPrice = Integer.parseInt(tokens[3]);
                appList.add(new App(appName, developer, appVersion, appPrice));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("파일을 찾을 수 없습니다.");
        }
    }
}

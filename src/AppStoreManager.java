
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AppStoreManager {
    private static AppStoreManager instance = new AppStoreManager();
    private AppStoreManager() {
    }

    public static AppStoreManager getInstence(){
        return instance;
    }

    public void menuGuestInfo(User user){
        System.out.println("현재 고객정보");
        System.out.println(user);
    }
    public void showDownloadList(List<App> appList){
        System.out.println("2. 다운로드된 앱 목록 보기");
        if(appList.isEmpty()){
            System.out.println("다운로드된 앱이 없습니다.");
        }else{
           pagingPrint(appList);
        }
    }
    public void searchInstall(List<App> appList,User user,List<App> storeAppList){
        // System.out.println("3. 앱검색 및 설치");
        pagingPrint(storeAppList);
        Scanner scan = new Scanner(System.in);
        System.out.print("다운받을 앱 이름을 입력해주세요: ");
        String appName = scan.nextLine();
        boolean isSearch = false;
        for(App app : storeAppList){
            if(app.getName().equals(appName)){
                isSearch = true;
                System.out.print(appName+ "앱을 설치하시겠습니까?(y/n)");
                String choice = scan.nextLine().toLowerCase();
                if(choice.equals("y")){
                    if(app.getPrice() > 0){
                        System.out.print("이 앱은 유료앱입니다. 결제하시겠습니까(y/n) ");
                        String paymentChoice = scan.nextLine().toLowerCase();
                        if(user.getCardNumber() == null){
                            System.out.print("등록된 카드가 없습니다. 카드번호 입력: ");
                            String cardNumber = scan.nextLine();
                            user.setCardNumber(cardNumber);
                        }
                        while(paymentChoice.equals("y")){
                            System.out.println(user);
                            System.out.println("결제정보를 확인해주세요(y/n)");
                            paymentChoice = scan.nextLine().toLowerCase();
                            if(paymentChoice.equals("y")){
                                payment(user.getName(), user.getPhone(), user.getCardNumber());
                                System.out.println(appName+ "앱을 설치합니다.");
                                appList.add(new App(app.getName(),app.getDeveloper(),app.getVersion(),app.getPrice()));
                                break;
                            }else{
                                System.out.print("결제할카드번호 입력: ");
                                String cardNumber = scan.nextLine();
                                user.setCardNumber(cardNumber);
                            }
                        }
                    }else{
                        System.out.println(appName+ "앱을 설치합니다.");
                        appList.add(new App(app.getName(),app.getDeveloper(),app.getVersion(),app.getPrice()));
                        break;
                    }
                }
            }
        }
        if(!isSearch){
            System.out.println("해당 앱은 없습니다.");
        }
    }
    public void updateApp(List<App>downloadList,List<App>storeList){
        System.out.println("4.앱 업데이트");
        List<App>updateable = new ArrayList<>();
        for (App downloadApp : downloadList) {
            for (App storeApp : storeList) {
                if (downloadApp.getName().equals(storeApp.getName()) && downloadApp.getVersion() < storeApp.getVersion()) {
                    System.out.println("업데이트 가능 앱: "+downloadApp);
                    System.out.println("최신 버전:"+storeApp);
                    updateable.add(downloadApp);
                }
                break;
            }
        }
        if(updateable.isEmpty()){
            System.out.println("업데이트 가능한 앱이 없습니다.");
            return;
        }
        System.out.println("어떤 앱을 업데이트 할까요?");
        Scanner scan = new Scanner(System.in);
        String appName = scan.nextLine();
        boolean isSearch = false;
        for (App app : updateable) {
            if (app.getName().equals(appName)) {
                for (App storeApp : storeList) {
                    if (storeApp.getName().equals(appName)) {
                        app.setVersion(storeApp.getVersion());
                        System.out.println(appName + " 앱을 최신 버전으로 업데이트했습니다.");
                        isSearch = true;
                        break;
                    }
                }
                break;
            }
        }
        if (!isSearch) {
            System.out.println("해당 앱은 다운로드 되지 않았습니다.");
        }

    }
    public void deleteApp(List<App> appList){
        System.out.println("5. 앱 삭제하기");
        if(appList.isEmpty()){
            System.out.println("다운로드된 앱이 없습니다.");
        }else{
            for(App app : appList){
                System.out.println(app);
            }
            Scanner scan = new Scanner(System.in);
            System.out.print("삭제할 앱 이름을 입력해주세요: ");
            String appName = scan.nextLine();
            boolean isSearch = false;
            for(App app : appList){
                if(app.getName().equals(appName)){
                    isSearch = true;
                    System.out.println(appName+ "앱을 삭제하시겠습니까?(y/n).");
                    String choice = scan.nextLine().toLowerCase();
                    if(choice.equals("y")){
                        System.out.println(appName+ "앱을 삭제합니다.");
                        appList.remove(app);
                        break;
                    }
                }
            }
            if(!isSearch){
                System.out.println("해당 앱은 다운로드 되지 않았습니다.");
            }
        }
    }
    public void receipt(List<App> appList){
        System.out.println("6. 결제내역 표시하기");
        int totalPrice = 0;
        for(App app : appList){
           if(app.getPrice() > 0){
            System.out.println(app);
            totalPrice += app.getPrice();
           }
        }
        System.out.println("총 결제액 : " + totalPrice);
    }
    public boolean  adminLogin(User user){
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
            return true;
        } else { 
            System.out.println("관리자 정보가 일치하지 않습니다.");
            return false;
        }
    }
    public void menuExit(){
        System.out.println("8. 종료");
    }

    public void loadAppList(List<App> appList){
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

    private void payment(String name, String phone, String cardNumber){
        Date date = new Date(); 
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
        String strDate = formatter.format(date); 
        System.out.println();
        System.out.println("---------------유료 앱 결제 정보----------------");
        System.out.println("고객명 : " +  name + "\t\t 연락처 : " + phone);
        System.out.println("카드번호 : " + cardNumber + "\t 다운로드일 : " + strDate);
    }

    private void pagingPrint(List<App> appList) {
        Scanner scan = new Scanner(System.in);
        int page = 1;
        int pageSize = 5;
        int totalPage = (appList.size() + pageSize - 1) / pageSize;

        while (true) {
            int start = (page - 1) * pageSize;
            int end = Math.min(start + pageSize, appList.size());

            System.out.println("\n[페이지 " + page + "/" + totalPage + "]");
            for (int i = start; i < end; i++) {
                System.out.println(appList.get(i));
            }
            System.out.print("\n이동할 페이지 선택 (n:다음, p:이전, q:종료): ");
            String input = scan.nextLine().toLowerCase();
            if (input.equals("n")) {
                if (page < totalPage) {
                    page++;
                } else {
                    System.out.println("마지막 페이지입니다.");
                }
            } else if (input.equals("p")) {
                if (page > 1) {
                    page--;
                } else {
                    System.out.println("첫 번째 페이지입니다.");
                }
            } else if (input.equals("q")) {
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}

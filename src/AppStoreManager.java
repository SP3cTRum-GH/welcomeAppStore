public class AppStoreManager {
    private static AppStoreManager instance = new AppStoreManager();
    private AppStoreManager() {
    }

    public static AppStoreManager getInstence(){
        return instance;
    }

    public void menuGuestInfo(String userName){
        System.out.println("현재 고객정보");
        System.out.println("고객이름:"+userName);
    }
    public void showDownloadList(){
        System.out.println("2. 다운로드된 앱 목록 보기");
    }
    public void searchInstall(){
        System.out.println("3. 앱검색 및 설치");
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
    public void menuExit(){
        System.out.println("7.종료");
    }
}

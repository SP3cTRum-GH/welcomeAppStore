public interface Menu {
    public static final int APPINFO = 1;
    public static final int DOWNLOADAPP = 2;
    public static final int INSTALLAPP = 3;
    public static final int UPDATEAPP = 4;
    public static final int DELETEAPP = 5;
    public static final int RECEIPT = 6;
    public static final int ADMINLOGIN = 7;
    public static final int EXIT = 8;

    public static void menuDisplay() {
        System.out.println("***************************************************");
        System.out.println("\t\t\t\t" + "Welcome AppStore");
        System.out.println("***************************************************");
        System.out.println(" 1. 고객정보 확인하기 \t\t4.앱 업데이트");
        System.out.println(" 2. 다운로드된 앱 목록 보기\t5. 앱 삭제하기");
        System.out.println(" 3. 앱검색 및 설치 \t\t6. 결제내역 표시하기");
        System.out.println(" 7. 관리자 로그인 \t\t\t8. 종료");
        System.out.println("***************************************************");
    }
    public static void adminMenu(){
        System.out.println("***************************************************");
        System.out.println("\t\t\t\t" + "Admin Page");
        System.out.println("***************************************************");
        System.out.println("\t\t\t" +" 1. 앱 목록 보기");
        System.out.println("\t\t\t" +" 2. 앱 추가");
        System.out.println("\t\t\t" +" 3. 앱 삭제");
        System.out.println("\t\t\t" +" 4. 앱 정보 업데이트");
        System.out.println("\t\t\t" +" 5. 종료");
        System.out.println("***************************************************");
    }

    public static void clear() {
        try {
            String operatingSystem = System.getProperty("os.name");
            ProcessBuilder pb;
            Process startProcess;
            if (operatingSystem.contains("Windows")) {
                pb = new ProcessBuilder(new String[]{"cmd", "/c", "cls"});
                startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                pb = new ProcessBuilder(new String[]{"clear"});
                startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            }
        } catch (Exception var3) {
            System.out.println(var3);
        }
    }
}


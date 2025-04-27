public interface Menu {
    public static final int APPINFO = 1;
    public static final int DOWNLOADAPP = 2;
    public static final int INSTALLAPP = 3;
    public static final int UPDATEAPP = 4;
    public static final int DELETEAPP = 5;
    public static final int RECEIPT = 6;
    public static final int EXIT = 7;

    public static void menuDisplay() {
        System.out.println("***************************************************");
        System.out.println("\t\t\t\t" + "Welcome AppStore");
        System.out.println("***************************************************");
        System.out.println(" 1. 고객정보 확인하기 \t4.앱 업데이트");
        System.out.println(" 2. 다운로드된 앱 목록 보기\t5. 앱 삭제하기");
        System.out.println(" 3. 앱검색 및 설치 \t\t6. 결제내역 표시하기");
        System.out.println(" 7. 종료");
        System.out.println("***************************************************");
    }
}


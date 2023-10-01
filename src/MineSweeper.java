import java.util.Random;
import java.util.Scanner;
public class MineSweeper {

    int row;
    int col;
    String [][] board;
    int totalMine;
    String [][] newBoard;
    boolean isGameOver;

    MineSweeper(int row, int col) {

        this.row = row;
        this.col = col;
        this.board = new String[row][col];
        this.totalMine = (row) * (col) / 4;
    }

    public void Run() {
        // Oyunu oynayabilmek için en az 2x2 büyüklüğünde bir board oluşturuluyor.
        if (row > 1 && col > 1) {
            LayMines();
            System.out.println(" MAYIN TARLASI OYUNUNA HOŞGELDİNİZ!");
            PrintBoard();
            isGameOver = false;

            while (!isGameOver && !IsWin()) {
                SelectCoordinates();
            }
            // Değerlendirme 15 : Oyunu kaybetme ya da kazanma durumunda uygun mesajlar bu kısımda veriliyor.
            if (IsWin()) {
                System.out.println("TEBRİKLER! OYUNU KAZANDINIZ!");
            } else {
                System.out.println("OYUNU KAYBETTİNİZ!");
            }
        } else {
            System.out.println("Lütfen geçerli sayılar giriniz.");
        }
    }

    // Değerlendirme formu 8: Diziye boyutunun 4'te 1'i kadar mayın aşağıdaki method ile yerleştiriliyor.
    public void LayMines() {
        this.newBoard = new String[this.row][this.col];
        Random random = new Random();
        for (int i = 1; i <= this.totalMine; i++) {
            int randomRow;
            int randomCol;
            do {
                randomRow = random.nextInt(this.row);
                randomCol = random.nextInt(this.col);

            } while (newBoard[randomRow][randomCol] != null) ;
               this.newBoard[randomRow][randomCol] = " * ";
        }
        System.out.println("MAYINLARIN KONUMU");
        for (int j = 0; j < (this.row); j++){
            for (int k = 0; k < (this.col); k++){
                if (this.newBoard[j][k] == null) {
                    this.newBoard[j][k] = " - ";
                }
                System.out.print(newBoard[j][k]);
            }
            System.out.println();
        }
        System.out.println("===================");
    }
    public void SelectCoordinates()  {
        Scanner input = new Scanner(System.in);
        int x, y;


        // Değerlendirme 9 : Kullanıcıdan işaretlemek istediği satır ve sütun sayısı bilgisi burada alınıyor.
        do {
            System.out.print("Satır giriniz(0'dan başlayarak): ");
            x = input.nextInt();
            System.out.print("Sütun giriniz(0'dan başlayarak): ");
            y = input.nextInt();


            // Değelendirme 10: Seçilen koordinatın dizi sınırları içinde olup olmadığı bu kısımda kontrol ediliyor.
            if ((x < 0 || x >= this.row) || (y < 0 || y >= this.col)) {
                System.out.println("Hatalı giriş yaptınız!");
            } else if (this.newBoard[x][y].equals(" * ")) {
                System.out.println("===> GAME OVER <===");
                isGameOver = true;  // Değerlendirme 13 : Kullanıcı mayına bastığında isGameOver değişkeni ile kontrol sağlanıyor.
                return;
            }

        } while (!(x >= 0 && x < this.row) || !(y >= 0 && y < this.col));
        System.out.println("===================");


        // Değerlendirme 12 : Girilen noktada mayın yoksa etraftaki mayın sayısı burada hesaplanıyor.
        int count = 0;
        for (int i = Math.max(0, x-1); i <= Math.min(this.row-1, x+1); i++){
            for (int j = Math.max(0, y-1); j <= Math.min(this.col-1, y+1); j++) {
                if (this.newBoard[i][j].equals(" * ")) {
                    count++;
                }
            }
        }
        String countString = String.valueOf(count);
        this.board[x][y] = " "+countString+" ";
        PrintBoard();  // Değerlendirme 11 : Kullanıcı her hamle yaptığında oyun boardu burada güncelleniyor.
    }

    // Kullanıcının ekranda göreceği board PrintBoard methodu içine yazıldı.
    public void PrintBoard() {
        for (int i = 0; i < this.row; i++){
            for (int j = 0; j < this.col; j++){
                if (this.board[i][j] == null){
                System.out.print(this.board[i][j] = " - ");
                } else {
                    System.out.print(this.board[i][j]);
                }
            }
            System.out.println();
        }
    }

    // Değerlendirme 14 : Tüm noktalar mayınsız bir şekilde seçilirse oyunu kazanma kontrolu IsWin methodu ile yapılıyor.
    public boolean IsWin() {
        int nullValue = 0;
        for (int i=0; i < this.row; i++) {
            for (int j=0; j < this.col; j++) {
                if (this.board[i][j] == " - ") {
                    nullValue++;
                }
            }
        }
        return nullValue == this.totalMine;
    }
}
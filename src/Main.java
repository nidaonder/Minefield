import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        // Değerlendirme formu 7: Matris boyutu kullanıcı tarafından belirleniyor.
        Scanner input = new Scanner(System.in);
        System.out.print("Oynamak istediğiniz board'un satır sayısını giriniz: ");
        int row = input.nextInt();
        System.out.print("Oynamak istediğiniz board'un sütün sayısını giriniz: ");
        int col = input.nextInt();

        MineSweeper game = new MineSweeper(row, col);
        game.Run();
    }
}
import java.util.Scanner;
public class Area {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three elements:");
        int[] abh = new int[3];
        for (int i = 0; i < 3; i++) {
            abh[i] = scanner.nextInt();
        }
        System.out.println("Enter the elements:");
        int[] wq=new int[2];
        for (int i = 0; i < 2; i++) {
            wq[i] = scanner.nextInt();
        }
        System.out.println("Enter the elements:");
        int[] sp=new int[2];
        for (int i = 0; i < 2; i++) {
            sp[i] = scanner.nextInt();
        }
        System.out.println("Enter the k:");
        int k=scanner.nextInt();

        int area= ((abh[0]*abh[2])+(abh[1]*abh[2]))*2;
        int area_door=wq[0]*wq[1];
        int area_window=sp[0]*sp[1];
        int s=area-(area_door+area_window);
        int banks=s/k;
        System.out.print("Банки нужные для покраски дома: "+banks);

        }
}

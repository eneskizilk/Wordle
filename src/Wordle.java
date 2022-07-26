import java.io.*;
import java.util.Random;

public class Wordle {

    public static void main(String[] args) {
        File dict = new File("C:\\Users\\Enes\\Desktop\\wordle\\Wordle in vscode\\src\\dict.txt");
        try {

            String[] myArray = new String[2317];
            FileReader fr = new FileReader(dict);
            BufferedReader bf = new BufferedReader(fr);

            int flag = 0;
            int flag_2 = 0;
            boolean flag_3 = false;
            boolean flag_4;

            while (flag < 2317){
                myArray[flag] = bf.readLine();
                flag++;
            }

            Random rand = new Random();
            int rand_int1 = rand.nextInt(2317);
            String keyword = myArray[rand_int1];



            char[] ch = keyword.toCharArray();
            int x = 0;
            System.out.println();
            while (flag_2 < args.length && x < 6 ){
                if (args[flag_2].length() != 5){
                    System.out.println("The length of word must be five!");
                    System.out.println("please change "+ (flag_2 + 1) +". word " + "("+args[flag_2]+")");
                    break;
                }

                for(int i = 0;i <2317;i++){
                    if (args[flag_2].equals(myArray[i])) {
                        flag_3 = true;
                        break;
                    }
                }

                if (!flag_3){
                    System.out.println("Word does not exist in the dictionary!");
                    System.out.println("("+ args[flag_2] +")");
                }
                else {
                    char[] char1 = args[flag_2].toCharArray();
                    for (int i = 0; i < ch.length; i++) {
                        flag_4 = false;
                        if (char1[i] == ch[i]){
                            System.out.println(char1[i]);
                            System.out.println("letter exists and located in right position.");
                        }else {
                            for (char c : ch) {
                                if (char1[i] == c) {
                                    System.out.println(char1[i]);
                                    System.out.println("letter exists but located in wrong position.");
                                    break;
                                }
                            }

                            for (char c : ch) {
                                if (char1[i] == c) {
                                    flag_4 = true;
                                    break;
                                }
                            }

                            if (!flag_4){
                                System.out.println(char1[i]);
                                System.out.println("letter does not exist.");
                            }
                        }
                    }
                    System.out.println();
                    System.out.println();
                }
                if(args[flag_2].equals(keyword)){
                    System.out.println("Congratulations! You guess right in " + x+1 +".th shot!");
                    break;
                }

                flag_2++;
                flag_3 = false;
                x++;
                if (x == 6){
                    System.out.println("You Lose ");
                    System.out.println("The word is "+ keyword);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

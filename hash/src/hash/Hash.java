
package hash;
import java.util.Scanner;

public class Hash {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        
        String[] Names = {"a","Bob","Robert","Sam","Zander","Ruan","Pietter","John","Loki","Samual","Xander","Aatrox","Yumi"};
        
        System.out.println("Loading into memory...");       
        for (String Name : Names) {
            hashTable.hashMap(Name, hashTable.hashKey(Name));
        }
        System.out.println("Done.");
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter text to be searched");
        String userInput = input.nextLine();
        input.close();

        System.out.println(hashTable.hashStringValueExist(userInput));

    }    
    
}

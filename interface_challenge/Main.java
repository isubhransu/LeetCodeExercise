package interface_challenge;

/**
 * Created by subhransumishra on 6/2/16.
 */
public class Main {
    public static void main(String[] args){
        Player play = new Player("Bitch have my money", 3, 4);
        writeData(play);
    }

    public static void writeData(ISample SaveVal){
        for(int i=0; i<SaveVal.write().size(); i++){
            System.out.println("Saving "+SaveVal.write().get(i)+" to the device");
        }
    }
}

package pluralsight;



public class DealershipApp {

    public static void main(String[] args) {
       try{
        UserInterface userInterface = new UserInterface();
        userInterface.showMainMenu();
       }catch (Exception e){
           System.out.println("mistakes were made....");
       }
    }
}
